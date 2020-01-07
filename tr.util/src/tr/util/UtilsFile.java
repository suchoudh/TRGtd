package tr.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class UtilsFile {
    
    /* This utility class does not need to be instantiated. */
    private UtilsFile() {
    }
    
    /**
     * Copies the specified source file to the specified target file.
     */
    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        if (sourceFile == null || targetFile == null) {
            throw new NullPointerException("Source file and target file must not be null"); // NOI18N
        }
        
        // ensure existing parent directories
        File directory = targetFile.getParentFile();
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IOException("Could not create directory '" + directory + "'"); // NOI18N
        }
        
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(sourceFile));
            outputStream = new BufferedOutputStream(new FileOutputStream(targetFile));
            
            try {
                byte[] buffer = new byte[32768];
                for (int readBytes = inputStream.read(buffer);
                readBytes > 0;
                readBytes = inputStream.read(buffer)) {
                    outputStream.write(buffer, 0, readBytes);
                }
            } catch (IOException ex) {
                targetFile.delete();
                throw ex;
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    // ignore
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    // ignore
                }
            }
        }
    }
    
    /**
     * Do the best to rename the file.
     * @param orig regular file
     * @param dest regular file (if exists it's rewritten)
     */
    public static void renameFile(File orig, File dest) throws IOException {
        boolean destExists = dest.exists();
        if (destExists) {
            for (int i = 0; i < 3; i++) {
                if (dest.delete()) {
                    destExists = false;
                    break;
                }
                try {
                    Thread.sleep(71);
                } catch (InterruptedException e) {
                }
            }
        }
        
        if (destExists == false) {
            for (int i = 0; i < 3; i++) {
                if (orig.renameTo(dest)) {
                    return;
                }
                try {
                    Thread.sleep(71);
                } catch (InterruptedException e) {
                }
            }
        }
        
        // requires less permisions than renameTo
        UtilsFile.copyFile(orig, dest);
        
        for (int i = 0; i < 3; i++) {
            if (orig.delete()) {
                return;
            }
            try {
                Thread.sleep(71);
            } catch (InterruptedException e) {
            }
        }
        throw new IOException("Can not delete: " + orig.getAbsolutePath());  // NOI18N
    }
    
    /**
     * Utility method to get a writeable temporary directory.  This will be
     * either the system temp directory (System.getProperty("java.io.tmpdir"))
     * or the user home directory.
     * @return A temporary directory.
     * @throws IOException if the system temp directory and the user home
     * directory do not exist or are not writeable directories.
     */
    public static final File getTempDir() throws IOException {
        String tmpdir = System.getProperty("java.io.tmpdir");
        File dir = new File(tmpdir);
        if (dir.isDirectory() && dir.canWrite()) {
            return dir;
        }
        tmpdir = System.getProperty("user.home");
        dir = new File(tmpdir);
        if (dir.isDirectory() && dir.canWrite()) {
            return dir;
        }
        throw new IOException("A writeable temporary directory could not be found.");
    }
    
    /**
     * Gets the extension of a filename.
     * @return The file extension (as lowercase) or null if name is null or does
     * not have an extension.
     */
    public static final String getExtension(String name) {
        if (name != null) {
            int index = name.lastIndexOf('.');
            if (index > 0 &&  index < name.length() - 1) {
                return name.substring(index+1).toLowerCase();
            }
        }
        return null;
    }
    
    /**
     * Sets an extension on a file path.
     * @param path The path.
     * @param extn The extension.
     * @return path with the new extension added or null if either path or extn
     * are null.
     */
    public static final String setExtension(String path, String extn) {
        if (path == null || extn == null) return null;
        
//	// remove any trailing full stops from path
//    while (path.endsWith(".")) {
//    	path = path.substring(0, path.length() - 2);
//    }
        
        return path + "." + extn;
    }
    
    /**
     * Removes the last extension from a file path.
     * @param path The path.
     * @return path with the last extension removed.
     */
    public static final String removeExtension(String path) {
        if (path == null) return null;
        
        int index = path.lastIndexOf(".");
        if (index < 0) {
            return path;
        } else {
            return path.substring(0, index);
        }
        
    }
    
}
