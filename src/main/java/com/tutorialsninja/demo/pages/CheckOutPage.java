package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    WebElement checkOutText;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement newCustomerText;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestCheckOut;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    WebElement firstName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    WebElement lastName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-email']")
    WebElement email;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-telephone']")
    WebElement telephone;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    WebElement address1;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-city']")
    WebElement city;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    WebElement postcode;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement country;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement region;

    @CacheLookup
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement comments;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement agree;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continueButtonLast;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-warning alert-dismissible']")
    WebElement warningText;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement guestContinueButton;


    public void clickOnLastContinueCheckOutButton() {
        clickOnElement(continueButtonLast);
    }

    public String getCheckOutText() {
        return getTextFromElement(checkOutText);
    }

    public String getNewCustomerText() {
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckOut() {
        clickOnElement(guestCheckOut);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public void enterFirstName(String firstNme) {
        sendTextToElement(firstName, firstNme);
    }

    public void enterLastName(String name) {
        sendTextToElement(lastName, name);
    }

    public void enterEmail(String value) {
        sendTextToElement(email, value);
    }

    public void enterPhoneNumber(String value) {
        sendTextToElement(telephone, value);
    }

    public void enterAddress1(String value) {
        sendTextToElement(address1, value);
    }

    public void enterCity(String value) {
        sendTextToElement(city, value);
    }

    public void enterPostCode(String value) {
        sendTextToElement(postcode, value);
    }

    public void selectCountry(String value) {
        selectByVisibleTextFromDropDown(country, value);
    }

    public void selectRegion(String value) {
        selectByVisibleTextFromDropDown(region, value);
    }

    public void clickOnGuestContinue() {
        clickOnElement(guestContinueButton);
    }

    public void enterComments(String value) {
        sendTextToElement(comments, value);
    }

    public void clickOnAgree() {
        clickOnElement(agree);
    }

    public String getPaymentWarningText() {
        return getTextFromElement(warningText);
    }

}
