package pages;

import core.BaseSeleniumPage;
import helpers.Data;
import helpers.ListHelper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TasksPage extends BaseSeleniumPage {
  @FindBy(xpath = "//button[@class='reactist_menubutton top_bar_btn settings_btn']")
  private WebElement buttonMenu;
  @FindBy(xpath = "//div[@class='avatar_container']")
  private WebElement avatarContainer;
  @FindBy(xpath = "//span[@class='icon_add']")
  private  WebElement openTaskCreatorButton;
  @FindBy(xpath = "//p[@data-placeholder='Название задачи']/parent::div")
  private WebElement taskTitleField;
  @FindBy(xpath = "//p[@data-placeholder='Описание']/parent::div")
  private WebElement taskDescriptionField;
  @FindBy(xpath = "//div[@aria-label='Установка срока выполнения']")
  private WebElement openCalendarButton;
  @FindBy(xpath = "//button[@data-track='scheduler|date_shortcut_today']")
  private WebElement todayButton;
  @FindBy(xpath = "//button[@data-track='scheduler|date_shortcut_tomorrow']")
  private WebElement tomorrowButton;
  @FindBy(xpath = "//button[@data-track='scheduler|date_shortcut_nextweek']")
  private WebElement nextWeekendButton;
  @FindBy(xpath = "//button[@data-track='scheduler|date_shortcut_nextweek']")
  private WebElement nextWeekButton;
  @FindBy(xpath = "//button[@aria-label='Перейти к следующему месяцу']")
  private WebElement nextMonthButton;
  @FindBy(xpath = "//button[@aria-label='Перейти к предыдущему месяцу']")
  private WebElement prevMonthButton;
  @FindBy(xpath = "//button[@aria-label='Перейти к текущему месяцу']")
  private WebElement currentMonthButton;
  @FindBy(xpath = "//button[@aria-label='2023-05-21']")
  private WebElement randomDateButton;
  @FindBy(xpath = "//button[@class='scheduler-actions-addtime']")
  private WebElement addTimeButton;
  @FindBy(xpath = "//input[@id='scheduler-timepicker-input-element']")
  private WebElement timeField;
  @FindBy(xpath = "//button[@class='scheduler-timezone-label']")
  private WebElement choseTimeZoneButton;
  @FindBy(xpath = "//button[@class='scheduler-timezone-item']")
  private WebElement choseYourTimeZoneButton;
  @FindBy(xpath = "//button[@aria-label='Убрать срок выполнения']")
  private WebElement cancelChosenDate;
  @FindBy(xpath = "//button[@class=\"scheduler-timepicker-actions-add\"]")
  private WebElement saveTimeZoneButton;
  @FindBy(xpath = "//button[text()='Отмена']")
  private WebElement cancelTimeContextButton;
  @FindBy(xpath = "//button[text()='Сохранить']")
  private WebElement saveTimeButton;
  @FindBy(xpath = "//div[@aria-label='Установить приоритет']")
  private WebElement chosePriorityButton;
  @FindBy(xpath = "//ul[@aria-label='Выбрать приоритет']/li")
  private List<WebElement> priorityList;
  @FindBy(xpath = "//button[@aria-label='Отмена']")
  private WebElement cancelTaskCreatorButton;
  @FindBy(xpath = "//button[@data-testid='task-editor-submit-button']")
  private WebElement saveTaskButton;
  @FindBy(xpath = "//div[@class='a83bd4e0 _2a3b75a1']/a")
  private WebElement incomingTaskLink;
  @FindBy(xpath = "//div[@role='alert']")
  private WebElement taskCreatedAlert;

  public TasksPage(){
    driver.get("https://todoist.com/app");
    PageFactory.initElements(driver, this);
  }

  public void checkPage(){
    buttonMenu.click();
    Assert.assertTrue(avatarContainer.isDisplayed());
  }

  public void addTask(){
    openTaskCreatorButton.click();
    cancelTaskCreatorButton.click();

    openTaskCreatorButton.click();
    fillTaskDetails(Data.taskTitle, Data.taskDescription);

    setTomorrow();

    setNextWeekend();

    setNextWeek();

    openCalendarButton.click();
    navigateToMonth();
    addTimeButton.click();
    cancelTimeContextButton.click();

    setTime();

    setPriority();
    saveTaskButton.click();
    checkTaskCreated();
    incomingTaskLink.click();
    try{
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
      wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }
    catch (Exception e){
    }

  }
  private void setTomorrow(){
    openCalendarButton.click();
    tomorrowButton.click();
    cancelChosenDate.click();
  }
  private void setNextWeekend(){
    openCalendarButton.click();
    nextWeekendButton.click();
    cancelChosenDate.click();
  }
  private void setNextWeek(){
    openCalendarButton.click();
    nextWeekButton.click();
    cancelChosenDate.click();
  }
  private void fillTaskDetails(String taskTitle, String taskDescription) {
    taskTitleField.sendKeys(taskTitle);
    taskDescriptionField.sendKeys(taskDescription);
  }
  private void navigateToMonth(){
    nextMonthButton.click();
    nextMonthButton.click();
    prevMonthButton.click();
    currentMonthButton.click();
  }
  private void setTime(){
    addTimeButton.click();
    timeField.sendKeys(Data.taskTime);
    choseTimeZoneButton.click();
    choseYourTimeZoneButton.click();
    saveTimeZoneButton.click();
    randomDateButton.click();
    saveTimeButton.click();
  }
  private void setPriority(){
    chosePriorityButton.click();
    ListHelper.dropDownListHelper(priorityList.size(), 0, priorityList, chosePriorityButton);
  }
  private void checkTaskCreated(){
    Assert.assertTrue(taskCreatedAlert.isDisplayed());
  }
}


