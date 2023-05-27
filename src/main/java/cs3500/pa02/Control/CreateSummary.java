package cs3500.pa02.Control;

import cs3500.pa02.Model.FileReader;
import cs3500.pa02.Model.FileSystemWalker;
import cs3500.pa02.Model.MdFile;
import cs3500.pa02.Model.Question;
import cs3500.pa02.Model.QuestionIO;
import cs3500.pa02.Model.SortFiles;
import cs3500.pa02.Model.SummarizeFile;
import cs3500.pa02.Model.WriteToFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class CreateSummary {

  public void createSummary(Path filePath, SortFiles.OrderingFlag orderingFlag, Path outputPath)
      throws IOException {
    // to walk the file system and select regular .md files
    FileSystemWalker fsw = new FileSystemWalker();
    Files.walkFileTree(filePath, fsw);
    ArrayList<MdFile> selectedFiles = fsw.getSelectedFiles();

    // to sort the .md files depending on the orderingFlag
    SortFiles.sortFiles(selectedFiles, orderingFlag);

    // to read the files and put each new line in a string in the selected content array
    ArrayList<String> selectedContent = new ArrayList<String>();
    for (MdFile f : selectedFiles) {
      selectedContent.add(FileReader.readFromFile(f.getFile()));
    }

    // to select the headings and highlighted content out of the strings in the array list
    SummarizeFile summarize = new SummarizeFile();
    ArrayList<String> highlightedContent = new ArrayList<String>();
    ArrayList<Question> listOfQuestions = new ArrayList<Question>();
    for (String s : selectedContent) {
      summarize.summarize(s);
      summarize.sortSummarizedContent();
      highlightedContent.addAll(summarize.getSummarizedTextOnly());
      listOfQuestions.addAll(summarize.getQuestions());
      summarize.clearSummarized();
    }

    // to create a single string out of the summarized content
    StringBuilder sb = new StringBuilder();
    for (int s = 0; s < highlightedContent.size(); s++) {
      sb.append(highlightedContent.get(s));
    }

    // to remove the new line before the first heading in the document
    sb.deleteCharAt(0);

    // to create a single string out of all the questions accumulated
    QuestionIO questionString = new QuestionIO();
    questionString.buildQuestionString(listOfQuestions);

    // to write the summary to the .md file and the questions in a .sr file
    WriteToFile.writeToFile(outputPath.toFile(), sb.toString());
    File srFile = new File(outputPath.getParent().toString() + "/Questions.sr/");
    WriteToFile.writeToFile(srFile, questionString.getQuestionString());
  }
}
