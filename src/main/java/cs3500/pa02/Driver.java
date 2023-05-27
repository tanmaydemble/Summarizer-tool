package cs3500.pa02;

import cs3500.pa02.Control.ControlStudySession;
import cs3500.pa02.Control.CreateSummary;
import cs3500.pa02.Model.SortFiles;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Path;

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
    if (args.length == 3) {
      // to read the command line inputs
      Path filePath = Path.of(args[0]);
      SortFiles.OrderingFlag orderingFlag = SortFiles.OrderingFlag.valueOf(args[1].toUpperCase());
      Path outputPath = Path.of(args[2]);

      CreateSummary summary = new CreateSummary();
      summary.createSummary(filePath, orderingFlag, outputPath);
    } else if (args.length == 0) {
      ControlStudySession studySession = new ControlStudySession(new InputStreamReader(System.in),
          new PrintStream(System.out));
      studySession.runStudySession();
    }
  }
}