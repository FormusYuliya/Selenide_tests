package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateImmediateAction extends BaseCreateContentForms{
    private SelenideElement inputNameField = $(By.cssSelector("input[name=\"content.name\"]"));
    private SelenideElement inputDescriptionField = $(By.cssSelector("textarea[name=\"content.description\"]"));
    private SelenideElement addAction = $(By.xpath("//button[contains(.,'Add Action')]"));
    private SelenideElement callOption = $(By.cssSelector(".icon-call"));
    private SelenideElement urlOption = $(By.cssSelector(".icon-url"));
    private SelenideElement navigationOption = $(By.cssSelector(".icon-navigate"));
    private SelenideElement eventOption = $(By.cssSelector(".icon-event"));
    private SelenideElement contactOption = $(By.cssSelector(".icon-contact"));
    private SelenideElement phoneField = $(By.cssSelector("input[name=\"content.action.phone\"]"));
    private SelenideElement urlField = $(By.cssSelector("input[name=\"content.action.url\"]"));
    private SelenideElement navigationField = $(By.cssSelector(" input[name=\"content.action.address\"]"));
    private SelenideElement firstNameField = $(By.cssSelector(" input[name=\"content.action.firstName\"]"));
    private SelenideElement lastNameField = $(By.cssSelector(" input[name=\"content.action.lastName\"]"));
    private SelenideElement emailField = $(By.cssSelector(" input[name=\"content.action.email\"]"));
    private SelenideElement companyField = $(By.cssSelector(" input[name=\"content.action.company\"]"));
    private SelenideElement eventTitleField = $(By.cssSelector(" input[name=\"content.action.title\"]"));
    private SelenideElement onlineEventCheckbox = $(By.cssSelector("div.CheckboxField:nth-child(2) input"));
    private SelenideElement dataPicker = $(By.cssSelector(".icon-calendar"));
    private SelenideElement nextMonth = $(By.cssSelector("button.DayPickerNavigation_button:nth-child(2) > svg"));
    private SelenideElement middleOfNextMonth = $(By.xpath("(//td[contains(.,'15')])[2]"));
    private SelenideElement eventTimeCheckbox = $(By.cssSelector("div.CheckboxField:nth-child(4)  input"));
    private SelenideElement fromTimeField= $(By.xpath("(//i[@class='icon-clock'])[1]"));
    private SelenideElement toTimeField= $(By.xpath("(//i[@class='icon-clock'])[2]"));
    private SelenideElement selectFromTime= $(By.xpath("(//a[contains(.,'09:00')])[1]"));
    private SelenideElement selectToTime= $(By.xpath("(//a[contains(.,'15:00')])[2]"));



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

    public void addNavigationAction(String address){
        addAction.click();
        navigationOption.click();
        navigationField.setValue(address);
    }

    public void addContactAction(String name, String surname, String phone, String email, String URL, String company){
        addAction.click();
        contactOption.click();
        firstNameField.setValue(name);
        lastNameField.setValue(surname);
        phoneField.setValue(phone);
        emailField.setValue(email);
        urlField.setValue(URL);
        companyField.setValue(company);
    }

    public void addEventAction(String title, String address){
        addAction.click();
        eventOption.click();
        eventTitleField.setValue(title);
        onlineEventCheckbox.click();
        navigationField.setValue(address);
        dataPicker.click();
        nextMonth.click();
        middleOfNextMonth.click();
        setTime();
    }

    protected void setTime(){
        eventTimeCheckbox.click();
        fromTimeField.click();
        $(selectFromTime).scrollIntoView(true);
        selectFromTime.click();
        toTimeField.click();
        $(selectToTime).scrollIntoView(true);
        selectToTime.click();
    }

}
