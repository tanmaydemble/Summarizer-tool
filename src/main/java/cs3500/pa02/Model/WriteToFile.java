package cs3500.pa02.Model;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * to write the content to a file
 */
public class WriteToFile implements Appendable{
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

  /**
   * implemented because required by interface, not to be used
   *
   * @param csq
   *         The character sequence to append.  If {@code csq} is
   *         {@code null}, then the four characters {@code "null"} are
   *         appended to this Appendable.
   *
   * @return NA
   * @throws IOException NA
   */
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new UnsupportedOperationException("This method should not be called");
  }

  /**
   * implemented because required by interface, not to be used
   *
   * @param csq
   *         The character sequence from which a subsequence will be
   *         appended.  If {@code csq} is {@code null}, then characters
   *         will be appended as if {@code csq} contained the four
   *         characters {@code "null"}.
   *
   * @param start
   *         The index of the first character in the subsequence
   *
   * @param end
   *         The index of the character following the last character in the
   *         subsequence
   *
   * @return NA
   * @throws IOException NA
   */
  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new UnsupportedOperationException("This method should not be called");
  }

  /**
   * implemented because required by interface, not to be used
   *
   * @param c
   *         The character to append
   *
   * @return NA
   * @throws IOException NA
   */
  @Override
  public Appendable append(char c) throws IOException {
    throw new UnsupportedOperationException("This method should not be called");
  }
}
