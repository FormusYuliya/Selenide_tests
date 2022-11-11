package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CampaignManagementThirdStep {

    private SelenideElement nextButton = $(By.xpath("//button[contains(.,'Next')]"));

    public CampaignManagementFourthStep nextStep(){

        nextButton.click();
        return new CampaignManagementFourthStep();
    }
}
