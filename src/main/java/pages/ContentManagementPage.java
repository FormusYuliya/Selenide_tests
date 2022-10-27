package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ContentManagementPage implements SelectSidebarMenu {

    private SelenideElement addNewContentButton = $(By.xpath("//button[contains(.,'Add new content')]"));
    private SelenideElement applyButton = $(By.xpath("//a[contains(.,'Apply')]"));
    private SelenideElement factoidContent = $(By.xpath("//i[@class='icon-fact']"));
    private SelenideElement couponContent = $(By.xpath("//div[@class='AddContentModal__content-sub-type '][contains(.,'Classic Coupon')]"));
    private SelenideElement raffleContent = $(By.xpath("//div[@class='AddContentModal__content-sub-type__label'][contains(.,'Raffle')]"));

    private void createNewContent(SelenideElement element){
        addNewContentButton.click();
        element.click();
    }
    


    public CreateFactoidPage createNewFactoid(){
        createNewContent(factoidContent);
        applyButton.click();
        return new CreateFactoidPage();
    }

    public CreateCouponPage  createNewCoupon(){
        createNewContent(couponContent);
        applyButton.click();
        return new CreateCouponPage();
    }

    public CreateRafflePage createNewRaffle(){
        createNewContent(raffleContent);
        applyButton.click();
        return new CreateRafflePage();
    }


}
