package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectDashboardPage extends Base {

    private SelenideElement dashboardTitle = $(By.cssSelector("span.Header__org-name"));

    public SelenideElement getPageTitle(){
        return dashboardTitle;
    }
}
