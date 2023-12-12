package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility{
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement returningCustomer;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement emailId;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAccountText;

    public String getReturningCustomerText() {
        return getTextFromElement(returningCustomer);
    }

    public void enterEmailId(String value) {
        sendTextToElement(emailId, value);
    }

    public void enterPassword(String value) {
        sendTextToElement(password, value);
    }

    public void clickOnLogin() {
        clickOnElement(loginButton);
    }
    public String getMyAccountText(){
        return getTextFromElement(myAccountText);
    }

}
