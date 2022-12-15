package cms;

import org.testng.annotations.Test;
import pages.*;
import pages.coupon.SelectColorScheme;

public class Gamification extends BaseTest implements SelectRaffleTheme, SelectColorScheme {
    @Test
    public void createRaffle() {
        SignInPage signInPage = new SignInPage();
        signInPage.openPage();
        ProjectDashboardPage projectDashboardPage = signInPage.loginAs("admin@sodyo.com", "So123456");
        ContentManagementPage contentManagementPage = projectDashboardPage.openContentManagementPage();
        CreateRafflePage newRaffle = contentManagementPage.createNewRaffle();
        newRaffle.fillInfo("Raffle", "Raffle content description is written here");
        newRaffle.setDesign(theme.CALLISTO, colorScheme.Colibri, "D:\\1.png");
        newRaffle.fillRaffle("title", "Confirm", "code");
        newRaffle.fillFinishScreen("Raffle Puffle title");
    }
}

