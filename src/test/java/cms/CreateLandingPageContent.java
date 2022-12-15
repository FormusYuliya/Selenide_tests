package cms;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.*;
import pages.landingPage.CreateFactoidPage;
import pages.landingPage.CreatePromoPage;

public class CreateLandingPageContent extends BaseTest {
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void createFactCampaign() {

        String contentName = "Factoid " + Utils.getDate();

        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateFactoidPage newFactoid = contentManagementPage.createNewFactoid();
        newFactoid.fillInfo(contentName, "Some description is written here");
//        newFactoid.setDesign(CreateFactoidPage.factoidTheme.Einstein);
        newFactoid.fillFact("Super title", "A lot of text", "D:\\1.png");
        newFactoid.saveContent();
        contentManagementPage.verifyContentCreation(contentName);
        BaseMethods.createCampaign( projectDashboardPage, contentName);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void createPromoCampaign(){
        String contentName = "Promo " + Utils.getDate();

        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreatePromoPage newPromo = contentManagementPage.createNewPromo();
        newPromo.fillInfo(contentName, "Some description is written here");
        newPromo.fillPromo("Super title","A lot of text","D:\\1.png");
        newPromo.saveContent();
        contentManagementPage.verifyContentCreation(contentName);
        BaseMethods.createCampaign( projectDashboardPage, contentName);
    }
}


