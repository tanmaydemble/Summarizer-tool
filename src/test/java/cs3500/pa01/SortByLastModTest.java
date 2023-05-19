package cs3500.pa01;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * to test sorting an array list of files by time of last modification
 */
class SortByLastModTest {
  /**
   * to test sorting of an assorted list of files by last modification
   */
  @Test
  public void testSortByLastMod() throws IOException {
    File file1 = new File("testFiles/Arrays.md");
    File file2 = new File("testFiles/kappa.md");
    File file3 = new File("testFiles/moreTestFiles/lecture2.md");

    FileTime lastMod1 = FileTime.from(Instant.parse("2023-05-15T18:12:34.7139322Z"));
    FileTime lastMod2 = FileTime.from(Instant.parse("2023-05-16T13:32:41.1497109Z"));
    FileTime lastMod3 = FileTime.from(Instant.parse("2023-05-13T21:05:27.0562382Z"));

    MdFile arrays = new MdFile(file1, lastMod1, lastMod1);
    MdFile kappa = new MdFile(file2, lastMod2, lastMod2);
    MdFile lecture2 = new MdFile(file3, lastMod3, lastMod3);

    ArrayList<MdFile> selectedFiles = new ArrayList<MdFile>(Arrays.asList(kappa,
        kappa, arrays, lecture2));

    SortFiles.sortFiles(selectedFiles, SortFiles.OrderingFlag.MODIFIED);
    assertEquals(new ArrayList<MdFile>(Arrays.asList(kappa, kappa, arrays, lecture2)),
        selectedFiles);
  }
}