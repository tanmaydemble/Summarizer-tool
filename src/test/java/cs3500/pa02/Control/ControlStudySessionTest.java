package cs3500.pa02.Control;

import static org.junit.jupiter.api.Assertions.*;

import java.io.StringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *  to test the methods in the control study session class
 */
class ControlStudySessionTest {
  /**
   * to test the method runStudySession
   */
  @Test
  void runStudySession() {
    /*String input = "testFileOutput/testReadSrFile.sr\n2\n6\n";
    StringReader stringReader = new StringReader(input);
    StringBuilder stringBuilder = new StringBuilder();
    ControlStudySession control = new ControlStudySession(stringReader, stringBuilder);
    control.runStudySession();
    assertEquals("Welcome user! Happy studying!\n" +
        "Please provide a .sr file to retrieve the questions from :\n" +
        "Please enter the number of questions that you would like to practice:\n" +
        "\n" +
        "Question 1: \n" +
        "HARD: Question1\n" +
        "\n" +
        "Choose from the following by typing in the correct number:\n" +
        "1.Mark Hard\t2.Mark Easy\t3.Show Answer\n" +
        "4.Next Question\t5.Previous Question\t6.Exit Session\n" +
        "Good Job!\n" +
        "You answered 1 questions\n" +
        "0 questions went from hard to easy\n" +
        "0 questions went from easy to hard\n" +
        "Current question bank count:\n" +
        "3 hard questions\n" +
        "0 easy questions\n", stringBuilder.toString());*/
  }

  @Test
  void requestOption() {
  }

  @Test
  void readInput() {
  }

  @Test
  void requestTargetNumQuestions() {
  }

  @Test
  void nextAction() {
  }
}