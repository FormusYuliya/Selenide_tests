package pages.landingPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BaseCreateContentForms;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class CreateFactoidPage extends BaseCreateContentForms {

    private SelenideElement accordionFact = $(By.cssSelector("div.Accordion__item:nth-child(3)"));
    private SelenideElement accordionInfoBlock = $(By.cssSelector(".ContentInfoConfig"));
    private SelenideElement accordionInfoTitle = $(By.cssSelector("div.Accordion__item:nth-child(1)>div.Accordion__item-header>div"));

    private SelenideElement inputFactTitleField = $(By.cssSelector("input[name=\"content.title\"]"));
    private SelenideElement inputFactBodyTextarea = $(By.cssSelector("textarea[name=\"content.factText\"]"));
    private SelenideElement inputFactFile = $(By.cssSelector("input[name=\"content.cover\"]"));
    private SelenideElement addImageInput = $(By.xpath("//*[@name=\"content.cover\"]/following-sibling::input[@type=\"file\"]"));



    String coverImage = "D:\\1.png";

    public enum factoidTheme {
        Postcard("POSTCARD"),
        Note("NOTE"),
        Flyer("FLYER"),
        Ticket("TICKET"),
        Poster("POSTER"),
        Einstein("EINSTEIN"),
        Western("WESTERN");

        private String value;

        factoidTheme(String inputValue) {
            this.value = inputValue;
        }

        public String getValue() {
            return value;
        }
    }



    public void setDesign(factoidTheme themeName) {
        String theme = themeName.getValue();

        openDesignAccordion();
        themeSelector.click();
        themeInput.clear();
        themeInput.setValue(theme);
    }

    public void openFactAccordion() {
        openAccordionTab(accordionFact);
    }

    public void fillFact(String title , String fact, String pathToCover){
        $(accordionFact).scrollIntoView(true).click();
        openFactAccordion();
        inputFactTitleField.setValue(title);
        inputFactBodyTextarea.setValue(fact);
        uploadImage(addImageInput, pathToCover);
        //TODO add icon select
    }


    //TODO select content theme
    public void selectTheme(factoidTheme theme, String colorScheme) {

    }


    //This method does not work because accordion title written  inside of the DIV teg
    public String getAccordionInfoTitle() {
//        return accordionInfoTitle.getText();
        return accordionInfoTitle.getAttribute("innerText");
    }

    public SelenideElement getAccordionInfoTitle2() {
//        return accordionInfoTitle.getText();
        return accordionInfoTitle;
    }

    public String getAccordionInfoTitle3() {
        return accordionInfoTitle.innerText();

    }
}
