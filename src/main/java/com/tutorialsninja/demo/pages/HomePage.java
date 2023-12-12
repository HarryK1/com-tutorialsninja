package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    WebElement topMenu;

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktop;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopNotebooks;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement components;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Account Logout']")
    WebElement accountLogout;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccount;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    WebElement myAccountOptions;

    @CacheLookup
    @FindBy(xpath = "//span[@class='caret']")
    WebElement myAccountAfterLogin;

    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-caret-down']")
    WebElement currency;

    @CacheLookup
    @FindBy(xpath = "//button[@name='GBP' and contains(text(), '£Pound Sterling')]")
    WebElement pound;


    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements((By) topMenu);
        }
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }
    public void mouseHoverOnDesktop(){
        mouseHoverToElementAndClick(desktop);
    }
    public void mouseHoverAndClickOnAllShowAllDesktop(String menu){
        selectMenu(menu);
    }
    public void mouseHoverOnLaptopsAndNotebooks(){
        mouseHoverToElementAndClick(laptopNotebooks);
    }
    public void mouseHoverOnShowAllLaptopsAndNotebooks(String menu){
        selectMenu(menu);
    }
    public void mouseHoverOnComponents()
    {
        mouseHoverToElementAndClick(components);
    }
    public void clickOnShowAllComponents(String menu)
    {
        selectMenu(menu);
    }
    public String getAccountLogoutText() {
        return getTextFromElement(accountLogout);
    }
    public void clickOnMyAccountLink(){
        clickOnElement(myAccount);
    }
    public void clickOnMyAccountAfterLogin(){
        clickOnElement(myAccountAfterLogin);
    }
    public void mouseHoverOnCurrencyDropDown(){
        mouseHoverToElementAndClick(currency);
    }
    public void mouseHoverAndClickOnPoundSterling(){
        mouseHoverToElementAndClick(pound);
    }
}
