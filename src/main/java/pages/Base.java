package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Base implements SelectSidebarMenu {

    protected String BASE_URL="https://qa-org1.sodyo.com";
    private SelenideElement menu = $(By.cssSelector("div.Sidebar__nav-items-container"));

    private SelenideElement menuItem;

    public ContentManagementPage openContentManagementPage(){
//        menu.shouldBe(Condition.visible);
        Utils.waitFor();
        menuItem = $(By.xpath(SidebarMenuItem.CONTENT_MANAGEMENT.getLocator()));
        menuItem.shouldBe(Condition.visible).click();
        return new ContentManagementPage();
    }
    public CampaignManagementPage openCampaignManagementPage(){
//        menu.shouldBe(Condition.visible);
        Utils.waitFor();
        menuItem = $(By.xpath(SidebarMenuItem.CAMPAIGNS.getLocator()));
        menuItem.shouldBe(Condition.visible).click();
        return new CampaignManagementPage();
    }

    //TODO select project method

    /* Behaviour for basic site elements described below*/

    protected void setDataIntoField(SelenideElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }
}
