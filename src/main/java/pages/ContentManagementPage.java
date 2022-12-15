package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.coupon.CreateCouponPage;
import pages.landingPage.CreateFactoidPage;
import pages.landingPage.CreatePromoPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ContentManagementPage implements SelectSidebarMenu {

    private SelenideElement addNewContentButton = $(By.xpath("//button[contains(.,'Add new content')]"));
    private SelenideElement applyButton = $(By.xpath("//a[contains(.,'Apply')]"));
    private SelenideElement factoidContent = $(By.cssSelector("i.icon-fact"));
    private SelenideElement immediateAction = $(By.cssSelector("i.icon-immediate-action"));
    private SelenideElement couponContent = $(By.cssSelector("i.icon-classic-coupon"));
    private SelenideElement promoContent = $(By.cssSelector("i.icon-promo"));
    private SelenideElement raffleContent = $(By.xpath("//div[@class='AddContentModal__content-sub-type__label'][contains(.,'Raffle')]"));
    private SelenideElement firstContentTitle = $(By.xpath("(//div[@class='ContentRow__title'])[1]"));

    private void createNewContent(SelenideElement element) {
        addNewContentButton.click();
        element.click();
    }

    public CreateImmediateAction createNewImmediateAction() {
        createNewContent(immediateAction);
        applyButton.click();
        return new CreateImmediateAction();
    }


    public CreateFactoidPage createNewFactoid() {
        createNewContent(factoidContent);
        applyButton.click();
        return new CreateFactoidPage();
    }

    public CreateCouponPage createNewCoupon() {
        createNewContent(couponContent);
        applyButton.click();
        return new CreateCouponPage();
    }

    public CreateRafflePage createNewRaffle() {
        createNewContent(raffleContent);
        applyButton.click();
        return new CreateRafflePage();
    }

    public String getFirstContentTitle() {
        String title = firstContentTitle.getText();
        return title;
    }
    public CreatePromoPage createNewPromo() {
        createNewContent(promoContent);
        applyButton.click();
        return new CreatePromoPage();
    }

    @Step("Verify that content added into the 'Content management' table")
    public void verifyContentCreation(String title) {
        $(firstContentTitle).waitUntil(visible, 5000).isEnabled();
        $(firstContentTitle).shouldHave(text(title));
    }
}
