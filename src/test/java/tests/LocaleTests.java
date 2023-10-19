package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasicPage;
import retry.RetryAnalyzer;

public class LocaleTests extends BasicTest{
    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToES () {
        navPage.clickOnTheLanguageSelectionButton();
        navPage.waitForTheListFromLanguageSelectionButtonToBeVisible();
        navPage.selectSpanishLanguage();
        Assert.assertEquals(landingPage.getTheTextFromH1(),
                "Página de aterrizaje",
                "The heading should be in Spanish");
    }
}
