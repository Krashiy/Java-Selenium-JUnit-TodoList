package tests;

import org.junit.Test;
import pages.IncomingTaskPage;

public class IncomingPageTest {
  @Test
  public void test(){
    IncomingTaskPage incomingTaskPage = new IncomingTaskPage();
    incomingTaskPage
            .checkTaskCreated()
            .setDisplay()
            .setComment()
            .setReactionToComment();
  }
}
