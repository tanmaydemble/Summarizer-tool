package cs3500.pa02.Model;

import java.util.ArrayList;

/**
 * to convert a list of questions into a single string in the particular format where question and
 * answers are separated by ::: and two different questions are separated by the difficulty
 * and to convert the questions written in the file in the above-mentioned format back to a list
 * of questions
 */
public class QuestionIO {
  private String questionString;
  private ArrayList<Question> listOfQuestions = new ArrayList<Question>();

  /**
   * to access the question string
   *
   * @return the question string
   */
  public String getQuestionString() {
    return questionString;
  }

  /**
   * to access the list of questions
   *
   * @return list of questions
   */
  public ArrayList<Question> getListOfQuestions() {
    return listOfQuestions;
  }

  /**
   * to build the question string from a list of questions
   *
   * @param questions list of questions
   */
  public void buildQuestionString(ArrayList<Question> questions) {
    StringBuilder sb = new StringBuilder();
    for (Question q : questions) {
      sb.append(q.getWhatIsAsked()).append("\n:::\n").append(q.getAnswer()).
          append("\n").append(q.getDifficulty()).append("\n");
    }
    questionString = sb.toString();
  }

  /**
   * to convert a question string into a list of questions
   *
   * @param questionString the string containing questions
   */
  public void buildQuestionList(String questionString) {
    int index = 0;
    while (questionString.contains("\nHARD\n")
        || questionString.contains("\nEASY\n")) {
      index = questionString.indexOf("\n:::\n");
      String question = questionString.substring(0, index);
      questionString = questionString.substring(index + 5); // 5 is length of \n:::\n

      Question.difficulty difficulty = Question.difficulty.HARD;
      if (!questionString.contains("\nEASY\n") && questionString.contains("\nHARD\n")) {
        index = questionString.indexOf("\nHARD\n");
      } else if (questionString.contains("\nEASY\n") && !questionString.contains("\nHARD\n")) {
        index = questionString.indexOf("\nEASY\n");
        difficulty = Question.difficulty.EASY;
      } else if (questionString.indexOf("\nHARD\n") < questionString.indexOf("\nEASY\n")) {
        index = questionString.indexOf("\nHARD\n");
      } else {
        index = questionString.indexOf("\nEASY\n");
        difficulty = Question.difficulty.EASY;
      }

      String answer = questionString.substring(0, index);
      questionString = questionString.substring(index + 6); // 6 is length of \nHARD\n
      listOfQuestions.add(new Question(question, answer, difficulty));
    }
  }
}
