package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//iframe[contains(@src, 'login')]")
    private WebElement loginFrame;

    @Step("Переключиться в фрейм логина")
    public LoginPage switchToLoginFrame() {
        driver.switchTo().frame(loginFrame);
        return this;
    }

    private final static String LOGIN_INPUT_LOCATOR_BY_ID = "login";
    @FindBy(id = LOGIN_INPUT_LOCATOR_BY_ID)
    public WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//span[.='Войти']/..")
    private WebElement loginButton;

    @Step("Заполнить поле логина")
    public LoginPage fillLogin(String login) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LOGIN_INPUT_LOCATOR_BY_ID)));
        //loginInput.sendKeys(login.split("@")[0] + Keys.chord(Keys.ALT, "2") + login.split("@")[1]);
        loginInput.sendKeys(login);
        return this;
    }

    @Step("Заполнить поле пароля")
    public LoginPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        //webDriverWait.until(d -> d.findElement(By.id("login")).getAttribute("value").contains("@rambler"));
        return this;
    }


    @Step("Клик на кнопку логина")
    public MainPage clickLoginButton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginButton.click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new MainPage(driver);
    }
}







