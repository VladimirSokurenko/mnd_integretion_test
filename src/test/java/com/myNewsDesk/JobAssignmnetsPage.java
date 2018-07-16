package com.myNewsDesk;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
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

public class JobAssignmnetsPage extends ContentCreatorSetUp {

    WebDriver driver;

    By createAssignmentBtn = By.xpath("//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div[2]/div/div/button");
    By viewAssignmentBtn = By.xpath("//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/ul/li[1]/div[2]/div[1]/button[1]");
    By editAssignmentBtn = By.xpath("//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/ul/li[1]/div[2]/div[1]/button[2]");



    public JobAssignmnetsPage(WebDriver driver){

        this.driver = driver;

    }

    public void clickViewJobAssigmant(){
        driver.findElement(viewAssignmentBtn).click();
    }

    public void clickEditJobAssignment(){
        driver.findElement(editAssignmentBtn).click();
    }

    public void createJobAssignmanet(){
        driver.findElement(createAssignmentBtn).click();
    }

    public void verifyHeadingText(String text){
        String headingText = driver.findElement(By.xpath("//*[@id=\"react-container\"]/div/div[2]/div[1]/div[1]/div/div[1]/h1")).getText();
        Assert.assertTrue(headingText.equals(text));
    }






}
