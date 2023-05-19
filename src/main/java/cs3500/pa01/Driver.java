package cs3500.pa01;

import static cs3500.pa01.FileReader.readFromFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Project entry point
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) throws IOException {
    // to read the command line inputs
    Path filePath = Path.of(args[0]);
    SortFiles.OrderingFlag orderingFlag = SortFiles.OrderingFlag.valueOf(args[1].toUpperCase());
    Path outputPath = Path.of(args[2]);

    // to walk the file system and select regular .md files
    FileSystemWalker fsw = new FileSystemWalker();
    Files.walkFileTree(filePath, fsw);
    ArrayList<MdFile> selectedFiles = fsw.getSelectedFiles();

    // to sort the .md files depending on the orderingFlag
    SortFiles.sortFiles(selectedFiles, orderingFlag);

    // to read the files and put each new line in a string in the selected content array
    ArrayList<String> selectedContent = new ArrayList<String>();
    for (MdFile f : selectedFiles) {
      selectedContent.addAll(FileReader.readFromFile(f.getFile()));
    }

    // to select the headings and highlighted content out of the strings in the array list
    Summarize summarize = new Summarize();
    for (String s : selectedContent) {
      summarize.summarize(s);
    }

    // to create a single string out of the summarized content
    StringBuilder sb = new StringBuilder();
    ArrayList<String> highlightedContent = summarize.getSummarizedContent();
    for (int s = 1; s < highlightedContent.size(); s++) {
      sb.append(highlightedContent.get(s)).append("\n");
    }

    // to write the string we made to the output file
    WriteToFile.writeToFile(outputPath.toFile(), sb.toString());
  }
}