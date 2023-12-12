package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//small[normalize-space()='Delivery Date:2023-11-27']")
    WebElement deliveryDateText;

    @CacheLookup
    @FindBy(xpath = "//td[normalize-space()='Product 21']")
    WebElement modelText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalText;

    @CacheLookup
    @FindBy(xpath = "(//a[contains(text(),'MacBook')])[2]")
    WebElement macBookText;

    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-refresh']")
    WebElement updateButton;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name,'quantity')]")
    WebElement quantity;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successText;

    @CacheLookup
    @FindBy(xpath = "//td[@class='text-right'][normalize-space()='$122.00'])[4]")
    WebElement priceText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement mackBookPriceText;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkOut;

    public String getShoppingCartText() {
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        return getTextFromElement(productName);
    }

    public String getDeliveryDateText() {
        return getTextFromElement(deliveryDateText);
    }

    public String getModelText() {
        return getTextFromElement(modelText);
    }

    public String getTotalText() {
        return getTextFromElement(totalText);
    }

    public String getMacBookText() {
        return getTextFromElement(macBookText);
    }

    public void updateQuantity(String value) {
        clearTextFromField(quantity,"value");
    }

    private void clearTextFromField(WebElement quantity, String value) {
    }

    public void clickOnUpdateButton() {
        clickOnElement(updateButton);
    }

    public String getSuccessText() {
        return getTextFromElement(successText);
    }

    public String getMackBookPriceText() {
        return getTextFromElement(mackBookPriceText);
    }

    public void clickOnCheckOutButton() {
        clickOnElement(checkOut);
    }
}
