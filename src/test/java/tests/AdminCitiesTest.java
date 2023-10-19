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
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void createNewCity () {
        String cityName = "New City";

        navPage.clickOnTheAdminButton();
        navPage.waitForTheListFromAdminButtonToBeVisible();
        navPage.clickOnTheCitiesLinkFromAdminList();
        citiesPage.clickOnTheNewItemButton();
        citiesPage.waitForNewItemDialogToBeVisible();
        citiesPage.clearAndTypeInputFromNewItemDialog(cityName);
        citiesPage.clickOnTheSaveButtonFromNewItemDialog();
        messagePopUpPage.waitForSuccessPopUpMessage();
        Assert.assertTrue(messagePopUpPage.getTheTextFromSuccessPopMessage("Saved successfully"),
                "PopUp message when user successfully saved new item should be 'Saved successfully'");
    }
    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void editCity () {
        String oldCityName = "New City";
        String newCityName = "New City edit";

        navPage.clickOnTheAdminButton();
        navPage.waitForTheListFromAdminButtonToBeVisible();
        navPage.clickOnTheCitiesLinkFromAdminList();
        citiesPage.clearAndTypeInSearchInput(oldCityName);
        citiesPage.waitForTheSpecifiedNumberOfRowsToBeVisible(1);
        citiesPage.clickOnTheEditButtonFromSpecificRow(1);
        citiesPage.waitForEditItemDialogToBeVisible();
        citiesPage.clearAndTypeInputFromEditItemDialog(newCityName);
        citiesPage.clickOnTheButtonSaveFromEditDialog();
        messagePopUpPage.waitForSuccessPopUpMessage();
        Assert.assertTrue(messagePopUpPage.getTheTextFromSuccessPopMessage("Saved successfully"),
                "PopUp message when user successfully saves the edited item should be 'Saved successfully'");
    }
    @Test (priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void deleteCity () {
        String cityName = "New City edit";

        navPage.clickOnTheAdminButton();
        navPage.waitForTheListFromAdminButtonToBeVisible();
        navPage.clickOnTheCitiesLinkFromAdminList();
        citiesPage.clearAndTypeInSearchInput(cityName);
        citiesPage.waitForTheSpecifiedNumberOfRowsToBeVisible(1);
        Assert.assertEquals(citiesPage.specificCellFromSpecificRow(1, 2).getText(),
                cityName,
                "In the name column of the first row it should be " + cityName);
        citiesPage.clickOnTheBinButton(1);
        citiesPage.waitForDeleteItemDialogToBeVisible();
        citiesPage.clickOnTheDeleteButtonFromDeleteDialog();
        messagePopUpPage.waitForSuccessPopUpMessage();
        Assert.assertTrue(messagePopUpPage.getTheTextFromSuccessPopMessage("Deleted successfully"),
                "PopUp message when user successfully deletes an item should be 'Deleted successfully'");
    }
}
