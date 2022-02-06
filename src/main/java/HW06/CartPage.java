package HW06;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.ui.ExpectedConditions;

        import static org.hamcrest.MatcherAssert.assertThat;
        import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }


    private final static String MAKEUP_BUTTON_LOCATOR_BY_XPATH =
            "//a[@href='ru/store/tag/makeup/']";
    @FindBy(xpath = MAKEUP_BUTTON_LOCATOR_BY_XPATH)
    private WebElement makeupButton;

    @Step("Клик на раздел Макияж")
    public CartPage clickMakeup() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MAKEUP_BUTTON_LOCATOR_BY_XPATH)));
        makeupButton.click();
        return this;
    }

    private final static String TENX_CARD_LOCATOR_BY_XPATH =
            "//a[@href='/ru/store/tenx/72767/']";
    @FindBy(xpath = TENX_CARD_LOCATOR_BY_XPATH)
    private WebElement tenxCard;

    @Step("Клик на карточку товара")
    public CartPage clickTenx() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TENX_CARD_LOCATOR_BY_XPATH)));
        tenxCard.click();
        return this;
    }

    private final static String ADD_CART_LOCATOR_BY_XPATH =
            "//button[.='В корзину']";
    @FindBy(xpath = ADD_CART_LOCATOR_BY_XPATH)
    private WebElement addCart;

    @Step("Добавить товар в корзину")
    public CartPage clickAddCart() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADD_CART_LOCATOR_BY_XPATH)));
        addCart.click();
        return this;
    }

    private final static String CLICK_CART_LOCATOR_BY_XPATH =
            "//a[@href='/ru/store/cart']";
    @FindBy(xpath = CLICK_CART_LOCATOR_BY_XPATH)
    private WebElement clickCart;

    @Step("Перейти в корзину")
    public CartPage clickCart() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CLICK_CART_LOCATOR_BY_XPATH)));
        clickCart.click();
        return this;
    }

    private final static String ADDED_TO_CART_XPATH_LOCATOR = "//button[.='Оформить заказ']";
    @FindBy(xpath = ADDED_TO_CART_XPATH_LOCATOR)
    private WebElement addedToCartElement;

    @Step("Проверить товар в корзине")
    public CartPage checkTenAddedToCart() {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ADDED_TO_CART_XPATH_LOCATOR)));
        assertThat(addedToCartElement, isDisplayed());
        return this;
    }
}
