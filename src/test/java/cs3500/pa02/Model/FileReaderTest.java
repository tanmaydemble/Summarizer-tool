package cs3500.pa02.Model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa02.Model.FileReader;
import java.io.File;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

/**
 * to test the file reading functionality
 *
 */
class FileReaderTest {
  /**
   * to read the file alpha.md and to check for the file not found exception
   */
  @Test
  public void testFileReader() {
    Path filePath = Path.of("testFiles/alpha.md/");
    File file1 = filePath.toFile();
    /*assertEquals(new ArrayList<String>(Arrays.asList("You read file alpha.md",
            "this is the second line", "# heading 1",
            "## heading 2", "[[this is the third line]] not this [[third line part 2]]", "7:50")),
        FileReader.readFromFile(file1));*/

    File hidden = new File("nahMilega");
    assertThrows(RuntimeException.class, () -> FileReader.readFromFile(hidden));

    assertEquals("You read file alpha.md\n" +
        "this is the second line\n" +
        "# heading 1\n" +
        "## heading 2\n" +
        "[[this is the third line]] not this [[third line part 2]]\n" +
        "7:50\n" +
        "\n" +
        "[[Question1:::\n" +
        "Answer1]]\n" +
        "[[Question2:::Answer2]]\n" +
        "[[Question3:::Answer3]]\n", FileReader.readFromFile(file1));
  }
}