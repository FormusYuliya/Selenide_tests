package pages.campaign;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CampaignManagementSecondStep {

    private SelenideElement openSelector = $(By.xpath("(//i[@class='icon-arrow'])[3]"));
    private SelenideElement lastContentOption = $(By.xpath("(//div[contains(@class,'ContentSelectOption')])[1]"));
    private SelenideElement nextButton = $(By.xpath("//button[contains(.,'Next')]"));


    public void fillSecondStep() {
//        attachedContent.setValue(content);
        openSelector.click();
        lastContentOption.click();
    }

    public CampaignManagementThirdStep selectLatestContent(){
        openSelector.click();
        lastContentOption.click();
        nextButton.click();
        return new CampaignManagementThirdStep();
    }


}
