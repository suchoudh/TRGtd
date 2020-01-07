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
package tr.view.filters;

import au.com.trgtd.tr.appl.Constants;
import java.io.Serializable;
import java.util.Vector;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import tr.model.topic.Topic;

/**
 * Topic for selection of multiple topics.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class TopicMultiple extends Topic implements MultipleItem<Topic>, Serializable {
    
    private static final long serialVersionUID = 87487528327L;
    
    public static final String ID = ChoiceMultiple.ID;
    
    private Vector<Topic> chosen;
    
    public TopicMultiple() {
        super(Constants.ID_FILTER_TOPICS_MULTIPLE);
        if (Utilities.isWindows()) {
            setName(NbBundle.getMessage(TopicMultiple.class, "windows-multiple"));
        } else {
            setName(NbBundle.getMessage(TopicMultiple.class, "filter-multiple"));
        }
    }
    
    public Vector<Topic> getChosen() {
        return (chosen == null) ? new Vector<Topic>() : chosen;
    }
    
    public void setChosen(Vector<Topic> chosen) {
        this.chosen = chosen;
    }
    
    public boolean equals(Object object) {
        return object instanceof TopicMultiple;
    }
    
}
