import org.junit.Test;
import pages.*;

import java.io.File;

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
    public void createFact() {
        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateFactoidPage newFactoid = contentManagementPage.createNewFactoid();
        newFactoid.fillInfo("Factoid", "Some secription is whitten here");
//        newFactoid.selectColorScheme(BaseCreateContentForms.colorScheme.Breath_of_dawn);
        newFactoid.fillFact("Super title", "A lot of text", "D:\\1.png");
        newFactoid.saveContent();
        Utils.waitFor();
    }
}
