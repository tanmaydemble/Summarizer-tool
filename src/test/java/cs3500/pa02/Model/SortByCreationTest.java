package cs3500.pa02.Model;



import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa02.Model.MdFile;
import cs3500.pa02.Model.SortFiles;
import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * to test the sorting by creation
 */
class SortByCreationTest {
  /**
   * to sort a given list of files by creation
   */
  @Test
  public void testSortByCreation() throws IOException {
    File file1 = new File("testFiles/Arrays.md");
    File file2 = new File("testFiles/kappa.md");
    File file3 = new File("testFiles/moreTestFiles/lecture2.md");

    FileTime creation1 = FileTime.from(Instant.parse("2023-05-13T20:35:40.4590031Z"));
    FileTime creation2 = FileTime.from(Instant.parse("2023-05-13T20:41:52.5128642Z"));
    FileTime creation3 = FileTime.from(Instant.parse("2023-05-13T21:05:27.0562382Z"));

    MdFile arrays = new MdFile(file1, creation1, creation1);
    MdFile kappa = new MdFile(file2, creation2, creation2);
    MdFile lecture2 = new MdFile(file3, creation3, creation3);
    ArrayList<MdFile> selectedFiles = new ArrayList<MdFile>(Arrays.asList(kappa,
        kappa, arrays, lecture2));

    SortFiles.sortFiles(selectedFiles, SortFiles.OrderingFlag.CREATED);
    assertEquals(new ArrayList<MdFile>(Arrays.asList(arrays, kappa, kappa, lecture2)),
       selectedFiles);
  }
}