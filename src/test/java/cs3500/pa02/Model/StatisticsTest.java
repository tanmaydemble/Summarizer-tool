package cs3500.pa02.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * to test the methods in the statistics class
 */
class StatisticsTest {
  Question question1;
  Question question2;
  Question question3;
  ArrayList<Question> listOfQuestion;
  /**
   * to get the list of questions for the test
   */
  @BeforeEach
  public void getListOfQuestions() {
    question1 = new Question("Question1",
        "Answer1", Question.difficulty.EASY);
    question2 = new Question("Question2", "Answer2",
        Question.difficulty.HARD);
    question3 = new Question("Question3", "Answer3",
        Question.difficulty.HARD);
    listOfQuestion = new ArrayList<>(Arrays.asList(question1, question2,
        question3));
  }
  /**
   * to test the number of hard questions in the question bank
   */
  @Test
  public void testNumHardQuestions() {
    assertEquals(Statistics.numHardQuestions(listOfQuestion), 2);
  }

  /**
   * to test the total number of questions studied
   */
  @Test
  public void testTotalQuestionsStudied() {
    assertEquals(Statistics.totalQuestionsStudied(3, 1), 3);
    assertEquals(Statistics.totalQuestionsStudied(2, 3), 3);
  }

  /**
   * to test the questions that go from easy to hard
   */
  @Test
  public void testNumEasyToHard() {
    question1.changeDifficulty("HARD");
    assertEquals(Statistics.numEasyToHard(listOfQuestion), 1);
  }

  /**
   * to test the questions that go from hard to easy
   */
  @Test
  public void testNumHardToEasy() {
    question3.changeDifficulty("EASY");
    question2.changeDifficulty("EASY");
    assertEquals(Statistics.numHardToEasy(listOfQuestion), 2);
  }
}