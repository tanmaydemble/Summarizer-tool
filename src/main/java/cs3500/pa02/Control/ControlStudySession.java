package cs3500.pa02.Control;

import cs3500.pa02.Model.Question;
import cs3500.pa02.Model.QuestionIO;
import cs3500.pa02.Model.Statistics;
import cs3500.pa02.Model.StudySessionState;
import cs3500.pa02.Model.WriteToFile;
import cs3500.pa02.View.ViewStudySession;
import java.io.File;
import java.util.Objects;
import java.util.Scanner;

/**
 * to direct the flow of the study session
 */
public class ControlStudySession {
  private int targetNumQuestions = 0; //number of questions user wants to practice
  private StudySessionState currentState = null;
  private boolean continueStudy = true;
  private int optionChosen;
  private final Readable input;
  private final Appendable output;
  private final ViewStudySession viewStudySession;
  private Scanner scanner;

  public ControlStudySession(Readable input, Appendable output) {
    this.input = Objects.requireNonNull(input);
    this.output = Objects.requireNonNull(output);
    this.viewStudySession = new ViewStudySession(Objects.requireNonNull(output));
    this.scanner = new Scanner(input);
  }

  /**
   * to start the study session, including welcoming teh user, asking for the file and number of
   * questions and displaying the next question or answer or other functionality till the user
   * wants to keep studying
   */
  public void runStudySession() {
    // welcome user and ask for file path
    viewStudySession.displayWelcomeMessage();
    // read the file and call methods that make the list of questions
    File srFile = new File(readInput());
    currentState = new StudySessionState(srFile);
    // to ask for the number of questions to be practiced
    viewStudySession.requestNumQuestions();
    requestTargetNumQuestions();
    // to display questions and run the study session
    Question currentQuestion = currentState.getQuestion();
    viewStudySession.displayQuestionOrAnswer(currentQuestion.getWhatIsAsked(),
        currentQuestion.getDifficulty(), currentState.getCurrentQuestionNumber());
    while (continueStudy) { // add a clause for target number of questions met
      requestOption();
      nextAction(optionChosen);
    }
  }

  /**
   * to read the user's chosen option and validate it
   */
  private void requestOption() {
    boolean validInput = false;
    while (!validInput) {
      if (scanner.hasNextInt()) {
        optionChosen = scanner.nextInt();
        if (optionChosen > 0 && optionChosen < 7) {
          validInput = true;
        } else {
          viewStudySession.invalidOption();
        }
      } else {
        viewStudySession.invalidOption();
        scanner.next();
      }
    }
  }

  /**
   * to read the file that the user has given
   *
   * @return the file as a string
   */
  private String readInput() {
    StringBuilder output = new StringBuilder();

    if (scanner.hasNextLine()) {
      output.append(scanner.nextLine());
    }
    return output.toString();
  }

  /**
   * to read the target number of questions that the user wants to practice and validate it
   */
  private void requestTargetNumQuestions() {
    int questionBankSize = currentState.getListOfQuestions().size();
    boolean validInput = false;
    while (!validInput) {
      if (scanner.hasNextInt()) {
        targetNumQuestions = scanner.nextInt();
        if (targetNumQuestions > 1 && targetNumQuestions <= questionBankSize) {
          validInput = true;
        } else {
          viewStudySession.invalidNumQuestions(questionBankSize);
        }
      } else {
        viewStudySession.invalidNumQuestions(questionBankSize);
        scanner.next();
      }
    }
  }

  /**
   * to mark a question hard or to inform the user that the initial and target difficulty is the
   * same
   */
  private void markHard() {
    boolean changeSuccess = currentState.getQuestion().changeDifficulty("HARD");
    if (changeSuccess) {
      viewStudySession.confirmEasyToHard();
    } else {
      viewStudySession.difficultyNotChanged();
    }
  }

  /**
   * to mark a question easy or to inform the user that the initial and target difficulty is the
   *    * same
   */
  private void markEasy() {
    boolean changeSuccess = currentState.getQuestion().changeDifficulty("EASY");
    if (changeSuccess) {
      viewStudySession.confirmHardToEasy();
    } else {
      viewStudySession.difficultyNotChanged();
    }
  }

  /**
   * to show the answer to a question
   */
  private void showAnswer() {
    String answer = currentState.getQuestion().getAnswer();
    String difficulty = currentState.getQuestion().getDifficulty();
    viewStudySession.displayQuestionOrAnswer(answer, difficulty,
        currentState.getCurrentQuestionNumber());
  }

  /**
   * to move to the next question
   */
  private void nextQuestion() {
    if (currentState.getCurrentQuestionNumber() < targetNumQuestions) {
      currentState.nextQuestion();
      String question = currentState.getQuestion().getWhatIsAsked();
      String difficulty = currentState.getQuestion().getDifficulty();
      viewStudySession.displayQuestionOrAnswer(question, difficulty,
          currentState.getCurrentQuestionNumber());
    } else {
      nextAction(6);
    }
  }

  /**
   * to move to the previous question
   */
  private void prevQuestion() {
    if (currentState.getCurrentQuestionIdx() > 0) {
      currentState.prevQuestion();
      String question = currentState.getQuestion().getWhatIsAsked();
      String difficulty = currentState.getQuestion().getDifficulty();
      viewStudySession.displayQuestionOrAnswer(question, difficulty,
          currentState.getCurrentQuestionNumber());
    } else {
      viewStudySession.cannotGoBack();
    }
  }

  /**
   * to quit the study session and show the summary statistics
   */
  private void quitStudySession() {
    continueStudy = false;
    int numHardQuestions = Statistics.numHardQuestions(currentState.getListOfQuestions());
    int totalQuestions = currentState.getListOfQuestions().size();
    int easyToHard = Statistics.numEasyToHard(currentState.getListOfQuestions());
    int hardToEasy = Statistics.numHardToEasy(currentState.getListOfQuestions());
    viewStudySession.displayStatistics(numHardQuestions, totalQuestions, hardToEasy, easyToHard,
        currentState.getMaxQuestions());
    QuestionIO questionIO = new QuestionIO();
    questionIO.buildQuestionString(currentState.getListOfQuestions());
    WriteToFile.writeToFile(currentState.getSrFile(), questionIO.getQuestionString());
  }

  /**
   * to call the right method depending on the user input
   * 1 - mark hard
   * 2 - mark easy
   * 3 - show answer
   * 4 - next question
   * 5 - previous question
   * 6 - quit study session
   *
   * @param userInput an integer representing a choice in the menu of options
   */
  public void nextAction(int userInput) {
    if (userInput == 1) {
      markHard();
    } else if (userInput == 2) {
      markEasy();
    } else if (userInput == 3) {
      showAnswer();
    } else if (userInput == 4) {
      nextQuestion();
    } else if (userInput == 5) {
      prevQuestion();
    } else if (userInput == 6) {
      quitStudySession();
    } else {
      throw new IllegalArgumentException("Please choose from options 1-6");
    }
  }
}
