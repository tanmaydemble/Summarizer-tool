package cs3500.pa02.Model;

import java.util.Comparator;

/**
 * to create a function object that implements the comparator interface so that we can
 * sort an array list of files by filename
 */
public class SortByName implements Comparator<MdFile> {
  /**
   * to compare two files by time filename so that we can sort them
   *
   * @param o1 the first file to be compared.
   * @param o2 the second file to be compared.
   * @return an integer that denotes which file should come first
   */
  @Override
  public int compare(MdFile o1, MdFile o2) {
    return o1.getFile().getName().compareTo(o2.getFile().getName());
  }
}
