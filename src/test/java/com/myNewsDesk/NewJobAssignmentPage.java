package com.myNewsDesk;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import javax.swing.*;

public class NewJobAssignmentPage {

    WebDriver driver;

    public NewJobAssignmentPage(WebDriver driver){

        this.driver = driver;

    }

    @FindBy(name = "title")
    @CacheLookup
    WebElement titleField;

    @FindBy(xpath = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/form/div[2]/div/div[2]/div/textarea")
    @CacheLookup
    WebElement descriptionField;

    @FindBy(how=How.ID, using = "react-select-4--value")
    @CacheLookup
    WebElement serviceTagInput;

    @FindBy(how=How.XPATH, using = "//*[@id=\"react-select-4--option-0\"]")
    @CacheLookup
    WebElement prContentTag;

    @FindBy(how=How.XPATH, using = "//*[@id=\"react-select-5--value\"]/div[1]")
    @CacheLookup
    WebElement languageTagInput;

    @FindBy(how=How.XPATH, using = "//*[@id=\"react-select-5--option-0\"]")
    @CacheLookup
    WebElement swedishTag;

    @FindBy(how=How.XPATH, using = "//*[@id=\"mnd-c-select-projectScope\"]")
    @CacheLookup
    WebElement projectScopeSelector;

    @FindBy(how=How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/form/div[5]/div[1]/div/div/div[2]/div/ul/li[3]/button")
    @CacheLookup
    WebElement contentRewriteScope;

    @FindBy(how=How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/form/div[5]/div[1]/div/div/div[2]/div/ul/li[5]/button")
    @CacheLookup
    WebElement otherScope;

    @FindBy(how=How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/form/div[5]/div[1]/div[2]/div/div[2]/div/input")
    @CacheLookup
    WebElement customScopeField;

    @FindBy(how=How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/form/div[5]/div[2]/div/div/div/div[2]/div/div/div/input")
    @CacheLookup
    WebElement deadlineField;

    @FindBy(how=How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/div[2]/div/form/div[5]/div[2]/div/div/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[5]/div[1]")
    @CacheLookup
    WebElement futureDateButton;  //xpath of this element should be changed after fix of the invalid date issue

    @FindBy(how=How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/footer/div[2]/button")
    @CacheLookup
    WebElement btnPostAssignment;

    @FindBy(how=How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/footer/div[2]/a")
    @CacheLookup
    WebElement btnCancel;

    @FindBy(how=How.XPATH, using = "//*[@id=\"react-container\"]/div/div[2]/div[1]/footer/div[2]/a")
    @CacheLookup
    WebElement linkContactCM;


    public void fillInJobTitle(String text){
        titleField.sendKeys(text);
    }

    public void fillInJobDescription(String text){
        descriptionField.sendKeys(text);
    }

    public void clickOnTheServiceSelector(){
        serviceTagInput.click();
    }

    public void selectPrContentTag(){
        prContentTag.click();
    }

    public void clickOnTheLanguageSelector(){ languageTagInput.click(); }

    public void selectSwedishLanguage(){
        swedishTag.click();
    }

    public void clickOnTheScopeSelector(){
        projectScopeSelector.click();
    }

    public void selectContentRewriteItem(){
        contentRewriteScope.click();
    }

    public void clickOnTheDeadlineField(){
        deadlineField.click();
    }

    public void selectFutureDate(){
        futureDateButton.click();
    }

    public void clickCreateBtn() throws InterruptedException{

        WebElement element = btnPostAssignment;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        element.click();
    }

    public void clickCancelBtn(){ btnCancel.click(); }

    public void clickContactCMLink(){linkContactCM.click();}

}
