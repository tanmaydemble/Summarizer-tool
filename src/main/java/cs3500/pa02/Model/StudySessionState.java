package cs3500.pa02.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * to represent the state of the study session
 */
public class StudySessionState {
  private ArrayList<Question> listOfQuestions = new ArrayList<Question>();
  private int maxQuestions; // total questions the user viewed in this study session
  private int currentQuestionIdx;
  private File srFile = null;

  /**
   * to initialize the study session to its initial state
   *
   * @param srFile the file from which we read the questions
   */
  public StudySessionState(File srFile) {
    this.maxQuestions = 1;
    this.currentQuestionIdx = 0;
    this.srFile = srFile;
    initializeListOfQuestions();
  }

  /**
   * to return the srFile for this study session
   *
   * @return the srFile as a File object
   */
  public File getSrFile() {
    return srFile;
  }

  /**
   * the list of questions in the question bank
   *
   * @return an array list of question objects
   */
  public ArrayList<Question> getListOfQuestions() {
    return listOfQuestions;
  }

  /**
   * to get the index in the list of questions of the question we are at
   *
   * @return index of the question we are at
   */
  public int getCurrentQuestionIdx() {
    return currentQuestionIdx;
  }

  /**
   * to get the number of questions the user has gone through in this session
   *
   * @return number of questions the user has gone through in this session
   */
  public int getMaxQuestions() {
    return maxQuestions;
  }

  /**
   * to get the current question the user is studying
   *
   * @return a question object
   */
  public Question getQuestion() {
    return listOfQuestions.get(currentQuestionIdx);
  }

  /**
   * to get the Question number of the question the user is studying
   *
   * @return an integer question number
   */
  public int getCurrentQuestionNumber() {
    return currentQuestionIdx + 1; // question index starts at 0, question number starts at 1
  }

  /**
   * to read the questions in the srFile and store them in a list. Then we shuffle the list and
   * sort it according to difficulty (hard to easy)
   */
  public void initializeListOfQuestions() {
    String fileContent = FileReader.readFromFile(srFile);
    QuestionIO questionIO = new QuestionIO();
    questionIO.buildQuestionList(fileContent);
    listOfQuestions = questionIO.getListOfQuestions();
    Collections.shuffle(listOfQuestions);
    Collections.sort(listOfQuestions); // sort according to first hard then easy
  }

  /**
   * to update the question index when the user wants to go to the next question and to update
   * the maximum questions that the user has studied
   */
  public void nextQuestion() {
    currentQuestionIdx++;
     maxQuestions = Statistics.totalQuestionsStudied(maxQuestions, this.getCurrentQuestionNumber());
  }

  /**
   * to go to the previous question index when the user wants to go to the previous question
   */
  public void prevQuestion() {
    currentQuestionIdx--;
  }
}
