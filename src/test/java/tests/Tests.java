package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Tests {
  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(TestSuite.class);
    for (Failure failure : result.getFailures()) {
      System.out.println("Trace: " + failure.getTrace());
      System.out.println("Message: " + failure.getMessage());
    }

    System.out.println("Result: " + result.wasSuccessful());
  }
}
