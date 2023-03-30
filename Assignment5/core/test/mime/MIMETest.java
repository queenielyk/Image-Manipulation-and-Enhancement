package mime;


import static org.junit.Assert.assertEquals;

import ime.IMETest;
import ime.control.IController;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import mime.control.MoreImageController;
import mime.model.MoreImageProcessorImpl;
import org.junit.Test;

/**
 * This is a test class for MVC as whole program.
 */
public class MIMETest extends IMETest {

  @Test
  public void RunScriptForMIMETest() throws IOException {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("run res/newscript.text");
    IController controller = new MoreImageController(in, out);
    controller.run(new MoreImageProcessorImpl());
    assertEquals("Enter Command:Executed: \tload res/cat.ppm cat\n"
        + "Executed: \tsave res/format/cat.jpg cat\n"
        + "Executed: \tsave res/format/cat.jpeg cat\n"
        + "Executed: \tsave res/format/cat.png cat\n"
        + "Executed: \tsave res/format/cat.bmp cat\n"
        + "Executed: \tload res/format/cat.jpg cat\n"
        + "Executed: \tload res/format/cat.bmp cat\n"
        + "Executed: \tload res/format/cat.jpeg cat\n"
        + "Executed: \tload res/format/cat.png cat\n"
        + "Executed: \tload res/cat.ppm cat\n"
        + "Executed: \tgreyscale cat cat-grey2\n"
        + "Executed: \tsave res/mime/cat-grey2.jpeg cat-grey2\n"
        + "Executed: \tsave res/mime/cat-grey2.jpg cat-grey2\n"
        + "Executed: \tsave res/mime/cat-grey2.png cat-grey2\n"
        + "Executed: \tsave res/mime/cat-grey2.bmp cat-grey2\n"
        + "Executed: \tsave res/mime/cat-grey2.ppm cat-grey2\n"
        + "Executed: \tsepia cat cat-sepia\n"
        + "Executed: \tsave res/mime/cat-sepia.jpeg cat-sepia\n"
        + "Executed: \tsave res/mime/cat-sepia.jpg cat-sepia\n"
        + "Executed: \tsave res/mime/cat-sepia.png cat-sepia\n"
        + "Executed: \tsave res/mime/cat-sepia.bmp cat-sepia\n"
        + "Executed: \tsave res/mime/cat-sepia.ppm cat-sepia\n"
        + "Executed: \tsharpen cat cat-sharpen\n"
        + "Executed: \tsave res/mime/cat-sharpen.jpeg cat-sharpen\n"
        + "Executed: \tsave res/mime/cat-sharpen.jpg cat-sharpen\n"
        + "Executed: \tsave res/mime/cat-sharpen.png cat-sharpen\n"
        + "Executed: \tsave res/mime/cat-sharpen.bmp cat-sharpen\n"
        + "Executed: \tsave res/mime/cat-sharpen.ppm cat-sharpen\n"
        + "Executed: \tblur cat cat-blur\n"
        + "Executed: \tsave res/mime/cat-blur.jpeg cat-blur\n"
        + "Executed: \tsave res/mime/cat-blur.jpg cat-blur\n"
        + "Executed: \tsave res/mime/cat-blur.png cat-blur\n"
        + "Executed: \tsave res/mime/cat-blur.bmp cat-blur\n"
        + "Executed: \tsave res/mime/cat-blur.ppm cat-blur\n"
        + "Executed: \tdither cat cat-dither\n"
        + "Executed: \tsave res/mime/cat-dither.jpeg cat-dither\n"
        + "Executed: \tsave res/mime/cat-dither.jpg cat-dither\n"
        + "Executed: \tsave res/mime/cat-dither.png cat-dither\n"
        + "Executed: \tsave res/mime/cat-dither.bmp cat-dither\n"
        + "Executed: \tsave res/mime/cat-dither.ppm cat-dither\n"
        + "\n"
        + "Enter Command:", out.toString());
  }




}
