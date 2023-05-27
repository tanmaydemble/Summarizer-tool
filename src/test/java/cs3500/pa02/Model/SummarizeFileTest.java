package cs3500.pa02.Model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa02.Model.SummarizeFile;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * to test the methods in Summarize class
 */
public class SummarizeFileTest {
  /**
   * to test summarizing a given string
   */
  @Test
  public void testSummarizeFile() {
    SummarizeFile summarize = new SummarizeFile();
    summarize.summarize("""

        #Arrays
        [[the quick
        brown fox]]
        ##Arrays
        [[bring me some sun]]
        [[what is love?:::baby don't hurt me]]
        - bring me some sunshine
        [[tell me the alphabet
        :::a b c]]""");
    assertEquals(new ArrayList<>(Arrays.asList("\n#Arrays\n", "\n##Arrays\n",
            "- the quick\nbrown fox\n", "- bring me some sun\n")),
        summarize.getSummarizedTextOnly());
    assertEquals("what is love?", summarize.getQuestions().get(0).getWhatIsAsked());
    assertEquals("baby don't hurt me", summarize.getQuestions().get(0).getAnswer());
    assertEquals("HARD", summarize.getQuestions().get(0).getDifficulty());

    assertEquals("tell me the alphabet\n", summarize.getQuestions().get(1).getWhatIsAsked());
    assertEquals("a b c", summarize.getQuestions().get(1).getAnswer());
    assertEquals("HARD", summarize.getQuestions().get(1).getDifficulty());
  }
}