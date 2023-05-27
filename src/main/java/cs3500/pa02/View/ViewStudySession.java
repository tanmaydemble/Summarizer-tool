package cs3500.pa02.View;

import java.io.IOException;

/**
 * The functionality related to the view aspect of the study session
 * that is enabling the command line interface for the program
 */
public class ViewStudySession {
private final Appendable appendable;

  public ViewStudySession(Appendable appendable) {
    this.appendable = appendable;
  }

  /**
   * to welcome the user and ask for a file to read questions from
   */
  public void displayWelcomeMessage() {
    try {
      appendable.append("Welcome user! Happy studying!\nPlease provide a .sr file to retrieve the").
          append(" questions from :\n");
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  /**
   * to ask the user for the number of questions they would like to practice
   */
  public void requestNumQuestions() {
    try {
      appendable.append("Please enter the number of questions that you would like to practice:\n");
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  /**
   * to display the current question or answer and ask the user for the next action
   *
   * @param questionOrAnswer the question or answer that needs to be displayed
   * @param difficulty the difficulty of the question as a string
   * @param currentQuestionNum the question number that the user is on
   */
  public void displayQuestionOrAnswer(String questionOrAnswer, String difficulty,
                                             int currentQuestionNum) {
    try {
      appendable.append("\n" + "Question ").append(String.valueOf(currentQuestionNum))
          .append(": \n");
      appendable.append(difficulty).append(": ").append(questionOrAnswer).append("\n\n");
      appendable.append("Choose from the following by typing in the correct number:\n");
      appendable.append("1.Mark Hard\t2.Mark Easy\t3.Show Answer\n");
      appendable.append("4.Next Question\t5.Previous Question\t6.Exit Session\n");
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  /**
   * to display the statistics to the user at the end of the session
   *
   * @param numHardQuestions the number of hard questions that the user answered
   * @param totalQuestions the total number of questions in the question bank
   * @param hardToEasy the number of questions that went from hard to easy
   * @param easyToHard the number of questions that went from easy to hard
   * @param maxQuestions the total number of questions that the user answered in the current
   *                     session
   */
  public void displayStatistics(int numHardQuestions, int totalQuestions, int hardToEasy,
                                       int easyToHard, int maxQuestions) {
    try {
      appendable.append("Good Job!\n");
      appendable.append("You answered ").append(String.valueOf(maxQuestions))
          .append(" questions\n");
      appendable.append(String.valueOf(hardToEasy)).append(" questions went from hard to easy\n");
      appendable.append(String.valueOf(easyToHard)).append(" questions went from easy to hard\n");
      appendable.append("Current question bank count:\n");
      appendable.append(String.valueOf(numHardQuestions)).append(" hard questions\n");
      int numEasyQuestions = totalQuestions - numHardQuestions;
      appendable.append(String.valueOf(numEasyQuestions)).append(" easy questions\n");
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  /**
   * to inform the user that the difficulty has been changed to easy
   */
  public void confirmHardToEasy() {
    try {
      appendable.append("Difficulty changed to easy\n");
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  /**
   * to inform the user that the difficulty has been changed to hard
   */
  public void confirmEasyToHard() {
    try {
      appendable.append("Difficulty changed to hard\n");
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  /**
   * to inform the user that the difficulty marked and the existing difficulty is same
   */
  public void difficultyNotChanged() {
    try {
      appendable.append("The question already exists in the state that you opted to mark it in.\n");
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  /**
   * to inform the user that they cannot go back from the first question
   */
  public void cannotGoBack() {
    try {
      appendable.append("This is the first question, cannot go further back\n");
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  /**
   * to inform the user that they have entered an invalid number of questions to study
   *
   * @param totalQuestions total questions in the question bank
   */
  public void invalidNumQuestions(int totalQuestions) {
    try {
      appendable.append("Invalid number of questions given!\n");
      appendable.append("Please enter an integer between 1 and ")
          .append(String.valueOf(totalQuestions)).append("\n");
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  /**
   * to inform the user that they have chosen an option that is not available in the menu
   */
  public void invalidOption() {
    try {
      appendable.append("Option is not a valid option. Please choose again.\n");
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}
