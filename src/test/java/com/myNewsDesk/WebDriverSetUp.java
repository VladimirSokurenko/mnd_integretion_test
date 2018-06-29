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

    public void getStaging(){
        driver.get("https://www.mnd-staging-sloboda.com/user/signin");
    }

    public void getProduction(){
        driver.get("https://www.mynewsdesk.com/user/signin");
    }

    public void logIn(String username, String password){
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

    }

}
