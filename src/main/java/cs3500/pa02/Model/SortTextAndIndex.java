package cs3500.pa02.Model;

import java.util.Comparator;

/**
 * to sort text and index objects
 * we need to do this as using regex disturbs the order in which the strings occur in the file
 * hence the index notes where the string occurs in the file and then sorts all of them
 */
public class SortTextAndIndex implements Comparator<TextAndIndex> {

  /**
   * to compare two text and index objects
   *
   * @param text1 the first object to be compared.
   * @param text2 the second object to be compared.
   * @return
   */
  @Override
  public int compare(TextAndIndex text1, TextAndIndex text2) {
    return text1.getIndex() - text2.getIndex();
  }
}
