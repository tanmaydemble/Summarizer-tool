package cs3500.pa02.Model;

import java.util.ArrayList;

/**
 * to represent a question
 */
public class Question implements Comparable<Question>{
  private String question;
  private String answer;

  public enum difficulty {
    EASY,
    HARD;
  }

  private difficulty initialDifficulty;
  private difficulty currentDifficulty;

  /**
   * the constructor for the question class
   *
   * @param question             question for this instance of this class
   * @param answer               answer of the question
   * @param initialDifficulty difficulty of this question when read from file
   */
  public Question(String question, String answer, difficulty initialDifficulty) {
    this.question = question;
    this.answer = answer;
    this.initialDifficulty = initialDifficulty;
    this.currentDifficulty = initialDifficulty;
  }

  @Override
  public int compareTo(Question question2) {
    return this.getInitialDifficulty().compareTo(question2.getInitialDifficulty()) * -1;
  }

  public String getWhatIsAsked() {
    return this.question;
  }

  public String getAnswer() {
    return this.answer;
  }

  public String getDifficulty() {
    return currentDifficulty.toString();
  }

  public String getInitialDifficulty() {
    return initialDifficulty.toString();
  }

  public boolean changeDifficulty(String newDifficulty) {
    if (currentDifficulty.equals(difficulty.EASY)
        && newDifficulty.equals("HARD")) {
      currentDifficulty = difficulty.HARD;
      return true;
    }
    if (currentDifficulty.equals(difficulty.HARD)
        && newDifficulty.equals("EASY")) {
      currentDifficulty = difficulty.EASY;
      return true;
    }
    return false;
  }


}
