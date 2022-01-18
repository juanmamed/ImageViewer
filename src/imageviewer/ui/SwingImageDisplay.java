package imageviewer.ui;

import imageviewer.model.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Image currentImage;

    @Override
    public Image current() {
        return this.currentImage;
    }

    @Override
    public void show(Image image) {
        this.currentImage = image;
        this.repaint();
    }
    
    @Override
    public void paint(Graphics g){
        try {
            g.drawImage(imageOf(currentImage),0,0,this.getWidth(),this.getHeight(),null);
        } catch (ArrayIndexOutOfBoundsException ex)  {
        }
      
    }

    private BufferedImage imageOf(Image currentImage) {
        try {
            return ImageIO.read(currentImage.stream());
        } catch (IOException ex) {
            Logger.getLogger(SwingImageDisplay.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
