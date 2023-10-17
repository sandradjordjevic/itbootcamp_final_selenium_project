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
}
