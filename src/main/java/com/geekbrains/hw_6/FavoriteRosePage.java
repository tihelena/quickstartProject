package com.geekbrains.hw_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class FavoriteRosePage extends BasePage{

    public FavoriteRosePage(WebDriver driver) {
        super(driver);
    }

    public final static String ADD_ROSE_BY_XPATH = "//button[.='В корзину']";
    @FindBy(xpath = ADD_ROSE_BY_XPATH)
    public WebElement buttonBay;

    public FavoriteRosePage bayRose() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADD_ROSE_BY_XPATH)));
        buttonBay.click();
        Thread.sleep(3000);
        return this;
    }

    public final static String GO_BASKET_BY_XPATH = "//a[@href='/basket/index.html']";
    @FindBy(xpath = GO_BASKET_BY_XPATH)
    public WebElement buttonBasket;

    public BasketPage goToBasket() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GO_BASKET_BY_XPATH)));
        buttonBasket.click();
        return new BasketPage(driver);
    }

}
