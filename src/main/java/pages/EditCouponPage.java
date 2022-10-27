package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class EditCouponPage extends CreateCouponPage{

    private SelenideElement importCodesButton = $(By.xpath("//button[contains(.,'Import codes')]"));
    private SelenideElement inputImportCouponsFile = $(By.cssSelector("input[name=\"fileWithCodes\"]"));
    private SelenideElement accordionCoupons = $(By.cssSelector("div.Accordion__item:nth-child(4)"));


    private void openCouponsAccordion() {
        openAccordionTab(accordionCoupons);
    }

    public void uploadCoupons(){
        Utils.waitFor();
        accordionCoupons.click();
        importCodesButton.click();
        Utils.waitFor();
//        switchTo().activeElement();
        $(By.cssSelector("input[name=\"fileWithCodes\"]")).sendKeys("D:\\generate.xlsx");
    }
}
