package cs3500.pa01;

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
  public static ArrayList<String> readFromFile(File file) {
    Scanner sc;
    ArrayList<String> content = new ArrayList<String>();
    try {
      sc = new Scanner(new FileInputStream(file));
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    while (sc.hasNextLine()) {
      content.add(sc.nextLine());
    }
    return content;
  }
}
