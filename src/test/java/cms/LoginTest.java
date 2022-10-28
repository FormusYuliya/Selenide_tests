package cms;

import org.testng.annotations.Test;
import pages.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginTest extends BaseTest {
    @Test
    public void openLoginPage() {
        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateFactoidPage newFactoid = contentManagementPage.createNewFactoid();
        String temp = newFactoid.getAccordionInfoTitle();
        System.out.println(newFactoid.getAccordionInfoTitle());
//        $(temp).shouldHave(text("Info"));
//        $(temp).shouldBe(text("Info"));
//        $(newFactoid.getAccordionInfoTitle2().innerText()).shouldBe(text("Info"));
        $(newFactoid.getAccordionInfoTitle3()).shouldHave(text("Info"));
        $(newFactoid.getAccordionInfoTitle3()).shouldBe(text("Info"));
//        $(String.valueOf(newFactoid.itemsBlockIsExpanded())).equals(true);
//        pages.Utils.waitFor();
    }

    @Test
    public void checkLogin() {

        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        $(projectDashboardPage.getPageTitle()).shouldHave(text("Quicksnap / Zimark org"));

    }

    @Test
    public void checkAccordion() {
        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateFactoidPage newFactoid = contentManagementPage.createNewFactoid();
//        newFactoid.openDesignAccordion();
        newFactoid.openFactAccordion();
        newFactoid.openSponsorshipAccordion();
        newFactoid.openInfoAccordion();
    }

    @Test
    public void fillInfo() {
        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateFactoidPage newFactoid = contentManagementPage.createNewFactoid();
        newFactoid.fillInfo("Factoid", "Some secription is whitten here");
        Utils.waitFor();
    }

    @Test
    public void fillFact() {
        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateFactoidPage newFactoid = contentManagementPage.createNewFactoid();
        newFactoid.fillInfo("Factoid", "Some secription is whitten here");
//        newFactoid.selectColorScheme(BaseCreateContentForms.colorScheme.Breath_of_dawn);
//        newFactoid.fillFact("Super title", "A lot of text", "https://thiscatdoesnotexist.com/");
//        newFactoid.fillFact("Super title", "A lot of text", "D:\\1.png");
//        newFactoid.saveContent();
        Utils.waitFor();
    }


    @Test //not working need locator
    public void setTheme() {
        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateFactoidPage newFactoid = contentManagementPage.createNewFactoid();
        newFactoid.fillInfo("Factoid", "Some secription is whitten here");
        newFactoid.setDesign(CreateFactoidPage.factoidTheme.Einstein);
        Utils.waitFor();
    }


}


