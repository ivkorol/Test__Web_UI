package com.nlstar.HW03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HW03 {
    //Тест "Добавление товара в корзину"

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.nlstar.com/ru/store/");
        //Появляется поп ап с подтверждением города
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[.='Да, всё верно']")).click();

        //Клик на "Войти", ждем появления формы авторизации, авторизуемся
        driver.findElement(By.xpath("////a[@href='/ru/store/login/']")).click(); //Здесь коварная ссылка, т.к. разработчики сделали одинаковые ссылки для веб и мобилки.
        //В этом месте тест падает, исправить не получилось
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'login')]")));
        driver.findElement(By.id("login")).sendKeys("914706560559");
        driver.findElement(By.id("password")).sendKeys("773058");
        driver.findElement(By.xpath("//button[.='Войти']/..")).click();
        Thread.sleep(5000);

        //Переход в раздел Макияж
        driver.findElement(By.xpath("//a[@href='ru/store/tag/makeup/']")).click();
        Thread.sleep(5000);

        //Проваливание в карточку товара
        driver.findElement(By.xpath("//a[@href='/ru/store/tenx/72767/']")).click();
        //Клик на кнопку "В корзину"
        driver.findElement(By.xpath("//button[.='В корзину']")).click();
        //Переход в корзину
        driver.findElement(By.xpath("//a[@href='/ru/store/cart']")).click();
        Thread.sleep(5000); //Как закончить тест? Перешли в корзину и глазками увидели товар. Все?

        driver.quit();
    }
}
