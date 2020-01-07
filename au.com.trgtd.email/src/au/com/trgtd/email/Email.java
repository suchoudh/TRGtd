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

import au.com.trgtd.email.prefs.EmailPrefs;
import au.com.trgtd.email.utils.Renderable;
import au.com.trgtd.email.utils.RenderableFactory;
import java.util.Date;
import java.util.logging.Logger;
import javax.mail.Message;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.thought.Thought;

/**
 * Email.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class Email {

    private static final Logger LOG = Logger.getLogger("tr.email");
    
    /** Creates a new instance of Email */
    public Email() {
    }

    /**
     * @param args the command line arguments
     */
    public static void retrieve() {
    
        LOG.info("Starting email fetch at: " + new Date());

        Data data = DataLookup.instance().lookup(Data.class);
        if (data == null) {
            return;
        }

        EmailUtils email = new EmailUtils();

        try {
            String username = EmailPrefs.getEmailUsername();
            String password = EmailPrefs.getEmailPassword();
            String popserver = EmailPrefs.getEmailServer();
            int port = EmailPrefs.getPort();
            boolean ssl = EmailPrefs.isSSL();

            LOG.info("Username:" + username);
//          LOG.info("Password:" + password);
            LOG.info("POP Server:" + popserver);
            LOG.info("Port:" + port);
            LOG.info("SSL:" + ssl);

            email.setUserPass(username, password);
            email.setServer(popserver);
            email.setPort(port);
            email.setUseSSL(ssl);
            email.connect();            
            email.openFolder("INBOX");

            LOG.info("Total messages: " + email.getMessageCount());

            for (Message msg : email.getNewMessages()) {
//              LOG.info("Subject: " + email.getSubject(msg));
//              LOG.info("Body: " + email.getBody(msg));
//              createThought(data, email.getSubject(msg), email.getBody(msg));
  
                Renderable r = RenderableFactory.create(msg);
                if (r != null) {
//                    LOG.info("Subj: " + r.getSubject());
//                    LOG.info("Body: " + r.getBodytext());
                    createThought(data, r.getSubject(), r.getBodytext());
                }
                
                email.delete(msg);
            }
            email.closeFolder(true);
        } catch (Exception e) {
            LOG.severe(e.getMessage());
            e.printStackTrace();
            return;
        } finally {
            try {
                email.disconnect();
            } catch (Exception e) {
            }
        }
        
        LOG.info("Finished email fetch at: " + new Date());
    }

    private static void createThought(Data data, String subject, String body) {
        Thought thought = new Thought(data.getNextID());
        thought.setDescription(subject);
        thought.setNotes(body);        
//      data.getThoughtManager().insert(thought, 0);
        data.getThoughtManager().add(thought);        
    }

}