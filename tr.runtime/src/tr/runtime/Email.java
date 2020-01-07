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

import java.net.URLEncoder;
import java.util.logging.Logger;

/**
 * Runtime command for sending an email.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class Email {

    private static final Logger LOG = Logger.getLogger("tr.runtime.email"); // No I18N
    
    /* Private constructor to prevent instantiation. */
    private Email() {
    }

    /**
     * Send an email using the runtime exec facility.
     * @param to The email address to send to.
     * @param subject The email subject.
     * @param Body The email body.
     */
    public static final void email(String to, String subject, String body, String encoding) {

//        System.out.println("Desktop.isDesktopSupported() == " + Desktop.isDesktopSupported());
//        if (Desktop.isDesktopSupported()) {
//            Desktop desktop = Desktop.getDesktop();
//            System.out.println("desktop.isSupported(Desktop.Action.MAIL) == " + desktop.isSupported(Desktop.Action.MAIL));
//            if (desktop.isSupported(Desktop.Action.MAIL)) {
//                ...
//            }
//        }

//        // for Windows limit total length to 221
//        if (Runtime.windows) {
//            int len = to.length() + subject.length() + body.length();
//            if (len > 221) {
//                int rem = len - 221;
//                if (rem < body.length()) {
//                    body = body.substring(rem);
//                } else {
//                    rem -= body.length();
//                    body = "";
//                    if (rem < subject.length()) {
//                        subject = subject.substring(rem);
//                    } else {
//                        subject = "";
//                    }
//                }
//            }
//        }

        if (Runtime.macosx) {
//            to = filterTo(to);
            to = urlEncode(to, encoding);
//            subject = filterSubject(subject);
            subject = urlEncode(subject, encoding);
//            body = filterBody(body);
            body = urlEncode(body, encoding);
            Runtime.exec(new String[]{"open", "mailto:" + to + "?subject=" + subject + "&body=" + body});
        } else if (Runtime.linux || Runtime.unix) {
            // xdg-email [--utf8] [--cc address] [--bcc address] [--subject text] [--body text] [--attach file] { mailto-uri | address(es) }
//            to = filterToLinux(to);
            to = urlEncode(to, encoding);
//            subject = filterSubjectLinux(subject);
            subject = urlEncode(subject, encoding);
//            body = filterBodyLinux(body);
            body = urlEncode(body, encoding);
            String[] args = new String[]{"xdg-email", "--subject", subject, "--body", body, to};
            Runtime.exec(args);
        } else if (Runtime.win95 || Runtime.win98) {
//            to = filterTo(to);
            to = urlEncode(to, encoding);
//            subject = filterSubject(subject);
            subject = urlEncode(subject, encoding);
//            body = filterBody(body);
            body = urlEncode(body, encoding);
            Runtime.exec(new String[]{"command.com", "/C", "start", "mailto:" + to + "?subject=" + subject + "\"&\"body=" + body});
        } else if (Runtime.windows) {
//            to = filterTo(to);
            to = urlEncode(to, encoding);
//            subject = filterSubject(subject);
            subject = urlEncode(subject, encoding);
//            body = filterBody(body);
            body = urlEncode(body, encoding);
            Runtime.exec(new String[]{"cmd.exe", "/C", "start", "mailto:" + to + "?subject=" + subject + "\"&\"body=" + body});
        } else {
//            to = filterTo(to);
            to = urlEncode(to, encoding);
//            subject = filterSubject(subject);
            subject = urlEncode(subject, encoding);
//            body = filterBody(body);
            body = urlEncode(body, encoding);
            Runtime.exec(new String[]{"email", "mailto:" + to + "?subject=" + subject + "&body=" + body});
        }
    }

//    private static String filterTo(String to) {
//        to = to.replaceAll("%", "");
//        to = to.replaceAll("#", "");
//        to = to.replaceAll("\\?", "");
//        to = to.replaceAll("\\{", "");
//        to = to.replaceAll("\\}", "");
//        to = to.replaceAll("\\\\", "");
//        to = to.replaceAll("\\|", "");
//        to = to.replaceAll("\\^", "");
//        to = to.replaceAll(" ", "%20");
//        to = to.replaceAll("\t", "%20");
//        to = to.replaceAll("\n", "%20");
//        to = to.replaceAll("\f", "");
//        to = to.replaceAll("\r", "");
//        to = to.replaceAll("<", "");
//        to = to.replaceAll(">", "");
//        to = to.replaceAll("\"", "");
//        to = to.replaceAll("&", "");
//        to = to.replaceAll("'", "");
//        to = to.replaceAll("`", "");
//        return to;
//    }
//
//    private static String filterSubject(String subject) {
//        subject = subject.replaceAll("%", "");
//        subject = subject.replaceAll("#", "");
//        subject = subject.replaceAll("\\?", "");
//        subject = subject.replaceAll("\\{", "");
//        subject = subject.replaceAll("\\}", "");
//        subject = subject.replaceAll("\\\\", "");
//        subject = subject.replaceAll("\\|", "");
//        subject = subject.replaceAll("\\^", "");
//        subject = subject.replaceAll(" ", "%20");
//        subject = subject.replaceAll("\t", "%20");
//        subject = subject.replaceAll("\n", "%20");
//        subject = subject.replaceAll("\f", "");
//        subject = subject.replaceAll("\r", "");
//        subject = subject.replaceAll("<", "");
//        subject = subject.replaceAll(">", "");
//        subject = subject.replaceAll("\"", "");
//        subject = subject.replaceAll("&", "");
//        subject = subject.replaceAll("'", "");
//        subject = subject.replaceAll("`", "");
//        return subject;
//    }
//
//    private static String filterBody(String body) {
//        body = body.replaceAll("%", "");
//        body = body.replaceAll("#", "");
//        body = body.replaceAll("\\?", "");
//        body = body.replaceAll("\\{", "");
//        body = body.replaceAll("\\}", "");
//        body = body.replaceAll("\\\\", "");
//        body = body.replaceAll("\\|", "");
//        body = body.replaceAll("\\^", "");
//        body = body.replaceAll(" ", "%20");
//        body = body.replaceAll("\t", "%09");
////	body = body.replaceAll("\r", "%0D");
////	body = body.replaceAll("\n", "%0A");
//        body = body.replaceAll("\n", "%0D");
////	body = body.replaceAll("\f", "%0C");
//        body = body.replaceAll("<", "");
//        body = body.replaceAll(">", "");
//        body = body.replaceAll("\"", "");
//        body = body.replaceAll("&", "");
//        body = body.replaceAll("'", "");
//        body = body.replaceAll("`", "");
//        return body;
//    }
//
//    private static String filterToLinux(String to) {
//        to = to.replaceAll(" ", "");
//        to = to.replaceAll("\t", "");
//        to = to.replaceAll("\n", "");
//        to = to.replaceAll("\f", "");
//        to = to.replaceAll("\r", "");
//        return to;
//    }
//
//    private static String filterSubjectLinux(String subject) {
//        subject = subject.replaceAll("\t", " ");
//        subject = subject.replaceAll("\n", " ");
//        subject = subject.replaceAll("\f", " ");
//        subject = subject.replaceAll("\r", " ");
//        return subject;
//    }
//
//    private static String filterBodyLinux(String body) {
//        return body;
//    }
//    private static String urlEncode(final String s) {
//        String r;
//        try {
//            r = java.net.URLEncoder.encode(s, "utf-8").replaceAll("\\+", "%20").replaceAll("\\%0A", "%0D%0A");
//        } catch (Throwable x) {
//            x.printStackTrace(System.err);
//            r = s;
//        }
//        System.out.println("ENCODED: " + r);
//        return r;
//    }
//    private static String urlEncode(final String str) {
//
//        String out = str;
//
//        try {
//
//            String encoding = RuntimePrefs.getEncoding();
//            if (encoding != null && Charset.isSupported(encoding)) {
//                out = URLEncoder.encode(out, encoding);
//                System.out.println("EMAIL - " + encoding + " ENCODED: " + out);
//            }
//
//            out = out.replaceAll("\\+", "%20").replaceAll("\\%0A", "%0D%0A");
//            System.out.println("EMAIL - ESCAPED: " + out);
//
//        } catch (Throwable x) {
//            System.out.println("EMAIL - EXCEPTION: " + x.getMessage());
//            x.printStackTrace();
//        }
//
//        return out;
//    }
    private static String urlEncode(final String str, String encoding) {
        try {
            String out = URLEncoder.encode(str, encoding);
            return out.replaceAll("\\+", "%20").replaceAll("\\%0A", "%0D%0A");
        } catch (Exception x) {
            return str.replaceAll("\\+", "%20").replaceAll("\\%0A", "%0D%0A");
        }
    }

//    private static String urlEncode(String s) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (Character.isLetterOrDigit(ch)) {
//                sb.append(ch);
//            } else if (Character.isSpaceChar(ch)) {
//                sb.append(ch);
//            } else {
//                sb.append(String.format("%%%02X", (int) ch));
//            }
//        }
//
//        System.out.println("ENCODED AS: " + sb);
//
//        return sb.toString();
//    }
}
