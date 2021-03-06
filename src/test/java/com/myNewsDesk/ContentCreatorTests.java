package com.myNewsDesk;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ContentCreatorTests extends ContentCreatorSetUp {

    @Test
    public void getCMProfile(){
        goToSite(stagingUrl);
        logIn("test3", "123123qwe");
        goContentMarketSection(profileSelector);
        driver.findElement(By.xpath(profileSectionHeading));
        compareText(profileSectionHeading,"Your portfolio page");
        compareText(profileAboutTitle, "About me");
        compareText(profileServiceTitle, "Service");
        compareText(profileExpertiseTitle, "Expertise");
        compareText(profileLanguageTitle, "Language");
        compareText(profilePortfolio, "Portfolio");
        driver.quit();

    }

    @Test
    public void getCMAbout(){
        goToSite(stagingUrl);
        logIn("test3", "123123qwe");
        goContentMarketSection(aboutSelector);
        driver.findElementByXPath(aboutSectionHeading);
        compareText(aboutSectionHeading,"About Content Market");
        driver.quit();
    }

    @Test
    public void getCMAssignments(){
        goToSite(stagingUrl);
        logIn("test3", "123123qwe");
        goContentMarketSection(assignmentsSelector);
        driver.findElementByXPath(assignmentsSectionHeading);
        compareText(assignmentsSectionHeading,"Available assignments");
        driver.findElementByXPath(selectServiceFilter);
        driver.findElementByXPath(selectLanguageFilter);
        driver.quit();
    }

    @Test
    public void subNavigationInteraction(){
        goToSite(stagingUrl);
        logIn("test3", "123123qwe");
        goContentMarketSection(assignmentsSelector);
        driver.findElementByXPath(assignmentsSectionHeading);
        compareText(assignmentsSectionHeading,"Available assignments");
        driver.findElementByXPath(profileSubNavigation).click();
        driver.findElementByXPath(profileSectionHeading);
        compareText(profileSectionHeading,"Your portfolio page");
        driver.findElementByXPath(aboutSubNavigation).click();
        driver.findElementByXPath(aboutSectionHeading);
        compareText(aboutSectionHeading,"About Content Market");
        driver.findElementByXPath(profileSubNavigation).click();
        driver.findElementByXPath(profileSectionHeading);
        compareText(profileSectionHeading,"Your portfolio page");
        driver.findElementByXPath(assignmentsSubNavigation).click();
        driver.findElementByXPath(assignmentsSectionHeading);
        compareText(assignmentsSectionHeading, "Available assignments");
        driver.findElementByXPath(aboutSubNavigation).click();
        driver.findElementByXPath(aboutSectionHeading);
        compareText(aboutSectionHeading,"About Content Market");
        driver.findElementByXPath(assignmentsSubNavigation).click();
        driver.findElementByXPath(assignmentsSectionHeading);
        compareText(assignmentsSectionHeading, "Available assignments");
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
        compareText(profileServiceTitle, "Service");
        compareText(profileExpertiseTitle, "Expertise");
        compareText(profileLanguageTitle, "Language");
        compareText(profilePortfolio, "Portfolio");
        driver.findElementByXPath(profileBackBtn);
        driver.findElementByXPath(profileBackBtn).click();
        driver.findElementByXPath(profileSectionHeading);
        compareText(profileSectionHeading, "Your portfolio page");
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
    public void createPortfolioItem() throws InterruptedException {
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
        scrollToElement(createPortfolioItemBtn);
        driver.findElementByXPath(createPortfolioItemBtn).click();
        compareText(portfolioItemCardTitle, randomTitle);
        compareText(portfolioItemCardDescription, randomDescription);
        scrollToElement(portfolioIemCard);
        driver.findElementByXPath(portfolioIemCard).click();
        compareText(viewPITitle, randomTitle);
        compareText(viewPIDescription, randomDescription);
        compareText(viewPILink, "https://www.codecademy.com");
        driver.quit();

    }

    @Test
    public void editPortfolioItem() throws InterruptedException {
        goToSite(stagingUrl);
        logIn("test3", "123123qwe");
        goContentMarketSection(profileSelector);
        createPortfolioItem("title", "description", "www.test.com");
        scrollToElement(portfolioIemCard);
        driver.findElementByXPath(editPIBtn).click();
        driver.findElementByXPath(portfolioItemTitle).clear();
        String randomTitle = getRandomText("Edited portfolio Item");
        driver.findElementByXPath(portfolioItemTitle).sendKeys(randomTitle);
        driver.findElementByXPath(portfolioItemDescription).clear();
        String randomDescription = getRandomText("Edited Description");
        driver.findElementByXPath(portfolioItemDescription).sendKeys(randomDescription);
        driver.findElementByXPath(portfolioItemLink).clear();
        driver.findElementByXPath(portfolioItemLink).sendKeys("https://java.com");
        scrollToElement(savePortfolioItemBtn);
        driver.findElementByXPath(savePortfolioItemBtn).click();
        scrollToElement(portfolioIemCard);
        compareText(portfolioItemCardTitle, randomTitle);
        compareText(portfolioItemCardDescription, randomDescription);
        driver.findElementByXPath(portfolioIemCard).click();
        compareText(viewPITitle, randomTitle);
        compareText(viewPIDescription, randomDescription);
        compareText(viewPILink, "https://java.com");
        driver.quit();

    }

    @Test
    public void deletePortfolioItem() throws InterruptedException {
        goToSite(stagingUrl);
        logIn("test3", "123123qwe");
        goContentMarketSection(profileSelector);
        createPortfolioItem("title", "description", "www.test.com");
        scrollToElement(portfolioIemCard);
        driver.findElementByXPath(editPIBtn).click();
        scrollToElement(deletePIBtn);
        driver.findElementByXPath(deletePIBtn).click();
        driver.findElementByXPath(deletePIPopUpYesBtn).click();
        driver.quit();

    }

    @Test
    public void getPublicCCProfile() throws InterruptedException {
        driver.get("https://www.mnd-staging-sloboda.com/market/profile/6");
        compareText(publicProfileHeading, "Portfolio");
        compareText(publicAboutTitle, "About me");
        compareText(publicLanguageTitle, "Language");
        compareText(publicPortfolioHeading, "Portfolio");
        WebElement element = driver.findElementByXPath(publicPortfolioItemCard);
        if(element.isDisplayed() == true){
            element.click();
        }else {
            System.out.println("Element is not visible");
        }
        driver.quit();
    }

    @Test
    public void getUnsubscribePage() throws InterruptedException {
        String userHash = "4cd34ce8cb8171f9ea1ac8022af0786e7bd6d5a97a4f1820e8c2765092731588";
        driver.get("http://www.mnd-staging-sloboda.com/market/unsubscribe/" + userHash);
        WebElement element = driver.findElementByXPath(unsubscribeCard);
        element.isDisplayed();
        compareText(unsubscribeCardHeading, "Unsubscribe from assignments");
        WebElement element1 = driver.findElementByXPath(unsubscribeCardStoriesBtn);
        element1.isDisplayed();
        element1.click();
        WebElement element2 = driver.findElementByXPath("//*[@id=\"main\"]/section/div/header/h1");
        element2.isDisplayed();
        compareText("//*[@id=\"main\"]/section/div/header/h1","News on your terms");
        driver.quit();
    }

    @Test
    public void uploadProfileAvatar() throws InterruptedException {
        goToSite(stagingUrl);
        logIn("test3", "123123qwe");
        goContentMarketSection(profileSelector);
        driver.findElementByXPath(editProfileBtn).click();
        uploadAvatarImage("/home/alexander/IdeaProjects/my_first_test/images/avatar.jpg");
        uploadCoverImage("/home/alexander/IdeaProjects/my_first_test/images/coverImage.jpg");
        scrollToElement(saveProfileBtn);
        Thread.sleep(8000);
        driver.findElementByXPath(saveProfileBtn).click();
        driver.findElementByXPath(editProfileBtn).click();
        driver.findElementByXPath(removeAvatarBtn).click();


    }














}
