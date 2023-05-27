package cs3500.pa02.Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * to sort files depending on the ordering flag
 */
public class SortFiles {
  public enum OrderingFlag {
    FILENAME,
    CREATED,
    MODIFIED;
  }

  /**
   * to sort the files based on the given attribute
   *
   * @param selectedFiles the files that need to be sorted
   * @param orderingFlag the attribute based on which we wish to sort
   */
  public static void sortFiles(ArrayList<MdFile> selectedFiles, OrderingFlag orderingFlag) {
    switch (orderingFlag) {
      case FILENAME : {
        Collections.sort(selectedFiles, new SortByName());
        break;
      }
      case CREATED: {
        Collections.sort(selectedFiles, new SortByCreation());
        break;
      }
      case MODIFIED: {
        Collections.sort(selectedFiles, new SortByLastMod());
      }
    }
  }
}
