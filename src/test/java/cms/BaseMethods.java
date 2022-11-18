package cms;

import pages.*;
import pages.campaign.CampaignManagementFourthStep;
import pages.campaign.CampaignManagementPage;
import pages.campaign.CampaignManagementSecondStep;
import pages.campaign.CampaignManagementThirdStep;

public class BaseMethods extends BaseTest implements SelectCouponTheme, SelectColorScheme{

    public static void createCampaign(ProjectDashboardPage projectDashboardPage, String contentType) {
        CampaignManagementPage campaignManagementPage = projectDashboardPage.openCampaignManagementPage();
        campaignManagementPage.createCampaign();
        CampaignManagementSecondStep step2 = campaignManagementPage.fillFirstStep(contentType);
        CampaignManagementThirdStep step3 = step2.selectLatestContent();
        CampaignManagementFourthStep step4 = step3.nextStep();
        step4.submitCampaignCreation();
    }
}
