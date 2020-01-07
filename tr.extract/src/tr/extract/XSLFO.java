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

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.avalon.framework.configuration.Configuration;

import org.apache.avalon.framework.configuration.DefaultConfigurationBuilder;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

/**
 * Static methods for XSL-FO transformations.
 *
 * @author jeremyimoore@yahoo.com.au
 */
public class XSLFO {
    
    /**
     * Transform the XML file to PDF using JAXP (XSLT) and FOP (XSL-FO).
     *
     * @param xmlfile The XML file.
     * @param xsltfile The XSL-FO file.
     * @param xsltparams The List of Param values to set or null if none.
     * @param outfile The output file.
     */
//  public static void transform(File xmlfile, File xsltfile, List xsltparams, File pdffile) { //throws Exception {
    public static void transform(File xmlfile, InputStream xsltfile, List<Param> params, File pdffile) { //throws Exception {
        System.out.print("Processing XSL-FO ... ");
        try {
            // configure fopFactory as desired
            FopFactory fopFactory = FopFactory.newInstance();
            
            // load configuration
            File configFile = Resources.FILE_FOP_CONFIG;
            if (configFile != null) {
                DefaultConfigurationBuilder cfgBuilder = new DefaultConfigurationBuilder();
                Configuration cfg = cfgBuilder.buildFromFile(configFile);
                fopFactory.setUserConfig(cfg);                
            }            
            
            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
            
            // Setup output
            OutputStream out = new BufferedOutputStream(new FileOutputStream(pdffile));
            
            try {
                // Construct fop with desired output format
                Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
                
                // Setup XSLT
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer(new StreamSource(xsltfile));
                
                // Set the values of parameters in the stylesheet
                for (Param param : params) {
                    transformer.setParameter(param.id, param.getValue());
                }
                
                // Setup input for XSLT transformation
                Source src = new StreamSource(xmlfile);
                
                // Resulting SAX events (the generated FO) must be piped through to FOP
                Result res = new SAXResult(fop.getDefaultHandler());
                
                // Start XSLT transformation and FOP processing
                transformer.transform(src, res);
            } finally {
                out.close();
            }
            System.out.print("done");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            System.out.println();
        }
    }
    
}