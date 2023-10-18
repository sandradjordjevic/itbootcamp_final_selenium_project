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
}
