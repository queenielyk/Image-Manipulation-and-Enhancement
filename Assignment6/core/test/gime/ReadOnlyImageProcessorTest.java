package gime;

import static org.junit.Assert.assertEquals;

import gime.model.ReadOnlyImageProcessor;
import gime.model.ReadOnlyImageProcessorImpl;
import java.util.Arrays;
import java.util.Iterator;
import mime.model.MoreImageProcessor;
import mime.model.MoreImageProcessorImpl;
import org.junit.Test;

/**
 * A test class for ReadOnlyImageProcessor.
 */
public class ReadOnlyImageProcessorTest {

  @Test(expected = ClassCastException.class)
  public void testCastingReadOnly() {
    MoreImageProcessor processor = new MoreImageProcessorImpl();
    ReadOnlyImageProcessor ro = new ReadOnlyImageProcessorImpl(processor);

    processor.loadImage(new int[]{1, 1, 255}, new int[][][]{{{255, 255, 255}}}, "image");
    ro = (MoreImageProcessor) ro;
  }

  @Test
  public void testSameInstance() {
    MoreImageProcessor processor = new MoreImageProcessorImpl();
    ReadOnlyImageProcessor ro = new ReadOnlyImageProcessorImpl(processor);

    processor.loadImage(new int[]{1, 1, 255}, new int[][][]{{{255, 255, 255}}}, "image");
    assertEquals(processor.getInfo("image").toString(), ro.getInfo("image").toString());
  }


  @Test
  public void testImageNameList() {
    MoreImageProcessor processor = new MoreImageProcessorImpl();
    ReadOnlyImageProcessor ro = new ReadOnlyImageProcessorImpl(processor);
    String[] imageList = new String[]{"image1", "image2", "image3", "image4", "image5"};

    processor.loadImage(new int[]{1, 1, 255}, new int[][][]{{{255, 255, 255}}}, "image1");
    processor.loadImage(new int[]{1, 1, 255}, new int[][][]{{{255, 255, 255}}}, "image2");
    processor.loadImage(new int[]{1, 1, 255}, new int[][][]{{{255, 255, 255}}}, "image3");
    processor.loadImage(new int[]{1, 1, 255}, new int[][][]{{{255, 255, 255}}}, "image4");
    processor.loadImage(new int[]{1, 1, 255}, new int[][][]{{{255, 255, 255}}}, "image5");

    int count = 0;
    for (Iterator<String> it =
        Arrays.stream(ro.getNameList()).sorted().iterator(); it.hasNext(); ) {
      String tmp = it.next();
      assertEquals(imageList[count], tmp);
      count++;
    }
  }

}
