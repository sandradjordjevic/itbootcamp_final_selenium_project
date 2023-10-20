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
        navPage.clickOnTheLogOutButton();
    }
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes () throws InterruptedException {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnTheLoginButton();
        loginPage.login(email, password);
        navPage.clickOnTheMyProfileButton();
        profilePage.waitForTheDialogToBeInvisible();
        Assert.assertTrue(profilePage.getAttributeTypeFromInputEmail().equals("email"),
                "Input email should have email type");
        Assert.assertTrue(profilePage.getAttributeDisabledFromInputEmail().equals("disabled"),
                "Input email should be disabled");
        Assert.assertTrue(profilePage.getAttributeTypeFromInputName().equals("text"),
                "Input name should have text type");
        Assert.assertTrue(profilePage.getAttributeTypeFromInputCity().contains("text"),
                "Input city should have text type");
        Assert.assertTrue(profilePage.getAttributeTypeFromInputCountry().contains("text"),
                "Input country should have text type");
        Assert.assertTrue(profilePage.getAttributeTypeFromInputTwitter().contains("url"),
                "Input twitter should have url type");
        Assert.assertTrue(profilePage.getAttributeTypeFromInputGitHub().contains("url"),
                "Input github should have url type");
        Assert.assertTrue(profilePage.getAttributeTypeFromInputPhone().contains("tel"),
                "Input phone should have tel type");
        navPage.clickOnTheLogOutButton();
    }
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void editsProfile () {
        String email = "admin@admin.com";
        String password = "12345";
        String name = "Mika Mikic";
        String phone = "+38161283223";
        String city = "Bucaramanga";
        String twitter = "https://twitter.com/profile/milan1232";
        String gitHub = "https://github.com";

        navPage.clickOnTheLoginButton();
        loginPage.login(email, password);
        navPage.clickOnTheMyProfileButton();
        profilePage.waitForTheDialogToBeInvisible();
        profilePage.clearAndTypeInputName(name);
        profilePage.clearAndTypeInputPhone(phone);
        profilePage.clearAndTypeInputCity(city);
        profilePage.clearAndTypeInputTwitter(twitter);
        profilePage.clearAndTypeInputGitHub(gitHub);
        profilePage.clickOnTheSaveButton();
        messagePopUpPage.waitForSuccessPopUpMessage();
        Assert.assertTrue(messagePopUpPage.getTheTextFromSuccessPopMessage("Profile saved successfuly"));
        navPage.clickOnTheLogOutButton();
    }
}
