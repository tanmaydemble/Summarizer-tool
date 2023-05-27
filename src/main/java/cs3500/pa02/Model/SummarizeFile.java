package cs3500.pa02.Model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * to take some content and find the headings and highlighted content from it and store it
 * in an arraylist of strings
 */
public class SummarizeFile {
  private ArrayList<TextAndIndex> summarizedContent = new ArrayList<>();
  private ArrayList<String> summarizedTextOnly = new ArrayList<>();
  ArrayList<Question> questions = new ArrayList<>();

  public ArrayList<String> getSummarizedTextOnly() {
    for (TextAndIndex t: summarizedContent) {
      summarizedTextOnly.add(t.getText());
    }
    return summarizedTextOnly;
  }

  public void sortSummarizedContent() {
    summarizedContent.sort(new SortTextAndIndex());
  }

  public void clearSummarized() {
    summarizedContent = new ArrayList<>();
    summarizedTextOnly = new ArrayList<>();
    questions = new ArrayList<>();
  }

  /**
   * a getter method to access the questions
   *
   * @return the questions
   */
  public ArrayList<Question> getQuestions() {
    return questions;
  }

  /**
   * to summarize the content in a file that is, find the headings and the highlighted content
   *
   * @param content the content in a file that needs to be summarized
   */
  public void summarize(String content) {
    String regex = "#(.*?)\\n";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(content);
    while (m.find()) {
        String highlightedContent = "\n" + m.group(0);
        int index = m.start(0);
        summarizedContent.add(new TextAndIndex(highlightedContent, index));

    }

    regex = "\\[\\[(.*?)\\]\\]";
    p = Pattern.compile(regex, Pattern.DOTALL);
    m = p.matcher(content);
    while (m.find()) {
      String selectedContent = m.group(1);
      if (selectedContent.contains(":::")) {
        int questionEndsAt = selectedContent.indexOf(":::");
        String question = selectedContent.substring(0,questionEndsAt);
        String answer = selectedContent.substring(questionEndsAt + 3);
        questions.add(new Question(question, answer, Question.difficulty.HARD));
      } else {
        String highlightedContent = "- " + m.group(1) + "\n";
        int index = m.start(1);
        summarizedContent.add(new TextAndIndex(highlightedContent, index));
      }
    }
  }
}

