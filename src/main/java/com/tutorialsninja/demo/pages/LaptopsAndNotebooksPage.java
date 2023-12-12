package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopAndNotebooksText;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortByHighToLow;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBook;


    public String getTextLaptopAndNotebook() {
        return getTextFromElement(laptopAndNotebooksText);
    }

    public List<Double> beforeSortPriceHighToLow() {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        return originalProductsPrice;
    }

    public List<Double> afterSortPriceHighToLow() {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        // After filter Price (High > Low) Get all the products price and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        return afterSortByPrice;
    }
    public void sortByFilter(String value) {
        selectByVisibleTextFromDropDown(sortByHighToLow, value);
    }
    public void clickOnMacBook(){
        clickOnElement(macBook);
    }


}
