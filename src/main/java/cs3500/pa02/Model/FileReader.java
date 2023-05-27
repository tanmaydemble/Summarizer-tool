package cs3500.pa02.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * To read the content from a given file
 */
public class FileReader {

  /**
   * Reads the content of a given file and returns each line as a separate string in an
   * arraylist
   *
   * @param file the file from which we read
   * @return an arraylist of string where each string is a line from the text
   */
  public static String readFromFile(File file) {
    Scanner sc;
    try {
      sc = new Scanner((new FileInputStream(file)));
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    StringBuilder sb = new StringBuilder();
    while (sc.hasNextLine()) {
      sb.append(sc.nextLine()).append("\n");
    }
    return sb.toString();
  }
}

