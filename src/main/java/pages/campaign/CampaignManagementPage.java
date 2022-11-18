package pages.campaign;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.SelectSidebarMenu;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;



public class CampaignManagementPage implements SelectSidebarMenu {
    private SelenideElement addNewCampaignButton = $(By.xpath("//a[contains(.,'Add new campaign')]"));
    private SelenideElement campaignName = $(By.xpath("//input[@name='name']"));
    private SelenideElement nextButton = $(By.xpath("//button[contains(.,'Next')]"));
    private SelenideElement firstCampaignTitle = $(By.cssSelector("div.CampaignRow:nth-child(1) div>a:first-child"));

    public void createCampaign() {
        addNewCampaignButton.click();
    }

    public CampaignManagementSecondStep fillFirstStep( String name){
        campaignName.setValue(name);
        nextButton.click();
        return new CampaignManagementSecondStep ();
    }

    @Step("Verify that content added into the 'Content management' table")
    public void verifyCampaignCreation(String title) {
        $(firstCampaignTitle).shouldBe(text(title));
    }

}
