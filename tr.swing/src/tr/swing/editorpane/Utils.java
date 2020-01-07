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
package tr.swing.editorpane;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Static utility methods.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class Utils {
    
//  private static final Logger LOG = Logger.getLogger("tr.swing.editorpane");
    
    private final static String[] SCHEMES = {
        "http://",
        "https://",
        "file:/",
        "www."
    };
    
    private final static String[] PREFIXES = {
        "",         // for http://
        "",         // for https://
        "",         // for file:/
        "http://"   // for www.
    };
    
    /**
     * Converts a text string to HTML for rendering. Replaces recognised URL
     * strings within the string. URL strings in the following format are
     * recognised:
     *      (scheme)(word)
     *      [(scheme)(anything)]
     *      [(scheme)(anything)|(anything)]
     * where:
     *      (scheme) is any of "http://", "https://", "file:/", "www."
     *      (word) denotes any contiguous non-whitespace characters
     *      (anything) denotes any sequence or characters including whitespace
     *      [, ] and | are literal characters
     *
     * @param text the text to convert to HTML.
     */
    public static String text2html(String text) {
        text = (text == null) ? "" : text;
        text = StringEscapeUtils.escapeXml(text);
        text = convertURLs(text);
        text = preserveWhitespace(text);
        text = fixProblems(text);
        return "<html><body>" + text + "</body></html>";
    }
    
    /**
     * Replaces recognised URL strings in a string.
     * @param html The given HTML string.
     * @return The converted HTML string.
     */
    private static String convertURLs(String string) {
        
        StringBuffer sb = new StringBuffer();
        
        int lastEnd = 0;
        
        // match: [...] or contiguous non-whitespace
        Pattern pattern = Pattern.compile("\\[[^\\[\\]]+\\]|[\\S]+");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            
            String skipped = string.substring(lastEnd, matcher.start());
            sb.append(skipped);
            
            String segment = string.substring(matcher.start(), matcher.end());
            
            if (segment.startsWith("[")) {
                sb.append(processBracketed(segment));
            } else {
                sb.append(processNotBracketed(segment));
            }
            
            lastEnd = matcher.end();
        }
        
        String skipped = string.substring(lastEnd, string.length());
        sb.append(skipped);
        
        return sb.toString();
    }
    
    /**
     * Processes a square bracketed term.
     * @param string In the form of: "[" + x + "]" or: "[" + x + "|" + y + "]".
     * @return If x is a recognised URL return the appropriate HTML A tag,
     * otherwise return the input string.
     */
    private static String processBracketed(String string) {
        
        String url, txt, str = string.substring(1, string.length() - 1);
        
        for (int i = 0; i < SCHEMES.length; i++) {
            
            if (str.startsWith(SCHEMES[i])) {
                
                int p = str.indexOf("|");
                if (p == -1) {
                    url = PREFIXES[i] + str;
                    txt = str;
                } else {
                    url = PREFIXES[i] + str.substring(0, p);
                    txt = str.substring(p + 1);
                }
                
                return "<a href=\"" + url + "\">" + txt + "</a>";
            }
        }
        
        return string;
    }
    
    /**
     * For a given string of contiguous non-whitespace characters, determines
     * wheather it is a recognised URL string and if so returns a corresponding
     * HTML A tag.
     * @param string A string of contiguous non-whitespace characters.
     * @return If the string is a recognised, the corresponding HTML A tag
     * string, otherwise the original string is returned.
     */
    private static String processNotBracketed(String string) {
        
        for (int i = 0; i < SCHEMES.length; i++) {
            
            if (string.startsWith(SCHEMES[i])) {
                
                String url = PREFIXES[i] + string;
                
                return "<a href=\"" + url + "\">" + string + "</a>";
            }
        }
        
        return string;
    }
    
    /**
     * Preserves whitespace in HTML for a given string.
     */
    private static String preserveWhitespace(String html) {
        
        // replace line terminators
        html = html.replace("\r\n", "<br>"); // carriage return + newline
        html = html.replace("\r", "<br>");   // carriage return
        html = html.replace("\n", "<br>");   // newline
        
        // replace whitespace
        html = html.replace("\u0020\u0020", "&nbsp;&nbsp;");  // pairs of spaces
        html = html.replace("\u000B", "&nbsp;");              // vertical tab
        html = html.replace("\t", "&nbsp;");                  // tab
        html = html.replace("\f", "&nbsp;");                  // form feed
        html = html.replace("\r", "&nbsp;");                  // carriage return
        
        return html;
    }
    
    /** Fix residual problems in HTML string. */
    private static String fixProblems(String html) {
        
        html = html.replace("&apos;", "'"); // put back apostrophes
        
        return html;
    }
}
