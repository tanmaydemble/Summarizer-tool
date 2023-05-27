package cs3500.pa02.Model;

/**
 *  keeps track of a string and its position in the file
 *  we need to do this as using regex disturbs the order in which the strings occur in the file
 *  * hence the index notes where the string occurs in the file and then sorts all of them
 */
public class TextAndIndex {
  private String text;
  private int index; // index where this text is first found in the file

  TextAndIndex(String text, int index) {
    this.text = text;
    this.index = index;
  }

  /**
   * to get the text
   *
   * @return string representing the text
   */
  public String getText() {
    return text;
  }

  /**
   * to get the index where the string occurs in the file
   *
   * @return the index
   */
  public int getIndex() {
    return index;
  }
}
