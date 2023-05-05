package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage extends BaseSeleniumPage {

  @FindBy(xpath = "//input[@type='email']")
  private WebElement emailField;
  @FindBy(xpath = "//input[@type='password']")
  private WebElement passwordField;
  @FindBy(xpath = "//button[@type='submit']")
  private WebElement signInButton;
  public SignInPage(){
    driver.get("https://todoist.com/auth/login");
    PageFactory.initElements(driver, this);
  }

  public TasksPage signIn(String email, String password){
    emailField.sendKeys(email);
    passwordField.sendKeys(password);
    signInButton.click();
    new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.urlContains("app"));
    return new TasksPage();
  }
}
