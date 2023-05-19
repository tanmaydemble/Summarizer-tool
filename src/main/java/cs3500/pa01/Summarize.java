package cs3500.pa01;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * to take some content and find the headings and highlighted content from it and store it
 * in an arraylist of strings
 */
public class Summarize {
  private ArrayList<String> summarizedContent = new ArrayList<String>();

  /**
   * a getter method to access the summarized content
   *
   * @return the summarized content
   */
  public ArrayList<String> getSummarizedContent() {
    return summarizedContent;
  }

  /**
   * to summarize the content in a file that is, find the headings and the highlighted content
   *
   * @param content the content in a file that needs to be summarized
   */
  public void summarize(String content) {
    if (content.startsWith("#")) {
      summarizedContent.add("");
      summarizedContent.add(content);
    }
    String regex = "\\[\\[(.*?)\\]\\]";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(content);
    while (m.find()) {
      String highlightedContent = "- " + m.group(1);
      summarizedContent.add(highlightedContent);
    }
  }
}

