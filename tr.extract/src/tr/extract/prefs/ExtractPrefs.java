package tr.extract.prefs;

import au.com.trgtd.tr.appl.Constants;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Extract preferences.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ExtractPrefs {
    
    private static final Logger LOG = Logger.getLogger("tr.extract.prefs");
    
    // User preferences for extracts.
    private static final Preferences prefs = Preferences.userRoot().node(Constants.PREFS_PATH + "/extract");
    
    // Key for the export path.
    private static final String KEY_PATH = "path";
    
    // Default value for the export path.
    private static final String DEF_PATH = System.getProperty("user.home");
    
    // Key for encoding.
    private static final String KEY_ENCODING = "encoding";
    
    // Default value for encoding.
    private static final String DEF_ENCODING = "";
    
    /**
     * Gets the value for the path preference.
     * @return The value.
     */
    public static final String getPath() {
        return prefs.get(KEY_PATH, DEF_PATH);
    }
    
    /**
     * Sets the value for the path preference.
     * @param value The value.
     */
    public static final void setPath(String value) {
        prefs.put(KEY_PATH, value);
        flush();
    }
    
    /**
     * Gets the value for encoding.
     * @return The value.
     */
    public static final String getEncoding() {
        return prefs.get(KEY_ENCODING, DEF_ENCODING);
    }
    
    /**
     * Sets the value for encoding.
     * @param value The value.
     */
    public static final void setEncoding(String value) {
        prefs.put(KEY_ENCODING, (value == null) ? "" : value.trim());
        flush();
    }
    
    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
            LOG.severe("Extract preferences error. " + ex.getMessage());
        }
    }
    
}
