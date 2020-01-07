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
package au.com.trgtd.tr.reports.actions.doasap;

import java.io.File;
import org.openide.modules.InstalledFileLocator;

/**
 * Resources.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class Resources {

    public static final File FILE_DOASAP_BY_CONTEXT = getInstalledFile("resource/reports/DoASAPbyContext.jasper");
    public static final File FILE_DOASAP_BY_CONTEXT_AND_TIME = getInstalledFile("resource/reports/DoASAPbyContextTime.jasper");
    public static final File FILE_DOASAP_BY_CONTEXT_AND_ENERGY = getInstalledFile("resource/reports/DoASAPbyContextEnergy.jasper");
    public static final File FILE_DOASAP_BY_CONTEXT_AND_PRIORITY = getInstalledFile("resource/reports/DoASAPbyContextPriority.jasper");

    private static final File getInstalledFile(String path) {
        File file = InstalledFileLocator.getDefault().locate(path, null, false);
        if (file != null && file.isFile()) {
            return file;
        }
        return null;
    }
}
