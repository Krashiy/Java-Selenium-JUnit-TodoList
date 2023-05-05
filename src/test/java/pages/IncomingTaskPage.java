package pages;

import core.BaseSeleniumPage;
import helpers.Data;
import helpers.ListHelper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IncomingTaskPage extends BaseSeleniumPage {
  @FindBy(xpath = "//body")
  private WebElement body;
  @FindBy(xpath = "//div[contains(@class, 'task_content')]")
  private WebElement taskTitle;
  @FindBy(xpath = "//div[contains(@class,'task_description')]")
  private WebElement taskDescription;
  @FindBy(xpath = "//span[@class='date date_future']")
  private WebElement taskTime;
  @FindBy(xpath = "//div[@class='ProseMirror']")
  private WebElement commentField;
  @FindBy(xpath = "//div[@class='+syWHcL _0J7x-Vo _2a3b75a1']/following-sibling::div//div[@class='ProseMirror'][1]")
  private WebElement editCommentField;
  @FindBy(xpath = "//button[@class='_9Wfxfoc5gMsPy1iegKm8fw==']")
  private WebElement displayedButton;
  @FindBy(xpath = "//span[@aria-labelledby='view_menu__view_as']")
  private WebElement layoutButton;
  @FindBy(xpath = "//li[@aria-labelledby='view_menu__group_by']")
  private WebElement groupingButton;
  @FindBy(xpath = "//li[@aria-labelledby='view_menu__sort_by']")
  private WebElement sortingButton;
  @FindBy(xpath = "//button[@class='_8313bd46 _907a61ca ccb3eb8c _5e45d59f _2a3b75a1 _8c75067a']")
  private WebElement resetAllButton;
  @FindBy(xpath = "//a[@href='/app/project/2312099665/comments']")
  private WebElement commentsLink;
  @FindBy(xpath = "//button[@id='activity']")
  private WebElement activityButton;
  @FindBy(xpath = "//button[@id='comments']")
  private WebElement commentsButton;
  @FindBy(xpath = "//button[@aria-label='Опции комментария']")
  private WebElement commentOptionButton;
  @FindBy(xpath = "//button[@role='menuitem'][1]")
  private WebElement editCommentButton;
  @FindBy(xpath = "//button[@class='project_detail_close']")
  private WebElement closeComments;
  @FindBy(xpath = "//div[@class='+syWHcL _0J7x-Vo _2a3b75a1']/following-sibling::div//button[@type='submit']")
  private WebElement submitEditCommentButton;
  @FindBy(xpath = "//button[@type='submit']")
  private WebElement submitCommentButton;
  @FindBy(xpath = "//button[@class='_8313bd46 f169a390 _5e45d59f _8644eccb _2a3b75a1']")
  private WebElement reactComment;
  @FindBy(xpath = "//a[@data-track='project|comments']/span[@class='action_label']")
  private WebElement commentsCounter;
  @FindBy(xpath = "//div[@class='note_content']/p")
  private WebElement commentText;
  @FindBy(xpath = "//div[@title='белая галочка']")
  private WebElement react;
  @FindBy(xpath = "//button[@class='reaction_holder']")
  private WebElement unReact;
  @FindBy(xpath = "//button[@class='_8313bd46 f169a390 _5e45d59f _8644eccb _2a3b75a1'][3]")
  private WebElement emojiPicker;
  @FindBy(xpath = "//li[@class='emoji_picker__emoji'][2]")
  private WebElement pickEmoji;
  @FindBy(xpath = "//ul[@role='listbox']/li")
  private List<WebElement> layoutOptions;
  @FindBy(xpath = "//ul[@role='listbox']/li")
  private List<WebElement> groupingOptions;
  @FindBy(xpath = "//ul[@role='listbox']/li")
  private List<WebElement> sortingOptions;
  public  IncomingTaskPage(){
    driver.get("https://todoist.com/app/project/2312099665");
    PageFactory.initElements(driver, this);
  }
  public IncomingTaskPage checkTaskCreated(){
    Assert.assertEquals(taskTitle.getText(), Data.taskTitle);
    Assert.assertEquals(taskDescription.getText(), Data.taskDescription);
    Assert.assertEquals(taskTime.getText(), Data.taskTime);
    return this;
  }
  public IncomingTaskPage setDisplay(){
    displayedButton.click();
    setLayout();
    setGrouping();
    setSorting();
    resetAllButton.click();
    body.click();
    return this;
  }

  public IncomingTaskPage setComment(){
    commentsLink.click();
    activityButton.click();
    commentsButton.click();
    setCommentData(Data.commentText);
    submitCommentButton.click();
    Assert.assertTrue(commentText.getText().contains(Data.commentText));
    return this;
  }

  public void setReactionToComment(){
    reactComment.click();
    react.click();
    unReact.click();
    closeComments.click();
    Assert.assertTrue(commentsCounter.isDisplayed());
  }

  private void setLayout(){
    layoutButton.click();
    ListHelper.dropDownListHelper(layoutOptions.size(), 0, layoutOptions, layoutButton);
  }
  private void setGrouping(){
    groupingButton.click();
    ListHelper.dropDownListHelper(groupingOptions.size(), 0, groupingOptions, groupingButton);
  }
  private void setSorting(){
    sortingButton.click();
    ListHelper.dropDownListHelper(sortingOptions.size(), 0, sortingOptions, sortingButton);
  }
  private void setCommentData(String text){
    commentField.sendKeys(text);
    emojiPicker.click();
    pickEmoji.click();
  }
}
