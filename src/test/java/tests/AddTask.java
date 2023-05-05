package tests;

import org.junit.Test;
import pages.TasksPage;

public class AddTask {
  @Test
  public void testC(){
    TasksPage tasksPage = new TasksPage();
    tasksPage.addTask();
  }
}
