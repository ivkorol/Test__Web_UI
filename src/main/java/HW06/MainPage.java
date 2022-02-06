package HW06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/ru/store/login/']")
    public WebElement loginWindow;

    public LoginPage switchToLoginWindow(){
        loginWindow.click();
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//button[.='Войти']")
    public WebElement loginButton;

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }


    @FindBy(xpath = "//a[@href='ru/store/tag/makeup/")
    public WebElement makeupButton;

    public CartPage clickMakeup() {
        makeupButton.click();
        return new CartPage(driver);
    }


    @FindBy(xpath = "//a[@href='/ru/store/tenx/72767/']")
    public WebElement tenxCard;

    public CartPage clickTenx() {
        tenxCard.click();
        return new CartPage(driver);
    }


    @FindBy(xpath = "//button[.='В корзину']")
    public WebElement addCart;

    public CartPage clickAddCart() {
        addCart.click();
        return new CartPage(driver);
    }


    @FindBy(xpath = "//a[@href='/ru/store/cart']")
    public WebElement clickCart;

    public CartPage clickCart() {
        clickCart.click();
        return new CartPage(driver);
    }


    @FindBy(xpath = "//button[.='Оформить заказ']")
    public WebElement addedToCartElement;

    public CartPage checkTenAddedToCart() {
        addedToCartElement.click();
        return new CartPage(driver);
    }


}

