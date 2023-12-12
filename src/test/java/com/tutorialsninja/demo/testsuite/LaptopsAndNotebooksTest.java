package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.UUID;

@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksTest extends TestBase {

    HomePage homePage;
    LaptopsAndNotebooksPage laptopAndBookPage;
    MacBookPage macBook;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        laptopAndBookPage = new LaptopsAndNotebooksPage();
        shoppingCartPage = new ShoppingCartPage();
        checkOutPage = new CheckOutPage();
        macBook = new MacBookPage();
    }

    @Test(groups = {"sanity","smoke", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverOnLaptopsAndNotebooks();
        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.mouseHoverOnShowAllLaptopsAndNotebooks("Show AllLaptops & Notebooks");
        //1.3 Select Sort By "Price (High > Low)"
        laptopAndBookPage.sortByFilter("Name (A - Z)");
        //1.4 Verify the Product price will arrange in High to Low order.
        String exceptedMessage = laptopAndBookPage.beforeSortPriceHighToLow().toString();
        String actualMessage = laptopAndBookPage.afterSortPriceHighToLow().toString();
        Assert.assertEquals(actualMessage, exceptedMessage);
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() {

        homePage.mouseHoverOnCurrencyDropDown();
        homePage.mouseHoverAndClickOnPoundSterling();
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.mouseHoverOnLaptopsAndNotebooks();
        //2.2 Click on “Show All Laptops & Notebooks”
        homePage.mouseHoverOnShowAllLaptopsAndNotebooks("Show AllLaptops & Notebooks");
        //2.3 Select Sort By "Price (High > Low)"
        laptopAndBookPage.sortByFilter("Name (A - Z)");
        //2.4 Select Product “MacBook”
        laptopAndBookPage.clickOnMacBook();

        //2.5 Verify the text “MacBook”
        String expectedMessage = "MacBook";
        String actualMessage = macBook.getMacBookText();
        Assert.assertEquals(actualMessage, expectedMessage);

        //2.6 Click on ‘Add To Cart’ button
        macBook.clickOnAddToCart();

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedMessage2 = "Success: You have added MacBook to your shopping cart!\n";
        String actualMessage2 = macBook.getSuccessText();
        String[] actualmsg = actualMessage2.split("×");
        Assert.assertEquals(actualmsg[0], expectedMessage2);

        //2.8 Click on link “shopping cart” display into success message
        macBook.clickOnShoppingCartLink();

        //2.9 Verify the text "Shopping Cart"
        String expectedtxt3 = "Shopping Cart  (0.00kg)";
        String actualtxt3 = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(actualtxt3, expectedtxt3);

        //2.10 Verify the Product name "MacBook"
        String expectedMessage4 = "MacBook";
        String actualMessage4 = shoppingCartPage.getMacBookText();
        Assert.assertEquals(actualMessage4, expectedMessage4);


        //2.11 Change Quantity "2"
        shoppingCartPage.updateQuantity("2");

        //2.12 Click on “Update”Tab
        shoppingCartPage.clickOnUpdateButton();

       //2.13 Verify the message “Success: You have modified your shopping cart!”

        String expectedMessage1 = "Success: You have modified your shopping cart!";
        String actualMessage1 = shoppingCartPage.getSuccessText();
        boolean message1 = actualMessage1.contains(expectedMessage1.trim());
        Assert.assertTrue(message1);

        //2.14 Verify the Total £737.45
        String expectedMessage5 = "£737.45";
        String actualMessage5 = shoppingCartPage.getMackBookPriceText();
        Assert.assertEquals(actualMessage5,expectedMessage5);

        //2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckOutButton();

        //2.16 Verify the text “Checkout”
        String expectedMsg = "Checkout";
        String actualMsg = checkOutPage.getCheckOutText();
        Assert.assertEquals(actualMsg, expectedMsg);

        //2.17 Verify the Text “New Customer”
        String expectedMsg1 = "New Customer";
        String actualMsg1 = checkOutPage.getNewCustomerText();
        Assert.assertEquals(actualMsg1, expectedMsg1);

        //2.18 Click on “Guest Checkout” radio button
        checkOutPage.clickOnGuestCheckOut();

        //2.19 Click on “Continue” tab
        checkOutPage.clickOnContinueButton();

        //2.20 Fill the mandatory fields
        checkOutPage.enterFirstName("Kash");
        checkOutPage.enterLastName("Patel");
        String name = UUID.randomUUID().toString();
        String email = name + "@gmail.com";
        checkOutPage.enterEmail(email);
        checkOutPage.enterPhoneNumber("07896322975");
        checkOutPage.enterAddress1("9, High street");
        checkOutPage.enterCity("London");
        checkOutPage.enterPostCode("HA3 9AY");
        checkOutPage.selectCountry("United Kingdom");
        checkOutPage.selectRegion("Greater London");

        //2.21 Click on “Continue” Button
        checkOutPage.clickOnGuestContinue();

        //2.22 Add Comments About your order into text area
        checkOutPage.enterComments("MacBook");

        //2.23 Check the Terms & Conditions check box
        checkOutPage.clickOnAgree();

        //2.24 Click on “Continue” button
        checkOutPage.clickOnLastContinueCheckOutButton();

        //2.25 Verify the message “Warning: Payment method required!”
        String expectedMessage6 = "Warning: No Payment options are available. Please contact us for assistance!";
        String actualMessage6 = checkOutPage.getPaymentWarningText();
        Assert.assertEquals(actualMessage6, expectedMessage6);
    }

}
