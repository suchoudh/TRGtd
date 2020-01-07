package au.com.trgtd.tr.l10n.en_US;

import java.net.URL;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileSystem;
import org.openide.filesystems.Repository;
import tr.view.overview.spi.OverviewSVGProvider;

public class OverviewSVGProvider_en_US implements OverviewSVGProvider {

    public String getLanguage() {
        return "en";
    }

    public String getCountry() {
        return "US";
    }

    public URL getURL() {
        try {
            FileSystem fs = Repository.getDefault().getDefaultFileSystem();
            FileObject fo = fs.findResource("Overview/overview_en_US.svg");
            return fo.getURL();
        } catch (Exception ex) {
            return null;
        }
    }

}
