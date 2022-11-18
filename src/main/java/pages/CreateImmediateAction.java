package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateImmediateAction extends BaseCreateContentForms{
    private SelenideElement inputNameField = $(By.cssSelector("input[name=\"content.name\"]"));
    private SelenideElement inputDescriptionField = $(By.cssSelector("textarea[name=\"content.description\"]"));
    private SelenideElement addAction = $(By.xpath("//button[contains(.,'Add Action')]"));
    private SelenideElement callOption = $(By.xpath("//a[contains(.,'Call')]"));
    private SelenideElement urlOption = $(By.xpath("//a[contains(.,'URL')]"));
    private SelenideElement phoneField = $(By.cssSelector("input[name=\"content.action.phone\"]"));
    private SelenideElement urlField = $(By.cssSelector("input[name=\"content.action.url\"]"));


    public void fillInfo(String contentName) {
        setDataIntoField(inputNameField, contentName + " " + Utils.getDate());
    }

    public void fillInfo(String contentName, String contentDescription) {
        setDataIntoField(inputNameField, contentName);
        setDataIntoField(inputDescriptionField, contentDescription);
    }

    public void addCallAction(String phoneNumber){
        addAction.click();
        callOption.click();
        phoneField.setValue(phoneNumber);
    }

    public void addUrlAction(String Url){
        addAction.click();
        urlOption.click();
        urlField.setValue(Url);
    }

}
