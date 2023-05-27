package cs3500.pa02.View;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ViewStudySessionTest {
  StringBuilder stringBuilder;
  ViewStudySession viewStudySession;

  @BeforeEach
  public void setUp() {
    stringBuilder = new StringBuilder();
    viewStudySession = new ViewStudySession(stringBuilder);
  }

  /**
   * to test the method displayWelcomeMessage in class ViewStudySession
   */
  @Test
  public void testDisplayWelcomeMessage() {
    viewStudySession.displayWelcomeMessage();
    assertEquals("""
        Welcome user! Happy studying!
        Please provide a .sr file to retrieve the questions from :
        """, stringBuilder.toString());
  }

  /**
   * to test the method requestNumQuestions in class ViewStudySession
   */
  @Test
  public void testRequestNumQuestions() {
    viewStudySession.requestNumQuestions();
    assertEquals("Please enter the number of questions that you would like to practice:\n",
        stringBuilder.toString());
  }

  /**
   * to test the method displayQuestionOrAnswer in class ViewStudySession
   */
  @Test
  public void testDisplayQuestionOrAnswer() {
    viewStudySession.displayQuestionOrAnswer("Question1", "HARD", 1);
    assertEquals("""

        Question 1:\s
        HARD: Question1

        Choose from the following by typing in the correct number:
        1.Mark Hard\t2.Mark Easy\t3.Show Answer
        4.Next Question\t5.Previous Question\t6.Exit Session
        """, stringBuilder.toString());
  }

  /**
   * to test the method displayStatistics in class ViewStudySession
   */
  @Test
  public void testDisplayStatistics() {
    viewStudySession.displayStatistics(2, 4, 1, 1, 2);
    assertEquals("""
        Good Job!
        You answered 2 questions
        1 questions went from hard to easy
        1 questions went from easy to hard
        Current question bank count:
        2 hard questions
        2 easy questions
        """, stringBuilder.toString());
  }

  /**
   * to test the method confirmHardToEasy in class ViewStudySession
   */
  @Test
  public void testConfirmHardToEasy() {
    viewStudySession.confirmHardToEasy();
    assertEquals("Difficulty changed to easy\n", stringBuilder.toString());
  }

  /**
   * to test the method confirmEasyToHard in class ViewStudySession
   */
  @Test
  public void testConfirmEasyToHard() {
    viewStudySession.confirmEasyToHard();
    assertEquals("Difficulty changed to hard\n", stringBuilder.toString());
  }

  /**
   * to test the method difficultyNotChanged in class ViewStudySession
   */
  @Test
  public void testDifficultyNotChanged() {
    viewStudySession.difficultyNotChanged();
    assertEquals("The question already exists in the state that you opted to mark it" +
        " in.\n", stringBuilder.toString());
  }

  /**
   * to test the method cannotGoBack in class ViewStudySession
   */
  @Test
  public void testCannotGoBack() {
    viewStudySession.cannotGoBack();
    assertEquals("This is the first question, cannot go further back\n",
        stringBuilder.toString());
  }

  /**
   * to test the method invalidNumQuestions in class ViewStudySession
   */
  @Test
  public void testInvalidNumQuestions() {
    viewStudySession.invalidNumQuestions(7);
    assertEquals("""
        Invalid number of questions given!
        Please enter an integer between 1 and 7
        """, stringBuilder.toString());
  }

  /**
   * to test the method invalidOption in class ViewStudySession
   */
  @Test
  public void testInvalidOption() {
    viewStudySession.invalidOption();
    assertEquals("Option is not a valid option. Please choose again.\n",
        stringBuilder.toString());
  }
}