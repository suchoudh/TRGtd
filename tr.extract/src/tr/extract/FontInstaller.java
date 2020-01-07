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
package tr.extract;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * FontInstaller

 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class FontInstaller {

    private static final Logger LOG = Logger.getLogger("au.com.trgtd.tr.extract.FontInstaller");
    private static final GraphicsEnvironment GRAPHICS_ENVIRONMENT = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private static Map<String, Font> fontsMap;

    /**
     * Install fonts.
     */
    public static void installFonts() {
        if (!isJavaVersionOk()) {
            LOG.warning("Could not register report fonts - Java version earlier than 1.6");            
            return;
        }         
        installFont("DejaVu Sans", Resources.FILE_DEJAVU_SANS_TTF);
        installFont("DejaVu Sans Bold", Resources.FILE_DEJAVU_SANS_BOLD_TTF);
        installFont("DejaVu Sans Bold Oblique", Resources.FILE_DEJAVU_SANS_BOLD_OBLIQUE_TTF);
        installFont("DejaVu Sans Oblique", Resources.FILE_DEJAVU_SANS_OBLIQUE_TTF);        
        installFont("DejaVuSans", Resources.FILE_DEJAVU_SANS_TTF);
        installFont("DejaVuSans-Bold", Resources.FILE_DEJAVU_SANS_BOLD_TTF);
        installFont("DejaVuSans-BoldOblique", Resources.FILE_DEJAVU_SANS_BOLD_OBLIQUE_TTF);
        installFont("DejaVuSans-Oblique", Resources.FILE_DEJAVU_SANS_OBLIQUE_TTF);
        installFont("DejaVu Serif", Resources.FILE_DEJAVU_SERIF_TTF);
        installFont("DejaVu Serif Bold", Resources.FILE_DEJAVU_SERIF_BOLD_TTF);
        installFont("DejaVu Serif Bold Italic", Resources.FILE_DEJAVU_SERIF_BOLD_ITALIC_TTF);
        installFont("DejaVu Serif Italic", Resources.FILE_DEJAVU_SERIF_ITALIC_TTF);        
        installFont("DejaVuSerif", Resources.FILE_DEJAVU_SERIF_TTF);
        installFont("DejaVuSerif-Bold", Resources.FILE_DEJAVU_SERIF_BOLD_TTF);
        installFont("DejaVuSerif-BoldItalic", Resources.FILE_DEJAVU_SERIF_BOLD_ITALIC_TTF);
        installFont("DejaVuSerif-Italic", Resources.FILE_DEJAVU_SERIF_ITALIC_TTF);                
    }

    private static void installFont(String fontName, File ttfFile) {
        
        try {
            if (getFontsMap(false).containsKey(fontName)) {
                LOG.info(fontName + " font is already registered.");
                return;
            }
            Font font = Font.createFont(Font.TRUETYPE_FONT, ttfFile);
            if (font == null) {
                LOG.warning(fontName + " font could not be created.");
                return;
            }
            if (!GRAPHICS_ENVIRONMENT.registerFont(font)) {
                LOG.warning(fontName + " font was not registered.");
                return;
            }            
            
            LOG.info(fontName + " font was registered.");
            
        } catch (Exception ex) {
            LOG.warning(fontName + " font could not be registered.");
        }
    }

    private static Map<String, Font> getFontsMap(boolean refresh) {
        if (fontsMap == null || refresh) {
            fontsMap = new HashMap<String, Font>();
            for (Font font : GRAPHICS_ENVIRONMENT.getAllFonts()) {
                fontsMap.put(font.getFontName(), font);
            }
        }
        return fontsMap;
    }
    
    private static boolean isJavaVersionOk() {
        try {
            String javaVersion = System.getProperty("java.version");
            float version = Float.parseFloat(javaVersion.substring(0, 3));
            return version >= 1.6f;
        } catch (NumberFormatException nfe) {
            LOG.severe("Unable to determine Java version. " + nfe.getMessage());
            return false;
        }
        
    }
    
}
