package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class SignUpTest extends BasicTest{
    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheSignupPage () {
        navPage.clickOnTheSignUpButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "signup",
                "Current URL should contain 'signup'");
    }
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes () {
        navPage.clickOnTheSignUpButton();
        Assert.assertEquals(signupPage.getAttributeTypeForEmailInput(),
                "email",
                "Attribute type for the email input should have the value 'email'.");
        Assert.assertEquals(signupPage.getAttributeTypeForPasswordInput(),
                "password",
                "Attribute type for the password input should have the value 'password'.");
        Assert.assertEquals(signupPage.getAttributeTypeForConfirmPasswordInput(),
                "password",
                "Attribute type for the confirm password input should have the value 'password'.");
    }
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserAlreadyExists () {
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.clickOnTheSignUpButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "signup",
                "Current URL should contain 'signup'");
        signupPage.clearAndTypeNameInput(name);
        signupPage.clearAndTypeEmailInput(email);
        signupPage.clearAndTypePasswordInput(password);
        signupPage.clearAndTypeConfirmPasswordInput(confirmPassword);
        signupPage.clickOnTheSingMeUpButton();
        messagePopUpPage.waitForThePopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getTheTextFromPopUpMessage(),
                "E-mail already exists",
                "Pop up message when user alredy exist should be 'E-mail already exists'.");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "signup",
                "Current URL should contain 'signup'");

    }
}
