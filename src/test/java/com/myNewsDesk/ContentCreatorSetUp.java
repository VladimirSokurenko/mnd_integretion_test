package com.myNewsDesk;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContentCreatorSetUp {

    public ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("chromedriver", "/home/alexander/IdeaProjects/my_first_test");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
    String aboutSelector = "//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[6]/div/div/div/a[3]/span";
    String assignmentsSelecor ="//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[6]/div/div/div/a[1]/span";
    String profileHeading = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div/div/div[1]/h1";
    String profileAboutTitle = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/h3[1]";
    String prfileServiceTitle = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/h3[2]";
    String profileExpertiseTitle = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/h3[3]";
    String profileLanguageTitle = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/h3[4]";
    String profileProtfolio = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div[1]/h2";
    String viewAsVisitorBtn = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div/div/div[2]/div[1]/div/button[1]";
    String profileBackBtn = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div/div/div[2]/div/div/button";
    String viewAsVisitorHeading = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div/div/div[1]/h1";
    String editProfileBtn = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div/div/div[2]/div[1]/div/button[2]";
    String nameField = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/form/div/div/div[3]/div[1]/div/div/div[2]/div/input";
    String titleField = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/form/div/div/div[3]/div[2]/div/div/div[2]/div/input";
    String aboutFiled = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/form/div/div/div[5]/div/div/div[2]/div/textarea";
    String saveProfileBtn = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/form/footer/div/button";
    String removeAvatarBtn = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/form/div/div/div[1]/div/div/div[2]/div/div/div";
    String removeCoverBtn = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/form/div/div/div[2]/div/div/div[2]/div/div/div";
    String profileServiceSelector = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div/form/div/div/div[6]/div/div/div[2]/div/div";
    String profileExpertiseSelector = "";
    String profileLanguageSelector = "";
    String profileName = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div[2]/div[1]/div/h2";
    String profileTitle = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div[2]/div[1]/div/p[1]";
    String profileAbout = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/p[1]";
    String addProjectBtn = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[3]/div[2]/a";
    String portfolioItemTitle = "//*[@id=\"react-container\"]/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/div/input";
    String portfolioItemDescription = "//*[@id=\"react-container\"]/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/div/textarea";
    String portfolioItemLink = "//*[@id=\"react-container\"]/div/div[2]/div[1]/form/div[1]/div/div[3]/div/div[2]/div/input";
    String createPortfolioItemBtn = "//*[@id=\"react-container\"]/div/div[2]/div[1]/form/div[2]/div/div/div/div/button[2]";







    public void goToSite(String url){
        driver.get(url);
    }

    public void logIn(String username, String password){
        driver.findElement(By.xpath(usernameField)).sendKeys(username);
        driver.findElement(By.xpath(passwordField)).sendKeys(password);
        driver.findElement(By.xpath(loginButton)).click();

    }

    public void goContentMarketSection(String section){
        driver.findElement(By.xpath(contentMarketTab)).click();
        driver.findElement(By.xpath(section)).click();
        //create wait condition and compere values
    }

    public void compareText(String webElement, String text){
        String titleText = driver.findElementByXPath(webElement).getText();
        Assert.assertTrue(titleText.equals(text));
    }

    public String getRandomText(String text){
        int random = (int) Math.floor(Math.random() * 101);
        String result = text + random;
        return result;
    }





}
