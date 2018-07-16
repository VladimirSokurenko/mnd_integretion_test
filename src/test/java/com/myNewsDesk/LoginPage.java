package com.myNewsDesk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginBtn = By.id("login-button");

    public LoginPage(WebDriver driver){

        this.driver = driver;

    }

    public void typeUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginBtn).click();
    }

    public void login(String username, String password){

        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();

    }
}
