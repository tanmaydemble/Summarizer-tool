package cs3500.pa02.View;

import java.io.IOException;

public class MockViewStudySession {

  public MockViewStudySession() {
  }

  /**
   * to help throw exception in each method
   *
   * @throws IOException the IOException thrown
   */
  private void throwInOut() throws IOException {
    throw new IOException("Mock throwing an error");
  }

  /**
   * to welcome the user and ask for a file to read questions from
   */
  public void displayWelcomeMessage() throws IOException {
    throwInOut();
  }

  /**
   * to ask the user for the number of questions they would like to practice
   */
  public void requestNumQuestions() throws IOException {
    throwInOut();
  }

  /**
   * to display the current question or answer and ask the user for the next action
   *
   * @param questionOrAnswer   the question or answer that needs to be displayed
   * @param difficulty         the difficulty of the question as a string
   * @param currentQuestionNum the question number that the user is on
   */
  public void displayQuestionOrAnswer(String questionOrAnswer, String difficulty,
                                      int currentQuestionNum) throws IOException {
    throwInOut();
  }


  /**
   * to display the statistics to the user at the end of the session
   *
   * @param numHardQuestions the number of hard questions that the user answered
   * @param totalQuestions   the total number of questions in the question bank
   * @param hardToEasy       the number of questions that went from hard to easy
   * @param easyToHard       the number of questions that went from easy to hard
   * @param maxQuestions     the total number of questions that the user answered in the current
   *                         session
   */
  public void displayStatistics(int numHardQuestions, int totalQuestions, int hardToEasy,
                                int easyToHard, int maxQuestions) throws IOException {
    throwInOut();
  }

  /**
   * to inform the user that the difficulty has been changed to easy
   */
  public void confirmHardToEasy() throws IOException {
    throwInOut();
  }

  /**
   * to inform the user that the difficulty has been changed to hard
   */
  public void confirmEasyToHard() throws IOException {
    throwInOut();
  }

  /**
   * to inform the user that the difficulty marked and the existing difficulty is same
   */
  public void difficultyNotChanged() throws IOException {
    throwInOut();
  }

  /**
   * to inform the user that they cannot go back from the first question
   */
  public void cannotGoBack() throws IOException {
    throwInOut();
  }

  /**
   * to inform the user that they have entered an invalid number of questions to study
   *
   * @param totalQuestions total questions in the question bank
   */
  public void invalidNumQuestions(int totalQuestions) throws IOException {
    throwInOut();
  }

  /**
   * to inform the user that they have chosen an option that is not available in the menu
   */
  public void invalidOption() throws IOException {
    throwInOut();
  }
}
