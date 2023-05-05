package tests;

import core.BaseSeleniumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  CheckPage.class,
        SignIn.class,
        AddTask.class,
        IncomingPageTest.class
})
public class TestSuite extends BaseSeleniumTest {

}
