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

package tr.view.overview.spi;

import java.net.URL;

/**
 * Service provider interface for modules that provide an overview SVG file
 * for a locale.
 * 
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public interface OverviewSVGProvider {

    /**
     * Gets the locale language.
     * @return the language code (e.g. "fr" for French).
     */
    public String getLanguage();

    /**
     * Gets the locale country.
     * @return the country code (e.g. "FR" for France).
     */
    public String getCountry();
    
    /**
     * Gets the URL of the overview SVG file.
     * @return the URL.
     */
    public URL getURL();

}
