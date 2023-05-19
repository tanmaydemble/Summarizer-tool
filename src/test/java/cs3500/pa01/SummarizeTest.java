package cs3500.pa01;



import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa01.FileSystemWalker;
import cs3500.pa01.Summarize;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * to test the methods in Summarize class
 */
public class SummarizeTest {
  /**
   * to test summarizing a given string
   */
  @Test
  public void testSummarizeTest() {
    Summarize summarize = new Summarize();
    summarize.summarize("#Arrays");
    assertEquals(new ArrayList<String>(Arrays.asList("", "#Arrays")),
        summarize.getSummarizedContent());
    summarize.summarize("[[this is imp]] this is not [[this is imp **too**]]");
    assertEquals(new ArrayList<String>(
            Arrays.asList("", "#Arrays", "- this is imp", "- this is imp **too**")),
        summarize.getSummarizedContent());
  }
}