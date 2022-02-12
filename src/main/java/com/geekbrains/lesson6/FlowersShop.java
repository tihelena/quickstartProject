package com.geekbrains.lesson6;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class FlowersShop {


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();
        driver.get("https://podvorje.ru");
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.xpath("//a[.='Вход / Регистрация']")).click();

        driver.switchTo().frame("jivo-container(about:blank)");
        Thread.sleep(1000);
        driver.findElement(By.id("login-phone")).sendKeys("+7 (903) 687-0254");


//        driver.findElement(By.xpath("//div[@data-catalog='cat']")).click();
//        driver.findElement(By.xpath("//a[@href='/retail/catalogue/roses/index.html']//img[@src='/img/logos/_s50/rose.png']")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//a[@href='/retail/catalogue/roses/climbing.html']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//div[@class='list list-tile']//a[.='Роза Квиксильвер']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[.='В корзину']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//a[@href='/basket/index.html']")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//div[@class='basket-btn _count _more']")).click();
//        Thread.sleep(1000);
//        String text = driver.findElement(By.xpath("//div[@class='table-basket-results']")).getText();
//        System.out.println(text);

        //a[@href='/basket/index.html']
        //span[.='Плетистые розы']
//div[@class='table-basket-results']
        //input[@name='count_91302']


    }
}