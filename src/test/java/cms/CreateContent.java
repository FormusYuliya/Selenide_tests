package cms;

import cms.BaseMethods;
import cms.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;
import pages.*;


public class CreateContent extends BaseTest implements SelectCouponTheme, SelectColorScheme {

    @Test
    public void createOneCodeCoupon() {
        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateCouponPage newCoupon = contentManagementPage.createNewCoupon();
        newCoupon.fillInfo("Coupon one code ", "Some description is written here");
        //TODO fix image upload
        newCoupon.setDesign(Theme.MODERN, SelectColorScheme.colorScheme.Breath_of_dawn, "D:\\1.png");
        Utils.waitFor();
        newCoupon.fillText("Coupon title", "50% discount", "A lot of text is set here, but it can be even more ", true);
        newCoupon.generateOneCodeCouponCodes("CoUPoN");
        // Add Sponsorship
        newCoupon.saveContent();
        Utils.waitFor();
    }

    @Test
    public void createUnlimitedCoupon() {
        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateCouponPage newCoupon = contentManagementPage.createNewCoupon();
        newCoupon.fillInfo("Coupon unlimited", "Some description is written here");
        newCoupon.setDesign(Theme.MODERN, BaseCreateContentForms.colorScheme.Breath_of_dawn, "D:\\1.png");
        newCoupon.fillText("Coupon title", "50% discount", "A lot of text is set here, but it can be even more ", true);
        newCoupon.generateUnlimitedCouponCodes("IC");
        // Add Sponsorship
        newCoupon.saveContent();
        Utils.waitFor();
    }

    @Test
    public void createLimitedCoupon() {
        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateCouponPage newCoupon = contentManagementPage.createNewCoupon();
        newCoupon.fillInfo("Coupon limited", "Some description is written here");
        newCoupon.setDesign(Theme.MODERN, BaseCreateContentForms.colorScheme.Colibri, "D:\\1.png");
        newCoupon.fillText("Coupon title", "50% discount", "A lot of text is set here, but it can be even more ", true);
        newCoupon.generateLimitedCouponCodes("IC", 2);
        // Add Sponsorship
        newCoupon.saveContent();
        Utils.waitFor();
    }

    @Test
    public void createGeneratedCoupon() {
        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateCouponPage newCoupon = contentManagementPage.createNewCoupon();
        newCoupon.fillInfo("Coupon generated ", "Some description is written here");
        newCoupon.setDesign(Theme.MODERN, BaseCreateContentForms.colorScheme.Summertime, "D:\\1.png");

        newCoupon.fillText("Coupon title", "50% discount", "A lot of text is set here, but it can be even more ", true);
        EditCouponPage editCouponPage = newCoupon.generateGeneratedCouponCodes();
        editCouponPage.uploadCoupons();
        // Add Sponsorship
//        newCoupon.saveContent();
        Utils.waitFor();
    }



    @Test
    public void createImmediateActionWithCall(){
        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateImmediateAction immediateAction = contentManagementPage.createNewImmediateAction();
        immediateAction.fillInfo("Immediate action with call ", "Here is the best immediate action ever");
        immediateAction.addCallAction("+380966564316");
        immediateAction.saveContent();
        BaseMethods.createCampaign( projectDashboardPage, "Immediate action with call");
    }

    @Test
    public void createImmediateActionWithURL(){
        String contentName = "Immediate action with URL " + Utils.getDate();

        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateImmediateAction immediateAction = contentManagementPage.createNewImmediateAction();
        immediateAction.fillInfo(contentName, "Here is the best immediate action ever");
        immediateAction.addUrlAction("https://www.w3schools.com/");
        immediateAction.saveContent();
        contentManagementPage.verifyContentCreation(contentName);
        BaseMethods.createCampaign( projectDashboardPage, contentName);


    }
}
