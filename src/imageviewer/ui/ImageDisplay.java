package imageviewer.ui;

import imageviewer.model.Image;

public interface ImageDisplay {
    public Image current();
    public void show(Image image);
}
