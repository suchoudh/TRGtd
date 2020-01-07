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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import org.netbeans.api.autoupdate.UpdateUnitProvider;
import org.netbeans.api.autoupdate.UpdateUnitProviderFactory;

/**
 * ThinkingRock member utilities.
 * 
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class L10nUtils {

    private static final Logger LOG = Logger.getLogger("au.com.trgtd.tr.l10n");
    private static final String UC_ID = "tr-l10n-uc";
    private static final String UC_DISPLAY = "ThinkingRock %locale_display% Update Center";       
    private static final String UC_URL = "http://www.trgtd.com.au/autoupdate/2.2/l10n/%locale_code%/updates.xml";
    
    private static L10nUtils instance;
    
    public static L10nUtils getDefault() {
        if (instance == null) {
            instance = new L10nUtils();
        }
        return instance;
    }

    private L10nUtils() {
    }    
    
    public void setLocale(Locale locale) {
        if (locale == null || locale == Locale.none) {
            removeUpdateCenter();
            Config.getDefault().removeLocale();            
        } else {
            UpdateUnitProvider uup = getUpdateCenter();
            if (uup == null) {
                createUpdateCenter(locale);
            }
            else {
                uup.setDisplayName(getDisplayName(locale));
                uup.setProviderURL(getURL(locale));
            }
            Config.getDefault().setLocale(locale.language, locale.country);            
        }
    }

    private URL getURL(Locale locale) {
        assert(locale != null && locale != Locale.none);
        
        String urlString = UC_URL.replace("%locale_code%", locale.name());        
        try {
            return new URL(urlString);
        } catch (MalformedURLException ex) {
            LOG.severe("MalformedURLException for: " + urlString);                
            return null;
        }        
    }

    private String getDisplayName(Locale locale) {
        assert(locale != null && locale != Locale.none);
        
        return UC_DISPLAY.replace("%locale_display%", locale.display);        
    }
        
    private UpdateUnitProvider getUpdateCenter() {
        UpdateUnitProviderFactory f = UpdateUnitProviderFactory.getDefault();         
        for (UpdateUnitProvider uup : f.getUpdateUnitProviders(false)) {
            if (uup.getName().equals(UC_ID)) {
                return uup;
            }
        }        
        return null;
    }
    
    private UpdateUnitProvider createUpdateCenter(Locale locale) {
        LOG.info("Creating TR update center created for: " + getDisplayName(locale));                
        return UpdateUnitProviderFactory.getDefault().create(UC_ID, getDisplayName(locale), getURL(locale));
    }            

    private void removeUpdateCenter() {
        UpdateUnitProviderFactory f = UpdateUnitProviderFactory.getDefault();         
        for (UpdateUnitProvider uup : f.getUpdateUnitProviders(false)) {
            if (uup.getName().equals(UC_ID)) {
                f.remove(uup);
                LOG.info("TR language update center removed.");
                break;
            }
        }        
    }    
}
