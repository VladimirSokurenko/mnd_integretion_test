package com.myNewsDesk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PressroomPage {

    WebDriver driver;

    By firstPressroom = By.xpath("//*[@id=\"wrapper\"]/div/div[2]/div/section/table/tbody/tr[1]/td/a");
    By secondPressroom = By.xpath("//*[@id=\"wrapper\"]/div/div[2]/div/section/table/tbody/tr[2]/td/a");

    public PressroomPage(WebDriver driver){

        this.driver = driver;

    }

    public void navigateToFirstPressroom(){
        driver.findElement(firstPressroom).click();
    }

    public void navigateToSecondPressroom(){
        driver.findElement(secondPressroom).click();
    }

}
