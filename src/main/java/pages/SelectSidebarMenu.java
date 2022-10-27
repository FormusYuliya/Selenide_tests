package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface SelectSidebarMenu {
    enum SidebarMenuItem{
        PROJECT_DATA("Project Data"),
        PROJECT_DASHBOARD("Project Dashboard"),
        ACTIVITY_DASHBOARD("Activity Dashboard"),
        CUSTOM_DASHBOARDS("Custom Dashboards (beta)"),
        CONTENT_MANAGEMENT("Content Management"),
        CONTENT_SETS("Content Sets"),
        CAMPAIGNS("Campaigns"),
        CAMPAIGN_GROUPS("Campaign Groups"),
        PrivacyManagement("Privacy Management"),
        ADMINISTRATION("Administration"),
        SETTINGS("Settings"),
        CONTACT_SODYO("Contact Sodyo"),
        USER_GUIDE("User Guide");

        private String locator;
        SidebarMenuItem(String page)
        {
            this.locator = page;
        }

        public String getLocator(){
            locator = new StringBuilder().append("//span[contains(.,'").append(locator).append("')]").toString();
            // //span[contains(.,'Content Management')]
            return locator;
        }
    }


}
