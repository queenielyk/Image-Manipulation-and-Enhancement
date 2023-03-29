package mime;

import org.junit.AfterClass;

import java.io.File;
import java.io.FileNotFoundException;

public class BmpTest extends AbstractMIPTest {
  public BmpTest() throws FileNotFoundException {
    super("res/format/cat.bmp", "res/processor.bmp", "bmp");
  }

  /**
   * A method to be executed at the end of the test class. Remove image exported from this test
   * class.
   */
  @AfterClass
  public static void removeDstPpm() {
    String dst = "res/processor.bmp";
    File myObj = new File(dst);
    myObj.delete();
  }

}
