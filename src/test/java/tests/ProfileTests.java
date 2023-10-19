package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class ProfileTests extends BasicTest{
    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheProfilePage () throws InterruptedException {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnTheLoginButton();
        loginPage.login(email, password);
        navPage.clickOnTheMyProfileButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/profile",
                "User should be redirected on profile page");
        profilePage.waitForTheDialogToBeInvisible();
        Assert.assertEquals(email,
                profilePage.getAttributeValueFromInputEmail());
    }
}
