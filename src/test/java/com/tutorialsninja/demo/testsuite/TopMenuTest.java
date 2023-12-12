package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.ComponentsPage;
import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class TopMenuTest extends TestBase {
    HomePage homePage = new HomePage();
    DesktopsPage desktopPage = new DesktopsPage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ComponentsPage componentsPage = new ComponentsPage();

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        componentsPage = new ComponentsPage();
        desktopPage = new DesktopsPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverOnDesktop();
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        homePage.mouseHoverAndClickOnAllShowAllDesktop("Show AllDesktops");
        //1.3 Verify the text ‘Desktops’
        Assert.assertEquals(desktopPage.getDeskTopText(), "Desktops");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverOnLaptopsAndNotebooks();
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.mouseHoverOnShowAllLaptopsAndNotebooks("Show AllLaptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals(laptopsAndNotebooksPage.getTextLaptopAndNotebook(), "Laptops & Notebooks");
    }

    @Test(groups = "regression")
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        homePage.mouseHoverOnComponents();
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        homePage.clickOnShowAllComponents("Show AllComponents");
        //3.3 Verify the text ‘Components’
        Assert.assertEquals(componentsPage.getComponentText(), "Components");
    }
}
