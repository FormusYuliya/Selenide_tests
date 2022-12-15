package pages.coupon;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BaseCreateContentForms;

import static com.codeborne.selenide.Selenide.$;

public class CreateCouponPage extends BaseCreateContentForms implements SelectCouponTheme {

    private SelenideElement accordionText = $(By.cssSelector("div.Accordion__item:nth-child(3)"));
    private SelenideElement accordionCoupons = $(By.cssSelector("div.Accordion__item:nth-child(4)"));

    private SelenideElement inputCouponTitle = $(By.cssSelector("input[name=\"content.title\"]"));
    private SelenideElement inputBadgeTitle = $(By.cssSelector("input[name=\"content.badge\"]"));
    private SelenideElement inputSoldOutText = $(By.cssSelector("input[name=\"content.soldOutText\"]"));
    private SelenideElement inputGetCouponButtonText = $(By.cssSelector("input[name=\"content.getCouponButtonText\"]"));
    private SelenideElement inputTextArea = $(By.cssSelector("textarea[name=\"content.info\"]"));

    private SelenideElement checkboxTermsAndConditions = $(By.cssSelector("input[type=\"checkbox\"]"));
    private SelenideElement inputTermsAndConditionsTitle = $(By.cssSelector("input[name=\"content.termsAndConditionsTitle\"]"));
    private SelenideElement textareaTermsAndConditionsText = $(By.cssSelector("textarea[name=\"content.termsAndConditionsText\"]"));

    private SelenideElement dropdownGenerationScheme = $(By.xpath("(//div[contains(@class,'value-container--has-value css-1hwfws3')])[3]"));
    private SelenideElement generationOption;
    private SelenideElement couponCode = $(By.cssSelector("input[name=\"content.preconfiguredCouponCode\"]"));
    private SelenideElement couponPrefix = $(By.cssSelector("input[name=\"content.couponPrefix\"]"));
    private SelenideElement couponLimit = $(By.cssSelector("input[name=\"content.couponsLimit\"]"));

//    private SelenideElement inputImportCouponsFile = $(By.cssSelector("input[name=\"fileWithCodes\"]"));

    enum GenerationScheme {
        ONE_CODE("One-code coupons"),
        UNLIMITED("Unlimited coupon codes"),
        LIMITED("Limited coupon codes"),
        GENERATED("Generated coupon codes");

        private String locator;

        GenerationScheme(String page) {
            this.locator = page;
        }

        private String getLocator() {
            locator = new StringBuilder().append("(//div[contains(.,'").append(locator).append("')])[16]").toString();
            return locator;
        }
    }

    private void openTextAccordion() {
        openAccordionTab(accordionText);
    }

    private void openCouponsAccordion() {
        openAccordionTab(accordionCoupons);
    }

    public void setDesign(Theme theme, colorScheme colorSet, String pathToImage) {
        selectColorScheme(colorSet);
        uploadImage(addCoverImage, pathToImage);
        dropdownSelectTheme.click();
        selectTheme = $(By.xpath(theme.getLocator()));
        selectTheme.click();
    }

    public void fillText(String inputCouponTitleValue, String inputBadgeTitleValue, String inputTextAreaValue, Boolean addTerms) {
        openTextAccordion();
        setDataIntoField(inputCouponTitle, inputCouponTitleValue);
        setDataIntoField(inputBadgeTitle, inputBadgeTitleValue);
        setDataIntoField(inputTextArea, inputTextAreaValue);
        addTermsAndConditions(addTerms);
    }

    public void fillText(String inputCouponTitleValue, String inputBadgeTitleValue, String inputSoldOutTextValue, String inputGetCouponButtonTextValue, String inputTextAreaValue, Boolean addTerms) {
        openTextAccordion();
        setDataIntoField(inputCouponTitle, inputCouponTitleValue);
        setDataIntoField(inputBadgeTitle, inputBadgeTitleValue);
        setDataIntoField(inputSoldOutText, inputSoldOutTextValue);
        setDataIntoField(inputGetCouponButtonText, inputGetCouponButtonTextValue);
        setDataIntoField(inputTextArea, inputTextAreaValue);
        addTermsAndConditions(addTerms);
    }

    private void addTermsAndConditions(Boolean isChecked) {
        if (isChecked) {
            checkboxTermsAndConditions.click();
            setDataIntoField(inputTermsAndConditionsTitle, "Terms and conditions:");
            setDataIntoField(textareaTermsAndConditionsText, "To access some of the public Network features you will need to register for an account."
                    + System.lineSeparator() + "Sodyo strongly encourages you to review our Privacy Policy."
                    + System.lineSeparator() + "You are solely responsible for obtaining and maintaining any equipment or ancillary services needed to connect to or access.");
        }
    }

    private void generateCoupons() {
        openCouponsAccordion();
        dropdownGenerationScheme.click();
    }

    public void generateOneCodeCouponCodes(String couponCode) {
        generateCoupons();
        generationOption = $(By.xpath(GenerationScheme.ONE_CODE.getLocator()));
        generationOption.click();
        setDataIntoField(this.couponCode, couponCode);
    }

    public void generateUnlimitedCouponCodes(String couponPrefix) {
        generateCoupons();
        generationOption = $(By.xpath(GenerationScheme.UNLIMITED.getLocator()));
        generationOption.click();
        setDataIntoField(this.couponPrefix, couponPrefix);
    }

    public void generateLimitedCouponCodes(String couponPrefix, Integer limit) {
        generateCoupons();
        generationOption = $(By.xpath(GenerationScheme.LIMITED.getLocator()));
        generationOption.click();
        setDataIntoField(this.couponPrefix, couponPrefix);
        setDataIntoField(this.couponLimit, limit.toString());
    }

    public EditCouponPage  generateGeneratedCouponCodes() {
        generateCoupons();
        $(By.xpath(GenerationScheme.GENERATED.getLocator())).click();
        saveAndContinue();
        return new EditCouponPage();
    }

    //TODO Generated coupon codes method
}
