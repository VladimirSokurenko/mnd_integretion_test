package com.myNewsDesk;

import org.junit.After;
import org.junit.Before;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSetUp {

    public ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("chromedriver", "/home/alexander/IdeaProjects/my_first_test");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void close(){
        driver.quit();
    }

    //journalist variables and methods

    //variables

    String stagingUrl = "https://www.mnd-staging-sloboda.com/user/signin";
    String productionUrl = "https://www.mynewsdesk.com/user/signin";
    String usernameField = "//*[@id=\"username\"]";
    String passwordField = "//*[@id=\"password\"]";
    String loginButton = "//*[@id=\"login-button\"]";
    String contentMarketTab = "//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[6]/div/span";
    String profileSelector = "//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[6]/div/div/div/a[2]";

    public void goToSite(String url){
        driver.get(url);
    }

    public void logIn(String username, String password){
        driver.findElement(By.xpath(usernameField)).sendKeys(username);
        driver.findElement(By.xpath(passwordField)).sendKeys(password);
        driver.findElement(By.xpath(loginButton)).click();

    }

    public void goProfile(){
        driver.findElement(By.xpath(contentMarketTab)).click();
        driver.findElement(By.xpath(profileSelector)).click();
        //create wait condition and compere values
    }

}
