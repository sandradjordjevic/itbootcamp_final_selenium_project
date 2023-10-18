package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LoginTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheLoginPage () {
        navPage.clickOnTheLanguageSelectionButton();
        navPage.waitForTheListFromLanguageSelectionButtonToBeVisible();
        navPage.selectEnglishLanguage();
        navPage.clickOnTheLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login",
                "Current URL should contain 'login'.");
    }
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes () {
        navPage.clickOnTheLoginButton();
        Assert.assertEquals(loginPage.getAttributeTypeForEmailInput(),
                "email",
                "Attribute type for the email input should have the value 'email'.");
        Assert.assertEquals(loginPage.getAttributeTypeForPasswordInput(),
                "password",
                "Attribute type for the password input should have the value 'password'.");
    }
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserDoesNotExist () {
        String email = "non-existing-user@gmal.com";
        String password = "password123";

        navPage.clickOnTheLoginButton();
        loginPage.login(email, password);
        messagePopUpPage.waitForThePopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getTheTextFromPopUpMessage(),
                "User does not exists",
                "Pop up message when credential are wrong should be 'User does not exist'.");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login",
                "Current URL should contain '/login'.");
    }
    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenPasswordIsWrong () {
        String email = "admin@admin.com";
        String password = "password123";

        navPage.clickOnTheLoginButton();
        loginPage.login(email, password);
        messagePopUpPage.waitForThePopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getTheTextFromPopUpMessage(),
                "Wrong password",
                "Pop up message when password is wrong should be 'Wrong password'.");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login",
                "Current URL should contain 'login'.");
    }
    @Test (priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void login () throws InterruptedException {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnTheLoginButton();
        loginPage.login(email, password);
        wait    .withMessage("Current URL should contain 'home'.")
                .until(ExpectedConditions.urlToBe(baseUrl + "/home"));
    }
    @Test (priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void logout () throws InterruptedException {
        login();
        navPage.waitForTheLogoutButtonToBeVisible();
        loginPage.clickOnLoginButton();
    }
}
