package tests;

import helpers.Data;
import org.junit.Test;
import pages.MainPage;

public class SignIn {
  @Test
  public void test(){
    MainPage mainPage = new MainPage();
    mainPage.goToSignIn()
            .signIn(Data.login, Data.password)
            .checkPage();
  }
}
