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

/**
 * Locale.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public enum Locale {

    none("", "", ""),
    en_UK("en", "UK", "English (UK)"),
    en_US("en", "US", "English (USA)"),
    fr_FR("fr", "FR", "Français (France)");

    public final String language;
    public final String country;
    public final String display;

    private Locale(String language, String country, String display) {
        this.language = language;
        this.country = country;
        this.display = display;
    }

    @Override
    public String toString() {
        return display;
    }
    
}
