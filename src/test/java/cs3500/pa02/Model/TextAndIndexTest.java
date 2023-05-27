package cs3500.pa02.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * to test the methods in TestAndIndex class
 */
class TextAndIndexTest {
  /**
   * to test the getter methods in TextAndIndex class
   */
  @Test
  public void testGetters() {
    TextAndIndex textAndIndex = new TextAndIndex("abc", 1);
    assertEquals(textAndIndex.getIndex(), 1);
    assertEquals(textAndIndex.getText(), "abc");
  }
}
