package cs3500.pa01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Comparator;

/**
 * to create a function object that implements the comparator interface so that we can
 * sort an array list of files by last modified time
 */
public class SortByLastMod implements Comparator<MdFile> {
  /**
   * to compare two files by time last modified so that we can sort them
   *
   * @param o1 the first file to be compared.
   * @param o2 the second file to be compared.
   * @return an integer that denotes which file should come first
   */
  @Override
  public int compare(MdFile o1, MdFile o2) {
   return o1.getLastModTime().compareTo(o2.getLastModTime()) * -1;
  }
}