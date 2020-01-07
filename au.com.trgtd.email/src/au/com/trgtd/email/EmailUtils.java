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
package au.com.trgtd.email;

import com.sun.mail.pop3.POP3SSLStore;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Logger;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;

/**
 * Email utilities.
 * 
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class EmailUtils {

    private static final Logger LOG = Logger.getLogger("au.com.trgtd.email.EmailUtils");
    private final static String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private Session session = null;
    private Store store = null;
    private String server;
    private String username;
    private String password;
    private boolean useSSL;
    private int port;
    private Folder folder;

    public EmailUtils() {
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setUserPass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUseSSL(boolean useSSL) {
        this.useSSL = useSSL;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void connect() throws Exception {
        assert (server != null);
        assert (username != null);
        assert (password != null);

        Properties pop3Props = new Properties();

        if (useSSL && port > 0) {
            pop3Props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
            pop3Props.setProperty("mail.pop3.socketFactory.fallback", "false");
            pop3Props.setProperty("mail.pop3.port", Integer.toString(port));
            pop3Props.setProperty("mail.pop3.socketFactory.port", Integer.toString(port));
            URLName url = new URLName("pop3", server, port, "", username, password);
            session = Session.getInstance(pop3Props, null);
            store = new POP3SSLStore(session, url);
            store.connect();
        } else {
            Properties props = new Properties();
            session = Session.getDefaultInstance(props, null);
            store = session.getStore("pop3");
            store.connect(server, username, password);
        }
    }

    public void openFolder(String folderName) throws Exception {

        // Open the Folder
        folder = store.getDefaultFolder();

        folder = folder.getFolder(folderName);

        if (folder == null) {
            throw new Exception("Invalid folder");
        }

        // try to open read/write and if that fails try read-only
        try {

            folder.open(Folder.READ_WRITE);

        } catch (MessagingException ex) {

            folder.open(Folder.READ_ONLY);

        }
    }

//    public void closeFolder() throws Exception {
//        folder.close(false);
//    }
    public int getMessageCount() throws Exception {
        return folder.getMessageCount();
    }

    public int getNewMessageCount() throws Exception {
        return folder.getNewMessageCount();
    }

    public void disconnect() throws Exception {
        store.close();
    }

//    public void printMessage(int messageNo) throws Exception {
//        System.out.println("Getting message number: " + messageNo);
//
//        Message m = null;
//
//        try {
//            m = folder.getMessage(messageNo);
//            dumpPart(m);
//        } catch (IndexOutOfBoundsException iex) {
//            System.out.println("Message number out of range");
//        }
//    }

//    public void printAllMessageEnvelopes() throws Exception {
//        // Attributes & Flags for all messages ...
//        Message[] msgs = folder.getMessages();
//
//        // Use a suitable FetchProfile
//        FetchProfile fp = new FetchProfile();
//        fp.add(FetchProfile.Item.ENVELOPE);
//        folder.fetch(msgs, fp);
//
//        for (int i = 0; i < msgs.length; i++) {
//            System.out.println("--------------------------");
//            System.out.println("MESSAGE #" + (i + 1) + ":");
//            dumpEnvelope(msgs[i]);
//        }
//    }

//    public void printAllMessages() throws Exception {
//
//        // Attributes & Flags for all messages ..
//        Message[] msgs = folder.getMessages();
//
//        // Use a suitable FetchProfile
//        FetchProfile fp = new FetchProfile();
//        fp.add(FetchProfile.Item.ENVELOPE);
//        folder.fetch(msgs, fp);
//
//        for (int i = 0; i < msgs.length; i++) {
//            System.out.println("--------------------------");
//            System.out.println("MESSAGE #" + (i + 1) + ":");
//            if (msgs[i].isSet(Flags.Flag.DELETED)) {
//                System.out.println("DELETED STATE");
//            }
//            dumpPart(msgs[i]);
//        }
//    }

//    public static void dumpPart(Part p) throws Exception {
//        if (p instanceof Message) {
//            dumpEnvelope((Message) p);
//        }
//        String ct = p.getContentType();
////        try {
//        pr("CONTENT-TYPE: " + (new ContentType(ct)).toString());
////        } 
////        catch (ParseException pex) {
////            pr("BAD CONTENT-TYPE: " + ct);
////        }
//
//        /*
//         * Using isMimeType to determine the content type avoids
//         * fetching the actual content data until we need it.
//         */
//        if (p.isMimeType("text/plain")) {
//            pr("This is plain text");
//            pr("---------------------------");
//            System.out.println((String) p.getContent());
//        } else {
//
//            // just a separator
//            pr("---------------------------");
//
//        }
//    }

//    public static void dumpEnvelope(Message m) throws Exception {
//        pr(" ");
//        Address[] a;
//        // FROM
//        if ((a = m.getFrom()) != null) {
//            for (int j = 0; j < a.length; j++) {
//                pr("FROM: " + a[j].toString());
//            }
//        }
//
//        // TO
//        if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
//            for (int j = 0; j < a.length; j++) {
//                pr("TO: " + a[j].toString());
//            }
//        }
//
//        // SUBJECT
//        pr("SUBJECT: " + m.getSubject());
//
//        // DATE
//        Date d = m.getSentDate();
//        pr("SendDate: " +
//                (d != null ? d.toString() : "UNKNOWN"));
//
//
//    }
//    static String indentStr = "                                               ";
//    static int level = 0;
//
//    /**
//     * Print a, possibly indented, string.
//     */
//    public static void pr(String s) {
//        System.out.print(indentStr.substring(0, level * 2));
//        System.out.println(s);
//    }
    public List<Message> getNewMessages() {

        List<Message> result = new Vector<Message>();

        try {
            Message[] messages = folder.getMessages();

            // Use a suitable FetchProfile
            FetchProfile fp = new FetchProfile();
            fp.add(FetchProfile.Item.ENVELOPE);
            folder.fetch(messages, fp);

            // get non-deleted messages
            for (Message message : messages) {
                if (!message.isSet(Flags.Flag.DELETED)) {
                    result.add(message);
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }

    public String getSubject(Message msg) {
        try {
            return msg == null ? "" : msg.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getBody(Message msg) {
//        if (msg == null) {
//            return "";
//        }
//        try {
//            Object content = msg.getContent();
//            if (content instanceof String) {
//                return (String) content;
//            } else if (content instanceof Multipart) {
//                StringBuffer sb = new StringBuffer();
//                Multipart mp = (Multipart) content;
//                for (int i = 0; i < mp.getCount(); i++) {
//                    BodyPart bp = mp.getBodyPart(i);
//                    if (bp.isMimeType("text/plain")) {
//                        Object bpc = bp.getContent();
//                        if (bpc instanceof String) {
//                            sb.append(bpc);
//                        }
//                    }
//                }
//                return sb.toString();
//            } else {
//                return "";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "";
//        }
        try {
            return Pop3.Tools.getBody(msg);
        } catch (Exception ex) {
            LOG.info("Exception getting body of message. ");
            ex.printStackTrace();            
            return "";
        }
    }

    public void delete(Message msg) {
        try {
            msg.setFlag(Flags.Flag.DELETED, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeFolder(boolean expunge) {
        
        
        try {
            folder.close(expunge);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    
//    public void editMessage( Message pMessage ) {
//        // There exists some parameter pMessage
//        // which is a javax.mail.Message
//        try {
//            // Try and grab the unknown content
//            Object content = pMessage.getContent();
//
//            // Grab the body content text
//            if ( content instanceof String ) {
//                String body = (String) content;
//                // Add our custom message
//                body += stripTags( mesgStr );
//                // Set the new content
//                pMessage.setContent( body );
//            } else if ( content instanceof Multipart ) {
//                // Make sure to cast to it's Multipart derivative
//                parseMultipart( (Multipart) content );
//            }
//        } catch ( MessagingException e ) {
//            e.printStackTrace();
//        } catch ( IOException e ) {
//            e.printStackTrace();
//        }
//    }
//
//    // Parse the Multipart to find the body
//    public void parseMultipart( Multipart mPart ) {
//        // Loop through all of the BodyPart's
//        for ( int i = 0; i < mPart.getCount(); i++ ) {
//            // Grab the body part
//            BodyPart bp = mPart.getBodyPart( i );
//            // Grab the disposition for attachments
//            String disposition = mPart.getDisposition();
//
//            // It's not an attachment
//            if ( disposition == null && bp instanceof MimeBodyPart ) {
//                MimeBodyPart mbp = (MimeBodyPart) bp;
//
//                // Check to see if we're in the screwy situation where
//                // the message text is buried in another Multipart
//                if ( mbp.getContent() instanceOf Multipart ) {
//                    // Use recursion to parse the sub-Multipart
//                    parseMultipart( (Multipart) mbp.getContent() );
//                } else {
//                    // Time to grab and edit the body
//                    if ( mbp.isMimeType( "text/plain" ) {
//                        // Grab the body containing the text version
//                        String body = (String) mbp.getContent();
//                        // Add our custom message
//                        body += stripTags( mesgStr );
//
//                        // Reset the content
//                        mbp.setContent( body, "text/plain" );
//                    } else if ( mbp.isMimeType( "text/html" ) {
//                        // Grab the body containing the HTML version
//                        String body = (String) mbp.getContent();
//                        // Add our custom message to the HTML before
//                        // the closing </body>
//                        body = addStrToHtmlBody( mesgStr, body );
//
//                        // Reset the content
//                        mbp.setContent( body, "text/html" );
//                    }
//                }
//            }
//        }
//    }    

}