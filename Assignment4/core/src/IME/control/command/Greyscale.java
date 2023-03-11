package IME.control.command;

import IME.control.ImageCommand;
import IME.model.ImageProcessor;

/**
 * This class represent a Greyscale command.
 */
public class Greyscale implements ImageCommand {
  String mode;
  String from;
  String to;

  public Greyscale(String mode, String from, String to) {
    this.mode = mode;
    this.from = from;
    this.to = to;
  }

  @Override
  public void go(ImageProcessor model) {
    model.greyscale(mode, from, to);
  }
}