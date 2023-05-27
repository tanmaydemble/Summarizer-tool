package cs3500.pa02.Model;

import static java.nio.file.FileVisitResult.CONTINUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa02.Model.FileSystemWalker;
import cs3500.pa02.Model.MdFile;
import cs3500.pa02.Model.TextAndIndex;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * to test walking the file system by walking the testFiles folder and visiting
 * files in the directory and the visit file failed method
 */
class FileSystemWalkerTest {
  /**
   * to test walking the testFiles folder and selecting the required files
   *
   * @throws IOException throws an input output exception
   */
  @Test
  public void testGetSelectedFiles() throws IOException {
    FileSystemWalker fsw = new FileSystemWalker();
    Path startingDirectory = Path.of("testFiles");
    Files.walkFileTree(startingDirectory, fsw);
    ArrayList<String> actualFiles = new ArrayList<String>();
    for (MdFile f : fsw.getSelectedFiles()) {
      actualFiles.add(f.getFile().getName().toString());
    }
    assertEquals(5, actualFiles.size());
    assertTrue(actualFiles.contains("alpha.md"));
    assertTrue(actualFiles.contains("Arrays.md"));
    assertTrue(actualFiles.contains("kappa.md"));
    assertTrue(actualFiles.contains("lecture2.md"));
    assertTrue(actualFiles.contains("Vectors.md"));

    File hidden = new File("testFiles/ginger.md/");
    assertEquals(CONTINUE, fsw.visitFileFailed(hidden.toPath(),
        new IOException()));
  }
}