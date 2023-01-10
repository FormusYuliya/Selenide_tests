package pages.landingPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BaseCreateContentForms;
import pages.Utils;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.sun.javafx.cursor.CursorType.IMAGE;

public class CreatePromoPage extends BaseCreateContentForms {

    private SelenideElement accordionPromo = $(By.cssSelector("div.Accordion__item:nth-child(3)"));
    private SelenideElement inputPromoTitleField = $(By.xpath("//input[@name='content.title']"));
    private SelenideElement inputPromoTextarea = $(By.xpath("//textarea[@name='content.promoText']"));

    public void fillPromo(String title , String promo, String coverType, String pathToCover){
        $(accordionPromo).scrollIntoView(true).click();
        openPromoAccordion();
        inputPromoTitleField.setValue(title);
        inputPromoTextarea.setValue(promo);
        addCover(coverType, pathToCover);
    }

    public void openPromoAccordion() {
        openAccordionTab(accordionPromo);
    }
}
