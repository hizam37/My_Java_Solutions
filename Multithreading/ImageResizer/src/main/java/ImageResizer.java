

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
public class ImageResizer extends Thread {
    private File[] files;

    private int newWidth;

    private int newHight;
    private String dstFolder;

    private long start;

    public ImageResizer(File[] files, int newWidth, int newHight, String dstFolder, long start) {
        this.files = files;
        this.newWidth = newWidth;
        this.newHight = newHight;
        this.dstFolder = dstFolder;
        this.start = start;
    }

    @Override
    public void run() {
        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }
                BufferedImage scaledImage = Scalr.resize(image,Scalr.Method.ULTRA_QUALITY,Scalr.Mode.FIT_EXACT,newWidth,newHight);
                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(scaledImage, "jpg", newFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Duration "+(System.currentTimeMillis()-start));
    }
}
