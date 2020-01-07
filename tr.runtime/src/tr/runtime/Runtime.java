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
 * Portions Copyright 2006-2007 Avente Pty Ltd. All Rights Reserved.
 */

package tr.runtime;

import org.openide.util.Utilities;

/**
 * Runtime.exec wrapper.
 */
public class Runtime {
    
    private static final String osName = System.getProperty("os.name" ).toLowerCase();
    
    /** Determines whether or not the system is Linux. */
    public static final boolean linux = Utilities.getOperatingSystem() == Utilities.OS_LINUX;
    /** Determines whether or not the system is Mac OS X. */
    public static final boolean macosx = Utilities.getOperatingSystem() == Utilities.OS_MAC;
    /** Determines whether or not the system is Windows 95. */
    public static final boolean win95 = Utilities.getOperatingSystem() == Utilities.OS_WIN95;
    /** Determines whether or not the system is Windows 95. */
    public static final boolean win98 = Utilities.getOperatingSystem() == Utilities.OS_WIN98;
    /** Determines whether or not the system is any Windows. */
    public static final boolean windows = Utilities.isWindows();
    /** Determines whether or not the system is any Unix. */
    public static final boolean unix = Utilities.isUnix();    
    
    /**
     * Execute a runtime command.
     * @param cmd The command.
     */
    public static void exec(String[] cmd) {
        try {
            Process process = java.lang.Runtime.getRuntime().exec(cmd);
            
            StreamConsumer stderrConsumer = new StreamConsumer(process.getErrorStream());
            StreamConsumer stdoutConsumer = new StreamConsumer(process.getInputStream());
            
            stderrConsumer.start();
            stdoutConsumer.start();
            
//          int exitValue = process.waitFor();
            process.waitFor();
            
            stderrConsumer.terminate();
            stdoutConsumer.terminate();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
}
