package IME.control.command;

import IME.control.ImageCommand;
import IME.model.ImageProcessor;
/**
 * This class represent a HorizontalFlip command.
 */
public class Hflip implements ImageCommand {
  String from;
  String to;

  public Hflip(String from, String to) {
    this.from = from;
    this.to = to;
  }

  @Override
  public void go(ImageProcessor model) {
    model.horizontalFlip(from, to);
  }
}