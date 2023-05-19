package cs3500.pa01;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * to test writing given content to a file
 */
class WriteToFileTest {
  /**
   * to write a given string to a file
   */
  @Test
  public void testWriteToFile() {
    File file1 = new File("testFiles/kappa.md/");
    new WriteToFile().writeToFile(file1, "there once was a man\nabc");
    assertEquals(new ArrayList<String>(Arrays.asList("there once was a man", "abc")),
        FileReader.readFromFile(file1));
  }
}