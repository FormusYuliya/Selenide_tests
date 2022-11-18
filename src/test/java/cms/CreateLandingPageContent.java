package cms;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.ContentManagementPage;
import pages.CreateFactoidPage;
import pages.ProjectDashboardPage;
import pages.SignInPage;

public class CreateLandingPageContent extends BaseTest {
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void createFactCampaign() {
        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateFactoidPage newFactoid = contentManagementPage.createNewFactoid();
        newFactoid.fillInfo("Factoid", "Some secription is whitten here");
//        newFactoid.setDesign(CreateFactoidPage.factoidTheme.Einstein);
        newFactoid.fillFact("Super title", "A lot of text", "D:\\1.png");
        newFactoid.saveContent();
        BaseMethods.createCampaign( projectDashboardPage, "Factoid ");
    }
}


