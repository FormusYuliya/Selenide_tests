package pages.landingPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BaseCreateContentForms;

import static com.codeborne.selenide.Selenide.$;

public class CreatePromoPage extends BaseCreateContentForms {

    private SelenideElement accordionPromo = $(By.cssSelector("div.Accordion__item:nth-child(3)"));
    private SelenideElement accordionInfoBlock = $(By.cssSelector(".ContentInfoConfig"));
    private SelenideElement accordionInfoTitle = $(By.cssSelector("div.Accordion__item:nth-child(1)>div.Accordion__item-header>div"));
    private SelenideElement inputPromoTitleField = $(By.xpath("//input[@name='content.title']"));
    private SelenideElement inputPromoTextarea = $(By.xpath("//textarea[@name='content.promoText']"));
    private SelenideElement addImageInput = $(By.xpath("//*[@name=\"content.cover\"]/following-sibling::input[@type=\"file\"]"));

    public void fillPromo(String title , String promo, String pathToCover){
        $(accordionPromo).scrollIntoView(true).click();
        openPromoAccordion();
        inputPromoTitleField.setValue(title);
        inputPromoTextarea.setValue(promo);
        uploadImage(addImageInput, pathToCover);

        //TODO add icon select
    }

    public void openPromoAccordion() {
        openAccordionTab(accordionPromo);
    }
}
