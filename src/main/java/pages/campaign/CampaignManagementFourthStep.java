package pages.campaign;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CampaignManagementFourthStep {
    private SelenideElement submitButton = $(By.xpath("//button[contains(.,'Submit')]"));

    public void submitCampaignCreation(){
        submitButton.click();;
    }
}
