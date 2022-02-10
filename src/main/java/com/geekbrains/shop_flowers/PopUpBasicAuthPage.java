package com.geekbrains.shop_flowers;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PopUpBasicAuthPage extends BasePage {

    public PopUpBasicAuthPage(WebDriver driver) {
        super(driver);
    }
    
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public final static String LINK_AUTH_BY_XPATH = "//a[.='Вход / Регистрация']";
    @FindBy(xpath = LINK_AUTH_BY_XPATH)
    public WebElement authLink;

    @Step("Аутентификация на сайте, логин - номер телефона")
    public CatalogPage popUpAuthWithPhone() throws InterruptedException {
       // authLink.click();
        js.executeScript("window.openLoginPopup();");
        Thread.sleep(1000);
        js.executeScript("document.querySelector('#login-phone').value='+7 (903) 687-0254';");
        Thread.sleep(1000);
        js.executeScript("document.querySelector('body > div.mainblock > div.header > div.head_top > div > div >" +
                " div.login-popup > div.login-popup-inner > div.login-step.is-active > form > div.login-step-bottom > " +
                "div:nth-child(1) > a').click();");
        Thread.sleep(3000);
        js.executeScript("document.querySelector('body > div.mainblock > div.header > div.head_top > div > div >" +
                " div.login-popup > div.login-popup-inner > div.login-step.is-active > form >" +
                " input[type=\"password\"]:nth-child(1)').value='Test777a';");
        Thread.sleep(1000);
        js.executeScript("document.querySelector('body > div.mainblock > div.header > div.head_top > div > div > " +
                "div.login-popup > div.login-popup-inner > div.login-step.is-active > form > div >" +
                " div:nth-child(1) > a').click();");

        Thread.sleep(5000);
        return new CatalogPage(driver);
    }

    @Step("Аутентификация на сайте, логин - email")
    public CatalogPage popUpAuthWithMail() throws InterruptedException {

        authLink.click();
        Thread.sleep(1000);
        js.executeScript("document.querySelector('body > div.mainblock > div.header > div.head_top > div > div >" +
                " div.login-popup > div.login-popup-inner > div.login-step.is-active > form >" +
                " div.login-step-bottom > div:nth-child(2) > a').click();");
        Thread.sleep(1000);

        js.executeScript("document.querySelector('body > div.mainblock > div.header > div.head_top > div > " +
                "div > div.login-popup > div.login-popup-inner > div.login-step.is-active > form > " +
                "input[type=\"email\"]:nth-child(1)').value='777test77er@rambler.ru';");
        Thread.sleep(3000);


        js.executeScript("document.querySelector('body > div.mainblock > div.header > div.head_top > div >" +
                " div > div.login-popup > div.login-popup-inner > div.login-step.is-active > form >" +
                " div > div:nth-child(1) > a').click();");
        Thread.sleep(1000);


        js.executeScript("document.querySelector('body > div.mainblock > div.header > div.head_top > div > div >" +
                " div.login-popup > div.login-popup-inner > div.login-step.is-active > form > " +
                "input[type=\"password\"]:nth-child(1)').value='Test777er';");
        Thread.sleep(1000);

        js.executeScript("document.querySelector('body > div.mainblock > div.header > div.head_top > div > div > " +
                "div.login-popup > div.login-popup-inner > div.login-step.is-active > form >" +
                " div > div:nth-child(1) > a').click();");

        Thread.sleep(5000);
        return new CatalogPage(driver);


    }

}
