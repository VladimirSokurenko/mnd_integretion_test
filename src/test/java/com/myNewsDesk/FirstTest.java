package com.myNewsDesk;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest extends WebDriverSetUp{

    @Test
    public void firstTest(){
        goToSite(stagingUrl);
        logIn("test3", "123123qwe");
        goProfile();
    }




}
