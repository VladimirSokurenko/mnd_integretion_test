package com.myNewsDesk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainNavigationMenuPage {

    WebDriver driver;

    By contentMarketTab = By.xpath("//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[4]/div/span");
    By dropdownItemContentCreators = By.xpath("//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[4]/div/div/div/a[1]");
    By dropdownItemAssignments = By.xpath("//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[4]/div/div/div/a[2]");
    By dropdownItemAbout = By.xpath("//*[@id=\"react-container\"]/div/div[1]/div/div/div[2]/ol/li[4]/div/div/div/a[3]");

    public MainNavigationMenuPage(WebDriver driver){

        this.driver = driver;

    }

    public void clickOnContentMarketTab(){
        driver.findElement(contentMarketTab).click();
    }

    public void navigateToContentCreatorsPage(){
        driver.findElement(dropdownItemContentCreators).click();
    }

    public void navigateToAssignmentsPage(){
        driver.findElement(dropdownItemAssignments).click();
    }

    public void navigateToAboutPage(){
        driver.findElement(dropdownItemAbout).click();
    }
}
