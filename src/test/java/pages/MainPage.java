package pages;

import core.BaseSeleniumPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {
  @FindBy(xpath = "//h1[contains(text(), 'Организуйте')]")
  private WebElement pageTitle;
  @FindBy(xpath = "//li[@class='nOFNc0QpGW0HpMqVOfJb']//a[@href='/auth/login']")
  private WebElement authLink;

  public MainPage(){
    driver.get("https://todoist.com/ru");
    PageFactory.initElements(driver, this);
  }

  public void checkPage(){
    Assert.assertEquals(pageTitle.getText(), "Организуйте\n" +
            "работу и жизнь.");
  }
  public SignInPage goToSignIn(){
    authLink.click();

    return new SignInPage();
  }
}
