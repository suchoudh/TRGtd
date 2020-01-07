package au.com.trgtd.email.utils;

/*
 * RenderableMessage.java
 *
 * Created on 09 November 2005, 10:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.logging.Logger;
import javax.mail.*;
import tr.util.HTML;

/**
 *
 * @author Dj
 */
public class RenderableMessage implements Renderable {

    private static final Logger LOG = Logger.getLogger("tr.email");
    private String subject;
    private String bodytext;
//  private ArrayList<Attachment> attachments;
    
    /** 
     * Creates a new instance of RenderableMessage.
     */
    public RenderableMessage(Message m) throws MessagingException, IOException {
//      attachments = new ArrayList<Attachment>();
        subject = m.getSubject();
        extractPart(m);
    }

    private boolean extractPart(final Part part) throws MessagingException, IOException {

        if (part.getContent() instanceof Multipart) {
            return handleMultipart((Multipart)part.getContent());
        }

        LOG.info("Part content type: " + part.getContentType());

        if (part.getContentType().startsWith("text/plain")) {
            
            LOG.info("TEXT:" + (String)part.getContent());

            if (bodytext == null) {
                bodytext = (String)part.getContent();
            } else {
                bodytext += "\n" + (String)part.getContent();                
            }            
            return true;
        }
        
        if (part.getContentType().startsWith("text/html")) {
            
            LOG.info("HTML:" + (String)part.getContent());
            
            if (bodytext == null) {
                bodytext = HTML.html2text((String)part.getContent());
            } else {
                bodytext += HTML.html2text("<p>" + (String)part.getContent() + "</p>");
            }
            return true;
        }
//        } else {
//            Attachment attachment = new Attachment();
//            attachment.setContenttype(part.getContentType());
//            attachment.setFilename(part.getFileName());
//
//            InputStream in = part.getInputStream();
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//
//            byte[] buffer = new byte[8192];
//            int count = 0;
//            while ((count = in.read(buffer)) >= 0) {
//                bos.write(buffer, 0, count);
//            }
//            in.close();
//            attachment.setContent(bos.toByteArray());
//            attachments.add(attachment);
//
//        }
        return false;
    }

    private boolean handleMultipart(Multipart mp) throws MessagingException, IOException {
        LOG.info("Multipart content type: " + mp.getContentType());

        if (mp.getContentType().startsWith("multipart/alternative")) {
            return handleMultipartAlternative(mp);
        } else if (mp.getContentType().startsWith("multipart/mixed")) {
            return handleMultipartMixed(mp);
        } else if (mp.getContentType().startsWith("multipart/related")) {
            return handleMultipartRelated(mp);
        } else if (mp.getContentType().startsWith("multipart/digest")) {
            return handleMultipartDigest(mp);
        } else if (mp.getContentType().startsWith("multipart/signed")) {
            return handleMultipartSigned(mp);
        }
        
        LOG.info("Multipart content could not be handled.");        
        
        return false;
    }

    private boolean handleMultipartAlternative(Multipart mp) throws MessagingException, IOException {
        // first try to find a plain text part
        for (int i = 0; i < mp.getCount(); i++) {
            Part p = mp.getBodyPart(i);
            if (p.getContentType().startsWith("text/plain")) {
                extractPart(p);
                return true;
            }
        }
        // second try to find a HTML part
        for (int i = 0; i < mp.getCount(); i++) {
            Part p = mp.getBodyPart(i);
            if (p.getContentType().startsWith("text/html")) {
                extractPart(p);
                return true;
            }
        }        
        // lastly try to handle first multipart
        for (int i = 0; i < mp.getCount(); i++) {
            Part p = mp.getBodyPart(i);
            if (p.getContent() instanceof Multipart) {
                if (handleMultipart((Multipart)p.getContent())) {
                    return true;
                }
            }
        }
        // give up    
        return false;    
    }

    private boolean handleMultipartMixed(Multipart mp) throws MessagingException, IOException {
        // process all parts
        boolean handled = false;
        for (int i = 0; i < mp.getCount(); i++) {
            if (extractPart(mp.getBodyPart(i))) {
                handled = true;
            }
        }
        return handled;
    }
    
    private boolean handleMultipartDigest(Multipart mp) throws MessagingException, IOException {
        // try to process all parts
        boolean handled = false;
        for (int i = 0; i < mp.getCount(); i++) {
            if (extractPart(mp.getBodyPart(i))) {
                handled = true;
            }
        }
        return handled;
    }
    
    private boolean handleMultipartSigned(Multipart mp) throws MessagingException, IOException {
        // try to process all parts
        boolean handled = false;
        for (int i = 0; i < mp.getCount(); i++) {
            if (extractPart(mp.getBodyPart(i))) {
                handled = true;
            }
        }
        return handled;
    }

    
    private boolean handleMultipartRelated(Multipart mp) throws MessagingException, IOException {
        // try to process all parts
        boolean handled = false;
        for (int i = 0; i < mp.getCount(); i++) {
            if (extractPart(mp.getBodyPart(i))) {
                handled = true;
            }
        }
        return handled;
    }    

    public String getSubject() {
        return subject;
    }

    public String getBodytext() {
        return bodytext;
    }

    public int getAttachmentCount() {
//        if (attachments == null) {
//            return 0;
//        }
//        return attachments.size();
        return 0;
    }

    public Attachment getAttachment(
            int i) {
//        return attachments.get(i);
        return null;
    }
}
