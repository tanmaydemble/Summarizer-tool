package cs3500.pa02.Model;



import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa02.Model.MdFile;
import cs3500.pa02.Model.SortFiles;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * to test sorting of files by filename
 */
class SortByNameTest {

  /**
   * to test an assorted list of files by filename
   */
  @Test
  public void testSortByName() throws IOException {
    File file1 = new File("testFiles/Arrays.md");
    File file2 = new File("testFiles/kappa.md");
    File file3 = new File("testFiles/moreTestFiles/lecture2.md");

    BasicFileAttributes attr1 = Files.readAttributes(file1.toPath(), BasicFileAttributes.class);
    BasicFileAttributes attr2 = Files.readAttributes(file2.toPath(), BasicFileAttributes.class);
    BasicFileAttributes attr3 = Files.readAttributes(file3.toPath(), BasicFileAttributes.class);

    MdFile arrays = new MdFile(file1, attr1.creationTime(), attr1.lastModifiedTime());
    MdFile kappa = new MdFile(file2, attr2.creationTime(), attr2.lastModifiedTime());
    MdFile lecture2 = new MdFile(file3, attr3.creationTime(), attr3.lastModifiedTime());
    ArrayList<MdFile> selectedFiles = new ArrayList<MdFile>(Arrays.asList(kappa,
        kappa, arrays, lecture2));

    SortFiles.sortFiles(selectedFiles, SortFiles.OrderingFlag.FILENAME);
    assertEquals(new ArrayList<MdFile>(Arrays.asList(arrays, kappa, kappa, lecture2)),
        selectedFiles);
  }
}