package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.coupon.SelectColorScheme;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BaseCreateContentForms extends Base implements SelectColorScheme {


    private SelenideElement color;

    protected SelenideElement themeSelector = $(By.xpath("(//div[@class='SelectField__select__value-container SelectField__select__value-container--has-value css-1hwfws3'])[2]"));
    protected SelenideElement themeInput = $(By.xpath("input[name=\"content.theme\"]"));

    private SelenideElement accordionInfo = $(By.cssSelector("div.Accordion__item:first-child"));
    private SelenideElement accordionDesign = $(By.cssSelector("div.Accordion__item:nth-child(2)"));
    private SelenideElement accordionSponsorship = $(By.cssSelector("div.Accordion__item:last-child"));

    private SelenideElement inputNameField = $(By.cssSelector("input[name=\"content.name\"]"));
    private SelenideElement inputDescriptionField = $(By.cssSelector("textarea[name=\"content.description\"]"));

    private SelenideElement saveAndContinueButton = $(By.cssSelector("button.SodyoButton--blue:nth-child(1)"));
//    private SelenideElement saveButton = $(By.cssSelector("button.SodyoButton--dark:nth-child(2)"));
    //  private SelenideElement saveButton = $(By.xpath("(//button[contains(.,'Save')])[3]"));
    private SelenideElement saveButton = $(By.cssSelector("button.SodyoButton--dark:nth-child(2)"));

    private SelenideElement cropButton = $(By.xpath("//button[@type='submit'][contains(.,'Crop')]"));

    protected SelenideElement addCoverImage = $(By.xpath("//*[@name=\"content.cover\"]/following-sibling::input[@type=\"file\"]"));
    protected SelenideElement dropdownSelectTheme = $(By.xpath("(//div[contains(@class,'value-container--has-value css-1hwfws3')])[2]"));
//    protected SelenideElement dropdownSelectTheme = $(By.xpath("//div[@class='SelectField__select__value-container SelectField__select__value-container--has-value css-1hwfws3'][contains(.,'Centered')]"));
    protected SelenideElement selectTheme;

    private SelenideElement addImageInput = $(By.xpath("//*[@name=\"content.cover\"]/following-sibling::input[@type=\"file\"]"));
    private SelenideElement addVideoInput = $(By.cssSelector("div.UploadInput>input[accept='video/mp4,video/quicktime,video/x-ms-wmv,video/x-msvideo,video/x-flv']"));

    private SelenideElement addVideoSelector = $(By.xpath("(//i[@class='icon-video'])[1]"));
    private SelenideElement videoCover = $(By.xpath("//span[contains(.,'UPLOAD')]"));
    private SelenideElement vimeoCover = $(By.cssSelector("i.icon-vimeo"));
    private SelenideElement youtubeCover = $(By.cssSelector("i.icon-youtube"));
    private SelenideElement urlCover = $(By.xpath("//input[@name='content.cover.url']"));

    protected void openAccordionTab(SelenideElement element) {
        $(element).scrollIntoView(true).click();
        element.click();
    }

    public void openInfoAccordion() {
        openAccordionTab(accordionInfo);
    }

    protected void openDesignAccordion() {
        openAccordionTab(accordionDesign);
    }

    public void openSponsorshipAccordion() {
        openAccordionTab(accordionSponsorship);
    }

    public void fillInfo(String contentName) {
        setDataIntoField(inputNameField, contentName + " " + Utils.getDate());
    }

    public void fillInfo(String contentName, String contentDescription) {
        setDataIntoField(inputNameField, contentName);
        setDataIntoField(inputDescriptionField, contentDescription);
    }

    protected void selectColorScheme(colorScheme colorSet) {
        accordionDesign.click();
        color = $(By.xpath(colorSet.getColorLocator()));
        color.click();
    }

    protected void uploadImage(SelenideElement inputField, String pathToFile) {
        inputField.sendKeys(pathToFile);
        cropButton.click();
    }

    public void saveContent() {
        $(saveButton).scrollIntoView(true);
        Utils.waitFor(3000);
        //TODO think about adding cycle that will close modal window instead of timeout
        saveButton.click();
    }

    protected void saveAndContinue() {
        $(saveAndContinueButton).scrollIntoView(true);
        saveAndContinueButton.click();
    }

    //TODO Initial form
    //TODO Sponsorship


    public void setDesign(SelectRaffleTheme.theme theme, colorScheme colorSet, String pathToImage) {
        selectColorScheme(colorSet);
        uploadImage(addCoverImage, pathToImage);
        dropdownSelectTheme.click();
        selectTheme = $(By.xpath(theme.getLocator()));
        selectTheme.click();
    }


    protected void addCover(String coverType, String pathToCover) {
        switch (coverType){
            case "IMAGE":
                uploadImage(addImageInput, pathToCover);
                break;
            case "UPLOAD_VIDEO":
                addVideoSelector.click();
                videoCover.click();
                executeJavaScript("document.getElementsByClassName(\"UploadInput__input\")[0].classList.remove(\"UploadInput__input\")");
                addVideoInput.uploadFile(new File(pathToCover));
                break;
            case "VIMEO_VIDEO":
                addVideoSelector.click();
                vimeoCover.click();
                urlCover.setValue(pathToCover);
                break;
            case "YOUTUBE_VIDEO":
                addVideoSelector.click();
                youtubeCover.click();
                urlCover.setValue(pathToCover);
                break;
        }
    }
}
