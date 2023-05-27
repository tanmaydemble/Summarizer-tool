package cs3500.pa02.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * to test the sorting of text and index objects
 */
class SortTextAndIndexTest {

  /**
   * to test the sorting
   */
  @Test
  public void testSorting() {
    TextAndIndex one = new TextAndIndex("abc", 1);
    TextAndIndex two = new TextAndIndex("def", 2);

    assertEquals(new SortTextAndIndex().compare(one, two), -1);
  }
}