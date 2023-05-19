package cs3500.pa01;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * to write the content to a file
 */
public class WriteToFile {
  /**
   * takes the given content and writes it in a new file
   *
   * @param file the file where the content needs to be written
   * @param contents the actual content that needs to be written in the file
   */
  public static void writeToFile(File file, String contents) {
    Path path = file.toPath();
    byte[] data = contents.getBytes();
    try {
      Files.write(path, data);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
