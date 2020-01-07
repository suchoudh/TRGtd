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
package tr.datastore;

import java.util.logging.Logger;
import tr.model.Data;
import tr.model.DataLookup;
import tr.util.Observable;
import tr.util.ObservableImpl;
import tr.util.Observer;

/**
 * Data store abstract superclass.
 *
 * @author Jeremy Moore (jeremyimoore@yahoo.com.au)
 */
public abstract class AbstractDataStore extends ObservableImpl
        implements DataStore, Observer {

    private static final Logger LOG = Logger.getLogger("tr.datastore");
    /** The data. */
    private Data data;
    // data loaded state
    private boolean loaded;

    /**
     * Protected constructor for singleton subclasses.
     */
    protected AbstractDataStore() {
    }

    /**
     * Gets the current working data.
     * @return the data.
     */
    public Data getData() {
        return data;
    }

    /**
     * Sets the current working data.
     * @param data the data to set.
     */
    public void setData(Data data) {
        LOG.fine("Start");

        if (this.data != null) {
            this.data.removeObserver(this);
        }

        this.data = data;

        DataLookup.instance().setData(data);

        if (data == null) {
            loaded = false;
        } else {
            loaded = true;
            data.resetObservers();
            data.addObserver(this);
        }

        notifyObservers(this);
    }

    /**
     * Loads data from persistant storage and sets it as the data.
     * @throws Exception if an exception occurs while loading the data.
     */
    public abstract void load() throws Exception;

    /**
     * Stores the current working data to persistant storage.
     * @throws Exception if an exception occurs while storing the data.
     */
    public abstract void store() throws Exception;

    /**
     * Sets the data changed state.
     * @param changed The new data changed state.
     */
    public void setChanged(boolean changed) {
        if (data == null) {
            return;
        }

        if (data.hasChanged() != changed) {
            data.setChanged(changed);
        }
    }

    /**
     * Gets the data changed state.
     * @return true if the data has changed.
     */
    public boolean hasChanged() {
        if (data == null) {
            return false;
        }

        return data.hasChanged();
    }

    /**
     * Determines whether the data is loaded.
     * @return true iff the data is loaded.
     */
    public boolean isLoaded() {
        return loaded;
    }

    public void update(Observable observable, Object arguement) {
        notifyObservers(observable, arguement);
    }
}
