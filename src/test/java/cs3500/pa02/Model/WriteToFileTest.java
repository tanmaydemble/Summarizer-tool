package cs3500.pa02.Model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa02.Model.FileReader;
import cs3500.pa02.Model.WriteToFile;
import java.io.File;
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
    WriteToFile.writeToFile(file1, "there once was a man\nabc");
    assertEquals("there once was a man\nabc\n", FileReader.readFromFile(file1));
  }

  /**
   * to test unimplemented methods throwing exceptions
   */
  @Test
  public void testUnimplementedMethods() {

    assertThrows(UnsupportedOperationException.class, () -> new WriteToFile().append('c'),
        "This method should not be called");
    assertThrows(UnsupportedOperationException.class, () -> new WriteToFile().append("abc"),
        "This method should not be called");
    assertThrows(UnsupportedOperationException.class,
        () -> new WriteToFile().append("abc", 1, 2),
        "This method should not be called");
  }
}