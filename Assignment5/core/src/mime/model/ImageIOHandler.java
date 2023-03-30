package mime.model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;

/**
 * A class to be an image handler by using ImageIO library. Acceptable image format:
 * - bmp
 * - jpg
 * - jpeg
 * - png
 */
public class ImageIOHandler extends AbsrtuctImageHandler {

  /**
   * A constructor to construct an ImageIOHandler.
   */
  public ImageIOHandler() {
    super();
  }

  @Override
  public void readImage(InputStream stream) throws IOException {
    BufferedImage image = ImageIO.read(stream);

    if (image == null) {
      throw new IllegalStateException("Image is not accessible!");
    }

    int width = image.getWidth();
    int height = image.getHeight();
    this.info = new int[]{width, height, 255};

    int[] dataBuffInt = image.getRGB(0, 0, width, height, null, 0, width);
    this.image = new int[height][width][3];
    int row = 0;
    int col = 0;

    for (int rgb : dataBuffInt) {
      int red = (rgb >> 16) & 0xFF;
      int green = (rgb >> 8) & 0xFF;
      int blue = (rgb) & 0xFF;
      this.image[row][col] = new int[]{red, green, blue};
      col++;
      if (col == width) {
        col = 0;
        row++;
      }
    }
  }

  @Override
  public void saveImage(OutputStream stream, String format, int[] info, int[][][] image) throws IOException {

    BufferedImage buffImage = new BufferedImage(info[0], info[1], BufferedImage.TYPE_INT_RGB);
    int[] rgb;
    for (int row = 0; row < info[1]; row++) {
      for (int col = 0; col < info[0]; col++) {
        rgb = image[row][col];
        Color c = new Color(rgb[0], rgb[1], rgb[2]);
        buffImage.setRGB(col, row, c.getRGB());
      }
    }

    if (format.equals(".jpg") || format.equals("jpeg")) {
      ImageWriter jpgWriter = ImageIO.getImageWritersByFormatName(format).next();
      ImageWriteParam jpgWriteParam = jpgWriter.getDefaultWriteParam();
      jpgWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
      jpgWriteParam.setCompressionQuality(1f);

      jpgWriter.setOutput(ImageIO.createImageOutputStream(stream));
      IIOImage outputImage = new IIOImage(buffImage, null, null);
      jpgWriter.write(null, outputImage, jpgWriteParam);
      jpgWriter.dispose();
    } else {
      ImageIO.write(buffImage, format, stream);
    }

  }

}
