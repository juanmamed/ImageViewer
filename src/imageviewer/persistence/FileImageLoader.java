package imageviewer.persistence;

import imageviewer.model.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileImageLoader implements ImageLoader {
    private final File[] files;

    public FileImageLoader(File folder) {
        this.files = folder.listFiles(imageTypes());
    }
    
    private FileFilter imageTypes() {
        return new FileFilter() {
            @Override
             public boolean accept(File pathname) {
                 return pathname.getName().endsWith(".jpg");
             }
        };
    }

    @Override
    public Image load() {
        return imageAt(0);
    }

    public Image imageAt(int i) {
        return new Image(){
            @Override
            public String name(){
                return files[i].getName();
            }

            @Override
            public InputStream stream() {
                try {
                    return new BufferedInputStream(new FileInputStream(files[i]));
                } catch (FileNotFoundException ex) {
                    return null;
                }
            }

            @Override
            public Image next() {
                if (i == (files.length - 1)){
                    return imageAt(0);
                }
                return imageAt(i+1);
            }

            @Override
            public Image prev() {
                if (i == 0){
                    return imageAt(files.length - 1);
                }
                return imageAt(i-1);
            }
        };
    }
}
