package cs3500.pa02.Control;

import static java.nio.file.FileVisitResult.CONTINUE;
import static org.junit.jupiter.api.Assertions.*;

import cs3500.pa02.Model.FileReader;
import cs3500.pa02.Model.FileSystemWalker;
import cs3500.pa02.Model.SortFiles;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

/**
 * to test the summarizing of notes
 */
class CreateSummaryTest {

  /**
   * to test that we write the summary to the given md file and the questions to the required
   * sr file
   *
   * @throws IOException
   */
  @Test
  public void testCreateSummary() throws IOException {
    CreateSummary createSummary = new CreateSummary();
    File outputFile = new File("testFileOutput/testFileOutput.md");
    Path driverTestFiles = Path.of("DriverTestFiles");

    createSummary.createSummary(driverTestFiles, SortFiles.OrderingFlag.FILENAME,
        outputFile.toPath());
    assertEquals("# heading 1\n- point 1\n\n## heading 2\n",
        FileReader.readFromFile(outputFile));

    createSummary.createSummary(driverTestFiles, SortFiles.OrderingFlag.CREATED,
        outputFile.toPath());
    assertEquals("# heading 1\n- point 1\n\n## heading 2\n",
        FileReader.readFromFile(outputFile));

    createSummary.createSummary(driverTestFiles, SortFiles.OrderingFlag.MODIFIED,
        outputFile.toPath());
    assertEquals("# heading 1\n- point 1\n\n## heading 2\n",
        FileReader.readFromFile(outputFile));

    File testFileOutput = new File("testFileOutput/Questions.sr");
    assertEquals("Question\n" +
        ":::\n" +
        "Answer\n" +
        "HARD\n" +
        "Question2\n" +
        ":::\n" +
        "Answer2\n" +
        "HARD\n", FileReader.readFromFile(testFileOutput));

    File hidden = new File("nahMilega");
    assertThrows(RuntimeException.class, () -> FileReader.readFromFile(hidden));
    FileSystemWalker fsw = new FileSystemWalker();
    assertEquals(CONTINUE, fsw.visitFileFailed(hidden.toPath(),
        new IOException()));
  }
}