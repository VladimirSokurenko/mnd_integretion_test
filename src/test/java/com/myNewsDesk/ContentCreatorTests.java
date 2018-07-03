package com.myNewsDesk;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContentCreatorTests extends ContentCreatorSetUp {

    @Test
    public void getCMProfile(){
        goToSite(stagingUrl);
        logIn("test3", "123123qwe");
        goContentMarketSection(profileSelector);
        driver.findElement(By.xpath(profileHeading));
        compareText(profileHeading,"Your portfolio page");
        compareText(profileAboutTitle, "About me");
        compareText(prfileServiceTitle, "Service");
        compareText(profileExpertiseTitle, "Expertise");
        compareText(profileLanguageTitle, "Language");
        compareText(profileProtfolio, "Portfolio");
        driver.quit();

    }

    @Test
    public void viewAsVisitor(){
        goToSite(stagingUrl);
        logIn("test3", "123123qwe");
        goContentMarketSection(profileSelector);
        driver.findElementByXPath(viewAsVisitorBtn).click();
        compareText(viewAsVisitorHeading, "Portfolio");
        compareText(profileAboutTitle, "About me");
        compareText(prfileServiceTitle, "Service");
        compareText(profileExpertiseTitle, "Expertise");
        compareText(profileLanguageTitle, "Language");
        compareText(profileProtfolio, "Portfolio");
        driver.findElementByXPath(profileBackBtn).click();
        driver.quit();

    }

    @Test
    public void editProfileInfo(){
        goToSite(stagingUrl);
        logIn("test3", "123123qwe");
        goContentMarketSection(profileSelector);
        driver.findElementByXPath(editProfileBtn).click();
        driver.findElementByXPath(nameField).clear();
        String randomName = getRandomText("name");
        driver.findElementByXPath(nameField).sendKeys(randomName);
        driver.findElementByXPath(titleField).clear();
        String randomTitle = getRandomText("title");
        driver.findElementByXPath(titleField).sendKeys(randomTitle);
        driver.findElementByXPath(aboutFiled).clear();
        String randomAbout = getRandomText("about");
        driver.findElementByXPath(aboutFiled).sendKeys(randomAbout);
        driver.findElementByXPath(saveProfileBtn).click();
        compareText(profileName, randomName);
        compareText(profileTitle,randomTitle);
        compareText(profileAbout, randomAbout);
        driver.quit();
    }

    @Test
    public void createPortfolioItem(){
        goToSite(stagingUrl);
        logIn("test3", "123123qwe");
        goContentMarketSection(profileSelector);
        driver.findElementByXPath(addProjectBtn).click();
        String randomTitle = getRandomText("Portfolio Item");
        driver.findElementByXPath(portfolioItemTitle).sendKeys(randomTitle);
        String randomDescription = getRandomText("Description");
        driver.findElementByXPath(portfolioItemDescription).sendKeys(randomDescription);
        driver.findElementByXPath(portfolioItemLink).sendKeys("https://www.codecademy.com");
        driver.findElementsByXPath(createPortfolioItemBtn);
        //create scroll method
        driver.findElementByXPath(createPortfolioItemBtn).click();

    }




}
