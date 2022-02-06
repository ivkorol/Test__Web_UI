package HW06;

import io.github.bonigarcia.wdm.WebDriverManager;
        import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;

public class HW06Test {
    WebDriver driver;
    private final static String NLSTAR_URL = "https://www.nlstar.com/ru/store/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get(NLSTAR_URL);
        driver.manage().window().maximize();
    }

    @Test
    void likeRandomFilmTest() {
        new MainPage(driver)
                .clickLoginButton()
                .fillLogin("914706560559")
                .fillPassword("773058")
                .clickLoginButton()
                .switchToLoginWindow()
                .clickMakeup()
                .clickTenx()
                .clickAddCart()
                .clickCart()
                .checkTenAddedToCart();
    }

    @AfterEach
    void killDriver() {
        driver.quit();
    }
}
