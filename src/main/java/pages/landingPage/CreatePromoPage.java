package pages.landingPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BaseCreateContentForms;

import static com.codeborne.selenide.Selenide.$;

public class CreatePromoPage extends BaseCreateContentForms {

    private SelenideElement accordionFact = $(By.cssSelector("div.Accordion__item:nth-child(3)"));
    private SelenideElement accordionInfoBlock = $(By.cssSelector(".ContentInfoConfig"));
    private SelenideElement accordionInfoTitle = $(By.cssSelector("div.Accordion__item:nth-child(1)>div.Accordion__item-header>div"));

}
