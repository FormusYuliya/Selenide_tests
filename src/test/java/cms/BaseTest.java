package cms;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
//        Selenide.closeWindow() - closes a current window (or tab, which is the same)
    }
}
