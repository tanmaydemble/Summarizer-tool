package cs3500.pa02.Model;

import static java.nio.file.FileVisitResult.CONTINUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa02.Driver;
import cs3500.pa02.Model.FileReader;
import cs3500.pa02.Model.FileSystemWalker;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 * to test the driver class
 */
class DriverTest {
  /**
   * to test the main method for different ordering flags
   *
   * @throws IOException throws an input output exception
   */
  @Test
  public void testMain() throws IOException {
    File outputFile = new File("testFileOutput/testFileOutput.md");
    String[] inputs =
        new String[] {"DriverTestFiles/", "filename", outputFile.toPath().toString()};

    Driver.main(inputs);
    assertEquals("# heading 1\n- point 1\n\n## heading 2\n",
        FileReader.readFromFile(outputFile));

    String[] inputs2 =
        new String[] {"DriverTestFiles/", "created", outputFile.toPath().toString()};

    Driver.main(inputs2);
    assertEquals("# heading 1\n- point 1\n\n## heading 2\n", FileReader.readFromFile(outputFile));

    String[] inputs3 =
        new String[] {"DriverTestFiles/", "modified", outputFile.toPath().toString()};

    Driver.main(inputs3);
    assertEquals("# heading 1\n- point 1\n\n## heading 2\n", FileReader.readFromFile(outputFile));

    File hidden = new File("nahMilega");
    assertThrows(RuntimeException.class, () -> FileReader.readFromFile(hidden));
    FileSystemWalker fsw = new FileSystemWalker();
    assertEquals(CONTINUE, fsw.visitFileFailed(hidden.toPath(),
        new IOException()));
  }

}