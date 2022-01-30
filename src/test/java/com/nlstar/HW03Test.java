package com.nlstar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HW03Test {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String NLSTAR_URL = "https://www.nlstar.com/ru/store/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(NLSTAR_URL);
        driver.manage().window().maximize();

    }

    @Test
    void hoverLoginTest() {
        actions.moveToElement(driver.findElement(By.xpath("//a[@href='/ru/store/login/']")))
                .build()
                .perform();
        driver.findElement(By.xpath("//div[@class='authorization authorization_login']//a[@href='/ru/store/login/']")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("Войти"));
    }

    @Test
    void hoverCartTest() {
        actions.moveToElement(driver.findElement(By.xpath("//button[.='В корзину']")))
                .build()
                .perform();
        driver.findElement(By.xpath("//a[@href='/ru/store/cart']")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("Оформить заказ"));
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
