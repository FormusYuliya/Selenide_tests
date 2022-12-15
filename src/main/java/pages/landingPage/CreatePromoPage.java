package pages.landingPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BaseCreateContentForms;
import pages.Utils;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class CreatePromoPage extends BaseCreateContentForms {

    private SelenideElement accordionPromo = $(By.cssSelector("div.Accordion__item:nth-child(3)"));
    private SelenideElement inputPromoTitleField = $(By.xpath("//input[@name='content.title']"));
    private SelenideElement inputPromoTextarea = $(By.xpath("//textarea[@name='content.promoText']"));
    private SelenideElement addImageInput = $(By.xpath("//*[@name=\"content.cover\"]/following-sibling::input[@type=\"file\"]"));
    private SelenideElement addVideoInput = $(By.cssSelector("div.UploadInput>input[accept='video/mp4,video/quicktime,video/x-ms-wmv,video/x-msvideo,video/x-flv']"));

    private SelenideElement addVideoSelector = $(By.xpath("(//i[@class='icon-video'])[1]"));
    private SelenideElement uploadVideoField = $(By.xpath("//span[contains(.,'Add video')]"));
    private SelenideElement videoCover = $(By.xpath("//span[contains(.,'UPLOAD')]"));
    private SelenideElement vimeoCover = $(By.cssSelector("i.icon-vimeo"));
    private SelenideElement youtubeCover = $(By.cssSelector("i.icon-youtube"));

    String pathToCover2 = "D:\\Test Content\\videoplayback.mp4";

    public void fillPromo(String title , String promo, String pathToCover){
        $(accordionPromo).scrollIntoView(true).click();
        openPromoAccordion();
        inputPromoTitleField.setValue(title);
        inputPromoTextarea.setValue(promo);
        uploadImage(addImageInput, pathToCover);
    }

    public void fillPromoWithVideo(String title , String promo, String pathToCover){
        $(accordionPromo).scrollIntoView(true).click();
        openPromoAccordion();
        inputPromoTitleField.setValue(title);
        inputPromoTextarea.setValue(promo);
        uploadVideo(pathToCover2);
        //TODO add icon select
    }

    protected void uploadVideo(String path){
        addVideoSelector.click();
        videoCover.click();
//        addImageInput.setValue(pathToCover2);
//        addVideoInput.uploadFile(pathToCover2);

        executeJavaScript("document.getElementsByClassName(\"UploadInput__input\")[0].classList.remove(\"UploadInput__input\")");
        addVideoInput.uploadFile(new File(pathToCover2));

    }

    public void openPromoAccordion() {
        openAccordionTab(accordionPromo);
    }
}
