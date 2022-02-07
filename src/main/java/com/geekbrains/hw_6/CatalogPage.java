package com.geekbrains.hw_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CatalogPage extends BasePage{

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-catalog='cat']")
    public WebElement catalog;

    public CatalogPage showTopList() {
        catalog.click();
        return this;
    }

    public final static String SELECT_ROSES_BY_XPATH = "//a[@href='/retail/catalogue/roses/index.html']//img[@src='/img/logos/_s50/rose.png']";
    @FindBy(xpath = SELECT_ROSES_BY_XPATH )
    public WebElement roses;

    public CatalogPage selectFromTopList() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SELECT_ROSES_BY_XPATH)));
        roses.click();

        return this;
    }

    public final static String SELECT_TYPE_OF_ROSES_BY_XPATH = "//a[@href='/retail/catalogue/roses/climbing.html']";
    @FindBy(xpath = SELECT_TYPE_OF_ROSES_BY_XPATH)
    public WebElement typeOfRoses;

    public RosePage setTypeOfRoses() throws InterruptedException {
        Thread.sleep(3000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SELECT_TYPE_OF_ROSES_BY_XPATH)));
        typeOfRoses.click();
        return new RosePage(driver);


    }
}
