package cs3500.pa02.Control;

import static org.junit.jupiter.api.Assertions.*;

import java.io.StringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * to test the methods in the control study session class
 */
class ControlStudySessionTest {
  /**
   * to test the method runStudySession and see if it welcomes the user, asks for the sr file
   * and processes the number of questions a user would like to practice
   * pressing 6 quits the study session
   */
  @Test
  void runStudySession() {
    String input = "testFileOutput/testReadSrFile.sr\n2\n6\n";
    StringReader stringReader = new StringReader(input);
    StringBuilder stringBuilder = new StringBuilder();
    ControlStudySession control = new ControlStudySession(stringReader, stringBuilder);
    control.runStudySession();
    assertTrue(stringBuilder.toString().contains("Welcome user! Happy studying!\n"));
    assertTrue(stringBuilder.toString().contains("Please provide a .sr file to retrieve the" +
        " questions from :\n"));
    assertTrue(stringBuilder.toString().contains("Please enter the number of questions that you" +
        " would like to practice:\n"));
    assertTrue(stringBuilder.toString().contains("Choose from the following by typing in the" +
        " correct number:\n" +
        "1.Mark Hard\t2.Mark Easy\t3.Show Answer\n" +
        "4.Next Question\t5.Previous Question\t6.Exit Session"));
  }

  /**
   * to test invalid input for target number of questions to be practised such as
   * 2.5 questions or 5 questions (as the question bank for this file contains 3 questions)
   * pressing 6 quits the study session
   */
  @Test
  public void testInvalidNumQuestionsGiven() {
    String input = "testFileOutput/testReadSrFile.sr\n2.5\n2\n6\n";
    StringReader stringReader = new StringReader(input);
    StringBuilder stringBuilder = new StringBuilder();
    ControlStudySession control = new ControlStudySession(stringReader, stringBuilder);
    control.runStudySession();
    assertTrue(stringBuilder.toString().contains("Invalid number of questions given!\n"));

    input = "testFileOutput/testReadSrFile.sr\n5\n2\n6\n";
    stringReader = new StringReader(input);
    stringBuilder = new StringBuilder();
    control = new ControlStudySession(stringReader, stringBuilder);
    control.runStudySession();
    assertTrue(stringBuilder.toString().contains("Invalid number of questions given!\n"));
  }

  /**
   * the user can only choose options 1-6. hence, choosing a double like 2.5 or a negative option
   * like 3 will cause the program to ask the user for a valid input again
   * pressing 6 quits the study session
   */
  @Test
  public void testInvalidOptionGiven() {
    String input = "testFileOutput/testReadSrFile.sr\n2\n-3\n6\n";
    StringReader stringReader = new StringReader(input);
    StringBuilder stringBuilder = new StringBuilder();
    ControlStudySession control = new ControlStudySession(stringReader, stringBuilder);
    control.runStudySession();
    assertTrue(stringBuilder.toString().contains("Option is not a valid option." +
        " Please choose again.\n"));

    input = "testFileOutput/testReadSrFile.sr\n2\n2.5\n6\n";
    stringReader = new StringReader(input);
    stringBuilder = new StringBuilder();
    control = new ControlStudySession(stringReader, stringBuilder);
    control.runStudySession();
    assertTrue(stringBuilder.toString().contains("Option is not a valid option." +
        " Please choose again.\n"));
  }

  /**
   * to test marking a question hard or easy
   * the initial difficulty of the question in the test is hard, by pressing 2, we change it
   * to easy and then pressing 1, we change it to hard again. pressing 6 quits the study session
   */
  @Test
  public void nextActionMarkHardAndEasy() {
    String input = "testFileOutput/testReadSrFile.sr\n2\n2\n1\n6\n";
    StringReader stringReader = new StringReader(input);
    StringBuilder stringBuilder = new StringBuilder();
    ControlStudySession control = new ControlStudySession(stringReader, stringBuilder);
    control.runStudySession();
    assertTrue(stringBuilder.toString().contains("Difficulty changed to hard\n"));
    assertTrue(stringBuilder.toString().contains("Difficulty changed to easy\n"));
  }

  /**
   * to test the error message we get when we choose to mark a question that is already hard
   * as hard again
   */
  @Test
  public void testAlreadyHardAndEasy() {
    String input = "testFileOutput/testReadSrFile.sr\n2\n1\n6\n";
    StringReader stringReader = new StringReader(input);
    StringBuilder stringBuilder = new StringBuilder();
    ControlStudySession control = new ControlStudySession(stringReader, stringBuilder);
    control.runStudySession();
    //assertEquals("",stringBuilder.toString());
    assertTrue(stringBuilder.toString().contains("The question already exists in the state that" +
        " you opted to mark it in.\n"));
  }

  /**
   * to test showing the answer when the user presses 3
   */
  @Test
  public void testShowAnswer() {
    String input = "testFileOutput/testReadSrFile.sr\n2\n3\n6\n";
    StringReader stringReader = new StringReader(input);
    StringBuilder stringBuilder = new StringBuilder();
    ControlStudySession control = new ControlStudySession(stringReader, stringBuilder);
    control.runStudySession();
    assertTrue(stringBuilder.toString().contains("Answer1") ||
        stringBuilder.toString().contains("Answer2") ||
        stringBuilder.toString().contains("Answer3"));
  }

  /**
   * to test that we move to the next question when the user presses 4
   * here we have three questions in the question bank. hence pressing next question
   * thrice is going to bring us to the end of the study session where we get the good job!
   * message
   */
  @Test
  public void testNextQuestion() {
    String input = "testFileOutput/testReadSrFile.sr\n2\n4\n4\n4\n";
    StringReader stringReader = new StringReader(input);
    StringBuilder stringBuilder = new StringBuilder();
    ControlStudySession control = new ControlStudySession(stringReader, stringBuilder);
    control.runStudySession();
    assertTrue(stringBuilder.toString().contains("Good Job!"));
  }

  /**
   * to test the previous question functionality. when starting this session, we go to the next
   * question, and then we go back twice using 5, and we encounter the error message that we are
   * at the first question
   */
  @Test
  public void testPrevQuestion() {
    String input = "testFileOutput/testReadSrFile.sr\n2\n4\n5\n5\n6\n";
    StringReader stringReader = new StringReader(input);
    StringBuilder stringBuilder = new StringBuilder();
    ControlStudySession control = new ControlStudySession(stringReader, stringBuilder);
    control.runStudySession();
    assertTrue(stringBuilder.toString().contains("This is the first question, cannot go further" +
        " back"));
  }

  /**
   * to test the quit study session method, we say that we are going to target studying 3
   * questions, and then we go next once. hence we have studied two questions and that is what
   * we get when we quit the study session
   */
  @Test
  public void testQuitStudySession() {
    String input = "testFileOutput/testReadSrFile.sr\n3\n4\n6\n";
    StringReader stringReader = new StringReader(input);
    StringBuilder stringBuilder = new StringBuilder();
    ControlStudySession control = new ControlStudySession(stringReader, stringBuilder);
    control.runStudySession();
    assertTrue(stringBuilder.toString().contains("You answered 2 questions\n"));
  }
}