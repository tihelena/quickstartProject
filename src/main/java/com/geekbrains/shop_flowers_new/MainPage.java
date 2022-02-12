package com.geekbrains.shop_flowers_new;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.browser.model.BrowserContextID;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final static String  USER_NAME_BY_XPATH = "//div[@class='sm_login_login']";
    @FindBy(xpath = USER_NAME_BY_XPATH)
    private WebElement user;

    public MainPage checkUserName() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(USER_NAME_BY_XPATH)));
        String userName = user.getText();
        assertThat(userName, is("Елена"));
        return this;
    }

    @FindBy(xpath = "//h1")
    private WebElement header;

    public MainPage checkHeader() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        String textHeader = header.getText();
        assertTrue(textHeader.contains("Подворье"));
        return this;
    }

    private final static String  AUTH_LINK_BY_CSS = "i";
    @FindBy(css = AUTH_LINK_BY_CSS)
    private WebElement authLink;

    //@Step("Кликнуть ссылку авторизации") все падает
    public MainPage clickAuthLink() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(AUTH_LINK_BY_CSS)));
        authLink.click();
        return this;
    }

    private final static String   PHONE_INPUT_LOCATOR_BY_ID  = "login-phone";
    @FindBy(id = PHONE_INPUT_LOCATOR_BY_ID)
    private WebElement loginPhone;

    //@Step("Ввести логин - телефон")
    public MainPage setLoginAsPhone() {
        loginPhone.sendKeys("903 687-0254");
        return this;
    }

    private final static String  BTN_PHONE_NEXT_BY_CSS = ".login-step-bottom:nth-child(9) .btn";
    @FindBy(css = BTN_PHONE_NEXT_BY_CSS)
    private WebElement buttonPhone;

    public MainPage clickPhoneConfirm() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BTN_PHONE_NEXT_BY_CSS)));
        buttonPhone.click();
        return this;
    }

    private final static String   MAIL_LINK_LOCATOR_BY_LINK_TEXT  = "Войти по email-адресу";
    @FindBy(linkText = MAIL_LINK_LOCATOR_BY_LINK_TEXT)
    private WebElement mailLink;

    public MainPage clickMailLink() {
        mailLink.click();
        return this;
    }

    private final static String  INPUT_MAIL_LOCATOR_BY_NAME = "login_mail";
    @FindBy(name = INPUT_MAIL_LOCATOR_BY_NAME)
    private WebElement loginMail;

    public MainPage setLoginAsMail() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name(INPUT_MAIL_LOCATOR_BY_NAME)));
        loginMail.sendKeys("777test77er@rambler.ru");
        return this;
    }

    private final static String  BTN_MAIL_NEXT_BY_CSS = ".login-step-bottom:nth-child(7) .btn";
    @FindBy(css = BTN_MAIL_NEXT_BY_CSS)
    private WebElement buttonMail;

    public MainPage clickMailConfirm() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BTN_MAIL_NEXT_BY_CSS)));
        buttonMail.click();
        return this;
    }

    private final static String  INPUT_PASSWORD_LOCATOR_BY_NAME = "login_password";
    @FindBy(name = INPUT_PASSWORD_LOCATOR_BY_NAME)
    private WebElement passwordInput;

    public MainPage setPassword() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name(INPUT_PASSWORD_LOCATOR_BY_NAME)));
        passwordInput.sendKeys("Test777a");
        return this;
    }

    private final static String  BTN_ALL_RIGHT_BY_CSS = ".login-step-bottom:nth-child(6) .btn";
    @FindBy(css = BTN_ALL_RIGHT_BY_CSS)
    private WebElement buttonEnd;

    public MainPage clickAllConfirm() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BTN_ALL_RIGHT_BY_CSS)));
        buttonEnd.click();
        return this;
    }

}
