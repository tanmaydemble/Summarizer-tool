package cs3500.pa02.View;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class MockViewStudySessionTest {
  MockViewStudySession viewStudySession;

  /**
   * to test the IOException thrown by different methods in this class
   */
  @Test
  public void testFailure() {
    viewStudySession = new MockViewStudySession();
    assertThrows(IOException.class, () -> viewStudySession.displayWelcomeMessage(),
        "Mock throwing an error");
    assertThrows(IOException.class, () -> viewStudySession.requestNumQuestions(),
        "Mock throwing an error");
    assertThrows(IOException.class, () ->
            viewStudySession.displayQuestionOrAnswer("Question1", "HARD",
                1),
        "Mock throwing an error");
    assertThrows(IOException.class, () -> viewStudySession.displayStatistics(1,
            2, 3, 4, 5),
        "Mock throwing an error");
    assertThrows(IOException.class, () -> viewStudySession.confirmEasyToHard(),
        "Mock throwing an error");
    assertThrows(IOException.class, () -> viewStudySession.confirmHardToEasy(),
        "Mock throwing an error");
    assertThrows(IOException.class, () -> viewStudySession.difficultyNotChanged(),
        "Mock throwing an error");
    assertThrows(IOException.class, () -> viewStudySession.cannotGoBack(),
        "Mock throwing an error");
    assertThrows(IOException.class, () -> viewStudySession.invalidOption(),
        "Mock throwing an error");
    assertThrows(IOException.class, () -> viewStudySession.invalidNumQuestions(5),
        "Mock throwing an error");

  }
}