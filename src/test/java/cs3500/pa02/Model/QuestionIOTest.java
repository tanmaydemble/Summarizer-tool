package cs3500.pa02.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * to test the input of a list of questions to a file and the conversion of a file to a list of
 * questions
 */
class QuestionIOTest {
  /**
   * to test the conversion of a list of questions of a string
   */
  @Test
  public void testBuildQuestionString() {
    Question question1 = new Question("Question1",
        "Answer1", Question.difficulty.EASY);
    Question question2 = new Question("Question2", "Answer2",
        Question.difficulty.HARD);
    Question question3 = new Question("Question3", "Answer3",
        Question.difficulty.HARD);
    ArrayList<Question> questions = new ArrayList<>(Arrays.asList(question1,
        question2, question3));

    QuestionIO questionIO = new QuestionIO();
    questionIO.buildQuestionString(questions);
    assertEquals("Question1\nA\nAnswer1\nEASY\nQuestion2\nA\nAnswer2\nHARD\n" +
        "Question3\nA\nAnswer3\nHARD\n", questionIO.getQuestionString());
  }

  /**
   * to test the conversion of a string to a list of questions
   */
  @Test
  public void testBuildQuestionList() {
    String questionString = "Question1\n\n:::\nAnswer1\nHARD\nQuestion2\n:::\nAnswer2\nEASY\n";
    QuestionIO questionIO = new QuestionIO();
    questionIO.buildQuestionList(questionString);

    assertEquals("Question1\n", questionIO.getListOfQuestions().get(0).getWhatIsAsked());
    assertEquals("Answer1", questionIO.getListOfQuestions().get(0).getAnswer());
    assertEquals("HARD", questionIO.getListOfQuestions().get(0).getDifficulty());

    assertEquals("Question2", questionIO.getListOfQuestions().get(1).getWhatIsAsked());
    assertEquals("Answer2", questionIO.getListOfQuestions().get(1).getAnswer());
    assertEquals("EASY", questionIO.getListOfQuestions().get(1).getDifficulty());

    questionString = "Question1\n\n:::\nAnswer1\nEASY\nQuestion2\n:::\nAnswer2\nHARD\n";
    questionIO = new QuestionIO();
    questionIO.buildQuestionList(questionString);

    assertEquals("Question1\n", questionIO.getListOfQuestions().get(0).getWhatIsAsked());
    assertEquals("Answer1", questionIO.getListOfQuestions().get(0).getAnswer());
    assertEquals("EASY", questionIO.getListOfQuestions().get(0).getDifficulty());

    assertEquals("Question2", questionIO.getListOfQuestions().get(1).getWhatIsAsked());
    assertEquals("Answer2", questionIO.getListOfQuestions().get(1).getAnswer());
    assertEquals("HARD", questionIO.getListOfQuestions().get(1).getDifficulty());
  }
}