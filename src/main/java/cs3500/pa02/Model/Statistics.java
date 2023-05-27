package cs3500.pa02.Model;

import java.util.ArrayList;

/**
 * to calculate the statistics at the end of the study session
 */
public class Statistics {

  /**
   * to calculate the number of hard questions in the question bank
   *
   * @param listOfQuestions questions in the question bank
   * @return number of hard questions as an int
   */
  public static int numHardQuestions(ArrayList<Question> listOfQuestions) {
    int numHardQuestions = 0;
    for (Question question: listOfQuestions) {
      if (question.getDifficulty().equals("HARD")) {
        numHardQuestions++;
      }
    }
    return numHardQuestions;
  }

  /**
   * to find the total questions that the user has viewed up till now
   *
   * @param maxQuestions the maximum questions studied before we include the current question number
   * @param currentQuestionNum current question number
   * @return an int representing the total questions that the user has viewed
   */
  public static int totalQuestionsStudied(int maxQuestions, int currentQuestionNum) {
    return Math.max(currentQuestionNum, maxQuestions);
  }

  /**
   * to find the number of questions that went from easy to hard
   *
   * @param listOfQuestions questions in the question bank
   * @return the number of questions that went from easy to hard
   */
  public static int numEasyToHard(ArrayList<Question> listOfQuestions) {
    int numEasyToHard = 0;
    for (Question q: listOfQuestions) {
      if (q.getInitialDifficulty().equals("EASY")
      && q.getDifficulty().equals("HARD")) {
        numEasyToHard++;
      }
    }
    return numEasyToHard;
  }

  /**
   * to find the number of questions that went from hard to easy
   *
   * @param listOfQuestions questions in the question bank
   * @return the number of questions that went from hard to easy
   */
  public static int numHardToEasy(ArrayList<Question> listOfQuestions) {
    int numHardToEasy = 0;
    for (Question q: listOfQuestions) {
      if (q.getInitialDifficulty().equals("HARD")
          && q.getDifficulty().equals("EASY")) {
        numHardToEasy++;
      }
    }
    return numHardToEasy;
  }

}
