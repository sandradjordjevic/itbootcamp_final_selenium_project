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
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToEN () {
        navPage.clickOnTheLanguageSelectionButton();
        navPage.waitForTheListFromLanguageSelectionButtonToBeVisible();
        navPage.selectEnglishLanguage();
        Assert.assertEquals(landingPage.getTheTextFromH1(),
                "Landing",
                "The heading should be in English");
    }
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToCN () {
        navPage.clickOnTheLanguageSelectionButton();
        navPage.waitForTheListFromLanguageSelectionButtonToBeVisible();
        navPage.selectChineseLanguage();
        Assert.assertEquals(landingPage.getTheTextFromH1(),
                "首页",
                "The heading should be in Chinese");
    }
    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToFR () {
        navPage.clickOnTheLanguageSelectionButton();
        navPage.waitForTheListFromLanguageSelectionButtonToBeVisible();
        navPage.selectFrenchLanguage();
        Assert.assertEquals(landingPage.getTheTextFromH1(),
                "Page d'atterrissage",
                "The heading should be in French");
    }
}
