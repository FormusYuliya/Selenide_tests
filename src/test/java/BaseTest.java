    import com.codeborne.selenide.Configuration;
    import com.codeborne.selenide.Selenide;
    import org.junit.After;
    import org.junit.Before;

public class BaseTest {

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
//        Selenide.closeWindow() - closes a current window (or tab, which is the same)
    }
}
