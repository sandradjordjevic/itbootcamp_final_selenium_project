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
}
