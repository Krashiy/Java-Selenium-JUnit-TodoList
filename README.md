# Project Description

In this project I tested the functionality of the site https://todoist.com/, namely checked the login, creating a task, display modes, and writing a comment.

## Modules

  - Selenium
  - ChromeDriver
  - JUnit
  - WebDriverManager
  
## Documentation

  ### core package
    Stores the initialization of tests and the base class for inheritance.
    - BaseSeleniumTest
    - BaseSeleniumPage
    
  ### helpDesk package
    Here are all the classes that describe the pages that were interacted with in the context of this project. 
    There is also a class "HelpDeskTest" with all the tests.
    - MainPage
    - SignInPage
    - TasksPage
    - IncomingTaskPage
    
  ### test
    Here are all the classes that describe tests for specific functionality such as logging in, adding a job, setting up a display, and writing a comment. It also         contains classes with a set of tests and how to run them.
    - CheckPage
    - SignIn
    - AddTask
    - IncomingPageTest
    - TestSuite
    - Test
    
  ### helpers package
    Stores a class with basic data for working with the website. And also an auxiliary class for working with comboboxes.
    - Data
    - ListHelper
