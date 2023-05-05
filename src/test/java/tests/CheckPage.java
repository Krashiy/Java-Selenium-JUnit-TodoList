package tests;

import org.junit.Test;
import pages.MainPage;

public class CheckPage {
  @Test
  public void test(){
    MainPage mainPage = new MainPage();
    mainPage.checkPage();
  }
}
