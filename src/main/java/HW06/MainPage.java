package HW06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[.='Войти']")
    public WebElement loginButton;

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }


}

