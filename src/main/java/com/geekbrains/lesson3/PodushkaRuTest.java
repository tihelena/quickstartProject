package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PodushkaRuTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();
        driver.get("https://podushka.ru");
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.xpath("//a[@href='/categories/postelinoe-belie']")).click();
        Thread.sleep(3000);
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='relative page']//img"));
        //System.out.println("Number of images:" +images.size());
        images.get(0).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[.='Добавить в корзину']")).click();
        Thread.sleep(3000);

        List<WebElement> carts = driver.findElements(By.xpath("//a[@href='/cart']"));
        //System.out.println("Number of carts:" +carts.size());
        carts.get(0).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@name='user_phone']")).click();
        driver.findElement(By.xpath("//input[@name='user_phone']")).sendKeys("+7(123)456-78-90");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[.='Продолжить оформление']")).click();
        driver.findElement(By.xpath("//input[@name='privacy_is_accepted']")).click();
        driver.findElement(By.xpath("//button[.='Оформить заказ']")).click();




    }
}
