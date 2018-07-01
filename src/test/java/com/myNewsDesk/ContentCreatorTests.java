package com.myNewsDesk;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

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

    }

    @Test
    public void editProfile(){
        goToSite(stagingUrl);
        logIn("test3", "123123qwe");
        goContentMarketSection(profileSelector);
        driver.findElementByXPath(editProfileBtn).click();
        driver.findElementByXPath(nameField).clear();
        driver.findElementByXPath(nameField).sendKeys("Vova");
        driver.findElementByXPath(titleField).clear();
        driver.findElementByXPath(titleField).sendKeys("Tester");
        driver.findElementByXPath(aboutFiled).clear();
        driver.findElementByXPath(aboutFiled).sendKeys("About me test");
        driver.findElementByXPath(saveProfileBtn).click();



    }




}
