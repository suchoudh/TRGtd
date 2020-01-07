package au.com.trgtd.tr.l10n.fr_FR;

import java.net.URL;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileSystem;
import org.openide.filesystems.Repository;
import tr.view.overview.spi.OverviewSVGProvider;

public class OverviewSVGProvider_fr_FR implements OverviewSVGProvider {

    public String getLanguage() {
        return "fr";
    }

    public String getCountry() {
        return "FR";
    }

    public URL getURL() {
        try {
            FileSystem fs = Repository.getDefault().getDefaultFileSystem();
            FileObject fo = fs.findResource("Overview/overview_fr_FR.svg");
            return fo.getURL();
        } catch (Exception ex) {
            return null;
        }
    }

}
