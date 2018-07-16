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
import org.openqa.selenium.support.PageFactory;

public class PressOfficerTests extends ContentCreatorSetUp {



    @Test
    public void loginAsPressOfficer(){
        LoginPage loginPage = new LoginPage(driver);
        PressroomPage pressroomPage = new PressroomPage(driver);
        MainNavigationMenuPage mainNavigationMenuPage = new MainNavigationMenuPage(driver);
        JobAssignmnetsPage jobAssignmnetsPage = new JobAssignmnetsPage(driver);

        goToSite(stagingUrl);
        loginPage.typeUsername("pressofficer3");
        loginPage.typePassword("123123qwe");
        loginPage.clickLoginButton();
        pressroomPage.navigateToFirstPressroom();
        mainNavigationMenuPage.clickOnContentMarketTab();
        mainNavigationMenuPage.navigateToAssignmentsPage();
        jobAssignmnetsPage.verifyHeadingText("Assignments");
        driver.quit();

    }

    @Test
    public void createJobAssignment() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        PressroomPage pressroomPage = new PressroomPage(driver);
        MainNavigationMenuPage mainNavigationMenuPage = new MainNavigationMenuPage(driver);
        JobAssignmnetsPage jobAssignmnetsPage = new JobAssignmnetsPage(driver);

        goToSite(stagingUrl);
        loginPage.typeUsername("pressofficer3");
        loginPage.typePassword("123123qwe");
        loginPage.clickLoginButton();
        pressroomPage.navigateToFirstPressroom();
        mainNavigationMenuPage.clickOnContentMarketTab();
        mainNavigationMenuPage.navigateToAssignmentsPage();
        jobAssignmnetsPage.createJobAssignmanet();

        NewJobAssignmentPage newJobAssignmentPage = PageFactory.initElements(driver, NewJobAssignmentPage.class);
        newJobAssignmentPage.clickOnTheServiceSelector();
        newJobAssignmentPage.selectPrContentTag();
        newJobAssignmentPage.fillInJobTitle("This is title number: ");
        newJobAssignmentPage.clickOnTheLanguageSelector();
        newJobAssignmentPage.selectSwedishLanguage();
        newJobAssignmentPage.fillInJobDescription("This is description number: ");
        newJobAssignmentPage.clickOnTheScopeSelector();
        newJobAssignmentPage.selectContentRewriteItem();
        newJobAssignmentPage.clickOnTheDeadlineField();
        newJobAssignmentPage.selectFutureDate();
        newJobAssignmentPage.clickCreateBtn();
        driver.quit();


    }




}
