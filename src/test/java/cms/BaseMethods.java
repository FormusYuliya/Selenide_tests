package cms;

import io.qameta.allure.Allure;
import pages.*;
import pages.campaign.CampaignManagementFourthStep;
import pages.campaign.CampaignManagementPage;
import pages.campaign.CampaignManagementSecondStep;
import pages.campaign.CampaignManagementThirdStep;

public class BaseMethods extends BaseTest implements SelectCouponTheme, SelectColorScheme{

    public static void createCampaign(ProjectDashboardPage projectDashboardPage, String contentType, String contentName ) {
        CampaignManagementPage campaignManagementPage = projectDashboardPage.openCampaignManagementPage();
        campaignManagementPage.createCampaign();
        CampaignManagementSecondStep step2 = campaignManagementPage.fillFirstStep(contentType);
        CampaignManagementThirdStep step3 = step2.selectLatestContent();
        CampaignManagementFourthStep step4 = step3.nextStep();
        step4.submitCampaignCreation();
        campaignManagementPage.verifyCampaignCreation(contentName);
    }

    public static void createCampaign(ProjectDashboardPage projectDashboardPage, String contentType ) {
        CampaignManagementPage campaignManagementPage = projectDashboardPage.openCampaignManagementPage();
        campaignManagementPage.createCampaign();
        CampaignManagementSecondStep step2 = campaignManagementPage.fillFirstStep(contentType);
        CampaignManagementThirdStep step3 = step2.selectLatestContent();
        CampaignManagementFourthStep step4 = step3.nextStep();
        step4.submitCampaignCreation();
//        campaignManagementPage.verifyCampaignCreation(contentName);
    }

//    public static void checkCampaignTitle(){
//        campaignManagementPage
//    }

//    public void takeScreenShot(String name) {
//        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)PageDriver.getCurrentDriver()).getScreenshotAs(OutputType.BYTES) ));
//    }
}
