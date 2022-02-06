package HW06;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final static String LOGIN_WINDOW_LOCATOR = "//a[@href='/ru/store/login/']";
    @FindBy(xpath = LOGIN_WINDOW_LOCATOR)
    public WebElement loginWindow;

    @Step("Переключиться на окно логина")
    public LoginPage switchToLoginWindow() {
        driver.switchTo().window(String.valueOf((driver.findElement(By.xpath("//class[.='login__inner login__inner_type_login']")))));
        return this;
    }

    private final static String LOGIN_INPUT_LOCATOR_BY_ID = "login";
    @FindBy(id = LOGIN_INPUT_LOCATOR_BY_ID)
    public WebElement loginInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.='Войти']/..")
    public WebElement loginButton;

    public LoginPage fillLogin(String login) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LOGIN_INPUT_LOCATOR_BY_ID)));
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Кликнуть кнопку Войти")
    public MainPage clickLoginButton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new MainPage(driver);
    }
}

