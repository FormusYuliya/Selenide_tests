package cms;

import org.testng.annotations.Test;
import pages.*;

public class ImmediateActionTests extends BaseTest {

    @Test
    public void createImmediateActionWithCall() {

        String contentName = "Immediate action with call " + Utils.getDate();

        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateImmediateAction immediateAction = contentManagementPage.createNewImmediateAction();
        immediateAction.fillInfo(contentName, "Here is the best immediate action ever");
        immediateAction.addCallAction("+380966564316");
        immediateAction.saveContent();
        contentManagementPage.verifyContentCreation(contentName);
        BaseMethods.createCampaign(projectDashboardPage, contentName);
    }

    @Test
    public void createImmediateActionWithURL() {

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
        BaseMethods.createCampaign(projectDashboardPage, contentName);

    }

    @Test
    public void createImmediateActionWithNavigation() {

        String contentName = "Immediate action with navigation " + Utils.getDate();

        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateImmediateAction immediateAction = contentManagementPage.createNewImmediateAction();
        immediateAction.fillInfo(contentName, "Here is the best immediate action ever");
        immediateAction.addNavigationAction("Maidan nezalezhnosti, Kyiv, Ukraine");
        immediateAction.saveContent();
        contentManagementPage.verifyContentCreation(contentName);
        BaseMethods.createCampaign(projectDashboardPage, contentName);
    }

    @Test
    public void createImmediateActionWithContact() {

        String contentName = "Immediate action with contact " + Utils.getDate();

        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateImmediateAction immediateAction = contentManagementPage.createNewImmediateAction();
        immediateAction.fillInfo(contentName, "Here is the best immediate action ever");
        immediateAction.addContactAction(
                "Asha",
                "Brown",
                "+380966564316",
                "yformus@ukr.net",
                "https://www.w3schools.com/",
                "Brainway");
        immediateAction.saveContent();
        contentManagementPage.verifyContentCreation(contentName);
        BaseMethods.createCampaign(projectDashboardPage, contentName);
    }

    @Test
    public void createImmediateActionWithEvent() {

        String contentName = "Immediate action with event " + Utils.getDate();

        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateImmediateAction immediateAction = contentManagementPage.createNewImmediateAction();
        immediateAction.fillInfo(contentName, "Here is the best immediate action ever");
        immediateAction.addEventAction("QA Day event", "https://online.qaday.org/");
        immediateAction.saveContent();
        contentManagementPage.verifyContentCreation(contentName);
        BaseMethods.createCampaign(projectDashboardPage, contentName);
    }
}
