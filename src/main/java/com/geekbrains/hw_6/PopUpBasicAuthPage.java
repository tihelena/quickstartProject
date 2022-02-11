package com.geekbrains.hw_6;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class PopUpBasicAuthPage extends BasePage {

    public PopUpBasicAuthPage(WebDriver driver) {
        super(driver);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public CatalogPage popUpAuth() throws InterruptedException {
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


}
