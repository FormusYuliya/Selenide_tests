package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateRafflePage extends BaseCreateContentForms implements SelectRaffleTheme {

    private SelenideElement accordionRaffle = $(By.cssSelector("div.Accordion__item:nth-child(3)"));
    private SelenideElement accordionForm = $(By.cssSelector("div.Accordion__item:nth-child(4)"));
    private SelenideElement accordionFinishScreen = $(By.cssSelector("div.Accordion__item:nth-child(5)"));

    private SelenideElement inputRaffleTitle = $(By.cssSelector("input[name='content.title']"));
    private SelenideElement inputRaffleSubtitle = $(By.cssSelector("input[name='content.subtitle']"));
    private SelenideElement inputConfirmationText = $(By.cssSelector("input[name='content.confirmationText']"));
    private SelenideElement inputCodeTitle = $(By.cssSelector("input[name='content.codeTitle']"));
    private SelenideElement addRaffleIcon = $(By.xpath("(//div[contains(.,'Add icon')])[15]"));

    private SelenideElement finishScreenIcon = $(By.xpath("//div[@class='Block IconChooser__placeholder'][contains(.,'Add icon')]"));
    private SelenideElement inputFinishTitle = $(By.cssSelector("input[name='content.finishTitle']"));

    private SelenideElement modalWindow = $(By.cssSelector("div.modal-content"));
    private SelenideElement modalSave = $(By.cssSelector("button.Button:first-child"));

    private void openRaffleAccordion() {
        openAccordionTab(accordionRaffle);
    }

    public void fillRaffle(String raffleTitle, String confirmationText, String codeTitle) {
        openRaffleAccordion();
        setDataIntoField(inputRaffleTitle, raffleTitle);
        setDataIntoField(inputConfirmationText, confirmationText);
        setDataIntoField(inputCodeTitle, codeTitle);
        addRaffleIcon.click();
        //TODO refactor selecting of icon
        modalWindow.shouldBe(Condition.visible);
        $(By.xpath("//i[@class='fa fa-radiation']")).click();
        modalSave.click();
    }

    //TODO form method


    public void fillFinishScreen(String finishTitle) {
        openAccordionTab(accordionFinishScreen);
        setDataIntoField(inputFinishTitle,finishTitle);

        finishScreenIcon.click();
        modalWindow.shouldBe(Condition.visible);
        $(By.xpath("//i[@class='fa fa-blind']")).click();
        modalSave.click();

    }
}



