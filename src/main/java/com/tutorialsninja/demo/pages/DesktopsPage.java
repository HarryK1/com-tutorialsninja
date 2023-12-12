package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utility {

    String product;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopText;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    WebElement allProductName;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement NameAToZ;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement HP3065;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement textHPLP3065;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement calendarButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthYear;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    WebElement nextSign;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement dates;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement quantity;

    By qty = By.xpath("//input[@id='input-quantity']");

    @CacheLookup
    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
    WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement shoppingCart;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productHPLp3065;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;

    @CacheLookup
    @FindBy(xpath = "//td[normalize-space()='Product 21']")
    WebElement product21;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalPrice;

    public String getDeskTopText() {
        return getTextFromElement(desktopText);
    }

    public void sortByNameAToZ(String text) {
        selectByVisibleTextFromDropDown(NameAToZ, text);
    }

    public void allProduct(String product) {
        clickOnElement(By.xpath("//a[normalize-space()='" + product + "']"));
    }


    public void updateQuantity(String value) {
        clearTextFromField(quantity, value);
    }

    private void clearTextFromField(WebElement quantity, String value) {
    }

    public String getSuccessText() {
        return getTextFromElement(successMessage);
    }

    public void addToCart() {
        clickOnElement(addToCart);
    }

    public void clickOnShoppingCart() {
        //waitUntilVisibilityOfElementLocated(shoppingCart, 20);
        clickOnElement(shoppingCart);
    }

    public String getShoppingCartText() {
        return getTextFromElement(shoppingCartText);
    }

    public String verifyDeliveryDate() {
        return getTextFromElement(deliveryDate);
    }

    public String verifyShoppingCartText() {
        return getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
    }

    public String verifyProductName(String productname) {
        return getTextFromElement(By.xpath("(//a[contains(text(),'" + productname + "')])[2]"));
    }

    public String verifyModel(String productmodel) {
        return getTextFromElement(By.xpath("//td[normalize-space()='" + productmodel + "']"));
    }

    public String verifyTotal() {
        //waitUntilVisibilityOfElementLocated(totalPrice, 20);
        return getTextFromElement(totalPrice);
    }

    public void selectDate(String day, String month, String year) {
        clickOnElement(calendarButton);
        while (true) {
            String monAndYear = getTextFromElement(monthYear);
            String[] a = monAndYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextSign);
            }
        }
        List<WebElement> dateList = getListOfElements(dates);
        for (WebElement list : dateList) {
            if (list.getText().equalsIgnoreCase(day)) {
                list.click();
                break;
            }
        }
    }

    private List<WebElement> getListOfElements(WebElement dates) {
        return null;
    }

    public ArrayList<String> getProductList() {
        List<WebElement> originalProductsName = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName1 = new ArrayList<>();
        for (WebElement e : originalProductsName) {
            originalProductsName1.add(e.getText());
        }
        Collections.sort(originalProductsName1);
        Collections.reverse(originalProductsName1);
        return originalProductsName1;
    }

    public ArrayList<String> getProductList1() {
        List<WebElement> afterFilterProductList = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterFilterProductList1 = new ArrayList<>();
        for (WebElement e : afterFilterProductList) {
            afterFilterProductList1.add(e.getText());
        }
        Collections.sort(afterFilterProductList1);
        Collections.reverse(afterFilterProductList1);
        return afterFilterProductList1;
    }

}
