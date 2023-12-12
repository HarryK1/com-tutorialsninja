package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MacBookPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement macBookText;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement shoppingCartLink;

    public String getMacBookText() {
        return getTextFromElement(macBookText);
    }
    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }
    public String getSuccessText(){
        return getTextFromElement(successText);
    }
    public void clickOnShoppingCartLink(){
        clickOnElement(shoppingCartLink);
    }

}
