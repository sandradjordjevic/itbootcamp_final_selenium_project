package tests;

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
                baseUrl + "login",
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
        messagePopUpPage.waitForThePopUpToBeVisibleWhenCredentialAreWrong();
        Assert.assertEquals(messagePopUpPage.getTheTextFromPopUpMessageWhenCredentialAreWrong(),
                "User does not exists",
                "Pop up message when credential are wrong should be 'User does not exist'.");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Current URL should contain 'login'.");
    }
}
