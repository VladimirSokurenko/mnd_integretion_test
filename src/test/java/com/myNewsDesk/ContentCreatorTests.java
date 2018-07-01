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


    }




}
