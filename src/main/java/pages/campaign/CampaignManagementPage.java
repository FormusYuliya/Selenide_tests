package pages.campaign;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.SelectSidebarMenu;

import static com.codeborne.selenide.Selenide.$;



public class CampaignManagementPage implements SelectSidebarMenu {
    private SelenideElement addNewCampaignButton = $(By.xpath("//a[contains(.,'Add new campaign')]"));
    private SelenideElement campaignName = $(By.xpath("//input[@name='name']"));
    private SelenideElement nextButton = $(By.xpath("//button[contains(.,'Next')]"));


    public void createCampaign() {
        addNewCampaignButton.click();
    }

    public CampaignManagementSecondStep fillFirstStep( String name){
        campaignName.setValue(name);
        nextButton.click();
        return new CampaignManagementSecondStep ();
    }

}
