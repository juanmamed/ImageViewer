/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer.controller;

import imageviewer.model.Image;
import imageviewer.persistence.FileImageLoader;
import java.io.File;

/**
 *
 * @author Juanma
 */
public class Main {
    public static void main(String[] args) {
        File file = new File(".");
        FileImageLoader loader = new FileImageLoader(file);
        Image image = loader.load();
        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().show(image);
    }
}
