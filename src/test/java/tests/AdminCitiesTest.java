package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AdminCitiesTest extends BasicTest{
    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheAdminCitiesPageAndListCities () {
        String adminEmail = "admin@admin.com";
        String adminPassword = "12345";

        navPage.clickOnTheLoginButton();
        loginPage.login(adminEmail, adminPassword);
        navPage.clickOnTheAdminButton();
        navPage.waitForTheListFromAdminButtonToBeVisible();
        navPage.clickOnTheCitiesLinkFromAdminList();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/admin/cities",
                "User should be redirected on the Cities page.");
    }
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypesForCreateOrEditNewCity () {
        navPage.clickOnTheAdminButton();
        navPage.waitForTheListFromAdminButtonToBeVisible();
        navPage.clickOnTheCitiesLinkFromAdminList();
        citiesPage.clickOnTheNewItemButton();
        citiesPage.waitForNewItemDialogToBeVisible();
        Assert.assertEquals(citiesPage.getAttributeTypeForInputFromNewItemDialog(),
                "text",
                "Attribute type for input from PopUp message after clicking on New Item button should be 'text'");
    }
}
