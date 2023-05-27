package cs3500.pa02.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * to test the methods in the study state session class
 */
class StudySessionStateTest {
  File srFile;
  StudySessionState state;
  /**
   * to initialize the list of questions before we run the tests
   */
  @BeforeEach
  public void setup() {
    srFile = new File("testFileOutput/testReadSrFile.sr");
    state = new StudySessionState(srFile);

    assertEquals(state.getSrFile(), srFile);
    assertEquals(state.getMaxQuestions(), 1);
    assertEquals(state.getCurrentQuestionIdx(), 0);
  }

  /**
   * to test traversing the list of questions
   */
  @Test
  public void testNextAndPrevQuestion() {
    state.nextQuestion();
    assertEquals(state.getCurrentQuestionIdx(), 1);
    assertEquals(state.getMaxQuestions(), 2);
    state.prevQuestion();
    assertEquals(state.getCurrentQuestionNumber(),1);
  }
}