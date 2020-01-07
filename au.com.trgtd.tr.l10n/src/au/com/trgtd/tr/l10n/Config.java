/*
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can get a copy of the License at http://www.thinkingrock.com.au/cddl.html
 * or http://www.thinkingrock.com.au/cddl.txt.
 *
 * When distributing Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://www.thinkingrock.com.au/cddl.txt.
 * If applicable, add the following below the CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * The Original Software is ThinkingRock. The Initial Developer of the Original
 * Software is Avente Pty Ltd, Australia.
 *
 * Portions Copyright 2006-2009 Avente Pty Ltd. All Rights Reserved.
 */
package au.com.trgtd.tr.l10n;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.util.Exceptions;

/**
 * Startup configuration file manager.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class Config {
    private static final Logger log = Logger.getLogger(Config.class.getName());
    private static final String CONFIG_FILENAME = "tr.conf";
    private static final String OPTION_KEY_LOCALE = "--locale";

    private static Config instance;

    public static Config getDefault() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }    
    
    private String location;

    private Config() {
        initLocation();        
    }

    private int defaultOptionIndex(String key) {
        if (!existsConfigFile()) {
            return -1;
        }        
        
        log.info("Key: " + key);                        
        
        if (key == null) {
            return -1;
        }
        
        int index = 0;                
        for (String option : defaultOptionsRead()) {            
             log.info("Option: " + option);                        
            
            if (option.startsWith(key)) {
                return index;
            }        
             
            index++;
        }
        
        return -1;
    }    

    private String getLocaleValue(String langCode, String countryCode) {
        if (langCode == null || langCode.length() != 2) {
            return null;
        }
        if (countryCode == null || countryCode.length() != 2) {
            return langCode;
        }
        return langCode + ":" + countryCode;
    }
    
    public void setLocale(String langCode, String countryCode) { 
        if (!existsConfigFile()) {
            return;
        }                
        String localeValue = getLocaleValue(langCode, countryCode);
        if (localeValue == null) {
            log.info("Locale: null");
            return;
        }
        
        String locale = OPTION_KEY_LOCALE + " " + localeValue;
        
        int index = defaultOptionIndex(OPTION_KEY_LOCALE);
        if (index == -1) {
            log.info("Adding locale: " + locale);
            defaultOptionAdd(locale);                
        } else {
            log.info("Replacing locale to: " + locale);
            defaultOptionReplace(index, OPTION_KEY_LOCALE + " " + localeValue);                
        }
    }    
    
    public void removeLocale() {  
        if (!existsConfigFile()) {
            return;
        }                        
        int index = defaultOptionIndex(OPTION_KEY_LOCALE);
        if (index == -1) {
            log.info("No locale option to remove.");                        
            return;
        }
        log.info("Removing locale option.");            
        defaultOptionRemove(index);
    }        
    
    /**
     * Add a new NetBeans startup parameter.
     * @param para the new parameter to be added
     */
    public void defaultOptionAdd(String option) {
        if (!existsConfigFile()) {
            return;
        }        
        List<String> options = defaultOptionsRead();
        options.add(option);
        defaultOptionsWrite(options);
    }

    /**
     * Replace a NetBeans startup parameter.
     * @param index parameter index
     * @param newValue the new parameter value
     */
    public void defaultOptionReplace(int index, String newValue) {
        if (!existsConfigFile()) {
            return;
        }                
        List<String> options = defaultOptionsRead();
        if (index >= options.size()) {
            return;
        }
        options.set(index, newValue);
        defaultOptionsWrite(options);
    }

    /**
     * Remove a NetBeans startup parameter.
     * @param index a parameter to be deleted
     */
    public void defaultOptionRemove(int index) {
        if (!existsConfigFile()) {
            return;
        }                
        List<String> options = defaultOptionsRead();
        if (index >= options.size()) {
            return;
        }
        options.remove(index);
        defaultOptionsWrite(options);
    }

    /**
     * Backup configuration file in the same path with original.
     */
    public void backupConfigFile() {
        if (!existsConfigFile()) {
            return;
        }        
        InputStream inFile = null;
        OutputStream outFile = null;
        try {
            inFile = new FileInputStream(location);
            outFile = new FileOutputStream(location + ".backup");
            org.openide.filesystems.FileUtil.copy(inFile, outFile);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        } finally {
            try {
                inFile.close();
                outFile.close();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    /**
     * Determine whether or not the conf file is backed up.
     * @return true iff a backup file exists.
     */
    public boolean isConfigFileBackedUp() {
        File backup = new File(location + ".backup");
        return backup.exists();
    }
    
    /**
     * Get the configuration backup file.
     * @return the backup file.
     */
    public File getBackupFile() {
        File backup = new File(location + ".backup");
        if (backup.exists()) {
            return backup;
        } else {
            log.warning("Missing config backup file: " + backup.getPath());
            return null;
        }
    }

    /**
     * Get the configuration file.
     * @return the configuration file if it exists, otherwise null
     */
    public File getConfigFile() {
        File file = new File(location);        
        if (file.isFile()) {
            return file;
        } else {
            log.severe("Missing configuration file: " + location);
            return null;
        }
    }

    private boolean existsConfigFile() {
        return getConfigFile() != null;
    }
    
    /**
     * Get the configuration file location.
     * @return {@link #location}
     */
    public String getLocation() {
        return location;
    }

    /**
     * Get all values described in "netbeans_default_options", conf file.
     * @return if netbeans_default_options="-J-client -J-Xss16m -J-Xms128m -J-XX:PermSize=256m <b>--fontsize 10</b> ...", 
     * return a list like this: {"-J-client", "-J-Xss16m", "-J-Xms128m", "-J-XX:PermSize=256m", <b>"--fontsize 10"</b>...}
     */
    public List<String> defaultOptionsRead() {
        if (!existsConfigFile()) {
            return Collections.emptyList();
        }        
        String[] allOptions = getParameters().getProperty("default_options").split("\\s");
        int last = allOptions.length - 1;
        // remove the first double quotation
        allOptions[0] = allOptions[0].substring(1, allOptions[0].length());
        // remove the last double quotation
        allOptions[last] = allOptions[last].substring(0, allOptions[last].length() - 1);
        List<String> ret = new ArrayList<String>(); 

        for (int i = 0; i < allOptions.length; i++) {
            String item = allOptions[i];
            // confirm the startup parameter's beginning
            if (item.length() >= 2) {
                String beginning = item.substring(0, 2);

                if (beginning.equals("-J")) {
                    // JVM Parameters
                    ret.add(item);
                } else if (beginning.equals("--")) {
                    // IDE Parameters
                    if (item.startsWith("--laf")) {
                        // --laf ui_class_name: Use a given class as the IDE's look and feel.
                        ret.add(item + " " + allOptions[i + 1]);
                    } else if (item.startsWith("--fontsize")) {
                        // --fontsize size: Use a given size in points as the basic font size for the IDE user interface.
                        ret.add(item + " " + allOptions[i + 1]);
                    } else if (item.startsWith("--locale")) {
                        // --locale locale: Use a locale.
                        ret.add(item + " " + allOptions[i + 1]);
                    }                                        
                } else {
                    // TODO other's conditions
                }
            }
        }

        return ret;
    }

    /**
     * Get JDK HOME by NetBeans using.
     * @return the JDK HOME path, such as "/usr/lib/jvm/java-6-sun/"
     */
    public String getJDKHome() {
        if (!existsConfigFile()) {
            return null;
        }                
        String prop = getParameters().getProperty("netbeans_jdkhome");
        if (prop == null) {
            return null;
        }
        // remove the double quotation
        return prop.substring(1, prop.length() - 1);
    }

    /**
     * Get all startup parameters in conf file. Every parameter like this:
     * <p>
     * -J-Xss16m
     * -J-XX:PermSize=256m
     * -J-Xverify:none
     * --laf javax.swing.plaf.metal.MetalLookAndFeel
     * --fontsize 10
     * </p>
     * @return
     */
    public Properties getParameters() {        
        if (!existsConfigFile()) {
            return new Properties();
        }                
        Properties props = new Properties();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(getConfigFile()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line == null || line.equals("") || line.charAt(0) == '#') {
                    continue;
                }
                String key = line.substring(0, line.indexOf('='));
                String value = line.substring(line.indexOf('=') + 1, line.length());
                props.setProperty(key, value);
            }
        } catch (IOException ioe) {
            log.log(Level.SEVERE, "Could not read config file.", ioe);            
        }
        return props;
    }

    /**
     * Set NetBEans JDK Home path.
     * <p>
     * NOTE: the specified  jdkHome path is full path withou double quotation.
     * , such as <center>/usr/lib/jvm/java-6-sun/</center>
     * </p>
     * @param jdkHome JDK Home path
     */
    public void setJDKHome(String jdkHome) {
        if (getConfigFile() == null) {
            return;
        }
        Properties paras = getParameters();
        paras.setProperty("netbeans_jdkhome", "\"" + jdkHome + "\"");
        setParameters(paras);
    }

    /**
     * Persist NetBeans Options.
     * @param options options list
     */
    private void defaultOptionsWrite(List<String> options) {
        Properties props = getParameters();
        String optionsStr = "";
        for (String option : options) {
            optionsStr += option + " ";
        }
        optionsStr = optionsStr.trim();

        props.setProperty("default_options", "\"" + optionsStr + "\"");
        setParameters(props);
    }

    /**
     * Set all startup parameters in conf file.
     * @param paras the parameters store by a <code>Properties<code>
     */
    private void setParameters(Properties paras) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(location));
            writer.write("### ThinkingRock Configuration File ###");
            writer.newLine();
            Enumeration<?> keys = paras.propertyNames();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String value = paras.getProperty(key);
                writer.write(key + "=" + value);
                writer.newLine();
            }
            writer.close();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    /**
     * Initialize conf file location.
     */
    private void initLocation() {
        location = System.getProperty("netbeans.home");
        // remove "/platform8"
        location = location.substring(0, location.lastIndexOf(File.separator));
        location += File.separator + "etc" + File.separator + CONFIG_FILENAME;

        log.info("LOCATION netbeans.home: " + location);

//        // Alternatively:        
//        // locate directory ../tr/tr/core
//        File coreDir = InstalledFileLocator.getDefault().locate("core", null, false);
//        if (coreDir == null) {
//            LOG.info("Installation directory could not be found.");
//            return;
//        }
//        File confFile = new File(coreDir.getParentFile().getParentFile(), "etc/tr.conf");
//        if (confFile == null) {
//            LOG.info("Configuration file could not be found.");
//            return;            
//        }        
//        LOG.info("Configuration file is: " + confFile.getPath());

        // TODO OS settings
        //System.out.println(org.openide.util.Utilities.isUnix());
        //System.out.println(org.openide.util.Utilities.isWindows());
    }
    
}