package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility {
    @CacheLookup
    @FindBy(xpath ="//h1[normalize-space()='Register Account']")
    WebElement registerAccount;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement accountCreatedText;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstName;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastName;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement telephone;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement confirmPassword;
    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement agree;
    @CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueButton2;

    public String getRegisterAccountText() {
        return getTextFromElement(registerAccount);
    }

    public void enterFirstName(String firstNme) {
        sendTextToElement(firstName, firstNme);
    }

    public void enterLastName(String value) {
        sendTextToElement(lastName, value);
    }

    public void enterEmail(String value) {
        sendTextToElement(email, value);
    }

    public void enterPhoneNumber(String value) {
        sendTextToElement(telephone, value);
    }

    public void enterPassword(String value) {
        sendTextToElement(password, value);
    }

    public void enterConfirmPassword(String value) {
        sendTextToElement(confirmPassword, value);
    }


    public void selectSubscribeButton(String value) {
        clickOnElement(By.xpath("//label[normalize-space()='" + value + "']"));
    }

    public void clickOnAgree() {
        clickOnElement(agree);
    }

    public void clickOnContinue() {
        clickOnElement(continueButton);
    }
    public void clickOnContinueAfterCreation() {
        clickOnElement(continueButton2);
    }

    public String getAccountCreatedText() {
        return getTextFromElement(accountCreatedText);
    }

}
