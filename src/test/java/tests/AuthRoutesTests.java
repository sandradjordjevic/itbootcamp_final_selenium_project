package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AuthRoutesTests extends BasicTest{
    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated () {
        driver.navigate().to(baseUrl + "/home");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login",
                "The user should stay on the login page");
    }
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated () {
        driver.navigate().to(baseUrl + "/profile");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login",
                "The user should stay on the login page");
    }
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated () {
        driver.navigate().to(baseUrl + "/admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login",
                "The user should stay on the login page");
    }
    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated () {
        driver.navigate().to(baseUrl + "/admin/users");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login",
                "The user should stay on the login page");
    }
}
