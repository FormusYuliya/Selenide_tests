package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

//import org.openqa.selenium.support.*;


public class SignInPage extends Base {


    private SelenideElement emailField = $(By.cssSelector("input[name='email']"));
    private SelenideElement passwordField = $(By.cssSelector("input[name='password']"));
    private SelenideElement signInButton = $(By.cssSelector("button:first-of-type"));


    public void openPage() {
        open(BASE_URL);
    }

    public ProjectDashboardPage loginAs(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
        signInButton.click();
        return new ProjectDashboardPage();
    }


}
