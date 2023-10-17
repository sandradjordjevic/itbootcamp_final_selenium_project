package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getTheHomeButton() {
        return driver.findElement(By.cssSelector("div.v-toolbar__items a[href='/']"));
    }
    public void clickOnTheHomeButton() {
        getTheHomeButton().click();
    }
    public WebElement getTheAboutButton() {
        return driver.findElement(By.cssSelector("div.v-toolbar__items a[href='/about']"));
    }
    public void clickOnTheAboutButton() {
        getTheAboutButton().click();
    }
    public WebElement getTheMyProfileButton () {
        return driver.findElement(By.cssSelector("div.v-toolbar__items a[href='/profile']"));
    }
    public void clickOnTheMyProfileButton () {
        getTheMyProfileButton().click();
    }
    public WebElement getTheAdminButton () {
        return driver.findElement(By.className("btnAdmin"));
    }
    public void clickOnTheAdminButton () {
        getTheAdminButton().click();
    }
    public void waitForTheListFromAdminButtonToBeVisible () {
        wait    .withMessage("After clicking on the admin button the list below should be visible.")
                .until(ExpectedConditions.visibilityOf
                        (driver.findElement
                        (By.cssSelector("div[role='menu'].menuable__content__active div.v-list"))));
    }
    public WebElement getTheCitiesLinkFromAdminList () {
        return driver.findElement(By.cssSelector("a[href='/admin/cities']"));
    }
    public void clickOnTheCitiesLinkFromAdminList () {
        getTheCitiesLinkFromAdminList().click();
    }
    public WebElement getTheUsersFromAdminList () {
        return driver.findElement(By.cssSelector("a[href='/admin/users']"));
    }
    public void clickOnTheUsersLinkFromAdminList () {
        getTheUsersFromAdminList().click();
    }
    public WebElement getTheSignUpButton () {
        return driver.findElement(By.cssSelector("div.v-toolbar__items a[href='/signup']"));
    }
    public void clickOnTheSignUpButton () {
        getTheSignUpButton().click();
    }
    public WebElement getLoginButton () {
        return driver.findElement(By.cssSelector("div.v-toolbar__items a[href='/login']"));
    }
    public void clickOnTheLoginButton() {
        getLoginButton().click();
    }
    public WebElement getTheLogOutButton () {
        return driver.findElement(By.className("btnLogout"));
    }
    public  void clickOnTheLogOutButton () {
        getTheLogOutButton().click();
    }
    public WebElement getTheLanguageSelectionButton () {
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    public void clickOnTheLanguageSelectionButton () {
        getTheLanguageSelectionButton().click();
    }
    public void waitForTheListFromLanguageSelectionButtonToBeVisible () {
        wait    .withMessage("After clicking on the selection button the list below should be visible.")
                .until(ExpectedConditions.visibilityOf
                        (driver.findElement(By.cssSelector("div.v-menu__content div.v-list"))));
    }
    public WebElement getTheEnglishLanguageItem () {
        return driver.findElement(By.id("list-item-80"));
    }
    public void selectEnglishLanguage () {
        getTheEnglishLanguageItem().click();
    }
    public WebElement getTheSpanishLanguageItem () {
        return driver.findElement(By.id("list-item-82"));
    }
    public void selectSpanishLanguage () {
        getTheSpanishLanguageItem().click();
    }
    public WebElement getTheFrenchLanguageItem () {
        return driver.findElement(By.id("list-item-84"));
    }
    public void selectFrenshLanguage () {
        getTheFrenchLanguageItem().click();
    }
    public WebElement getTheChineseLanguageItem () {
        return driver.findElement(By.id("list-item-86"));
    }
    public void selectChineseLanguage () {
        getTheChineseLanguageItem().click();
    }
    public WebElement getTheUkranianLanguageItem () {
        return driver.findElement(By.id("list-item-88"));
    }
    public void selectUkranianLanguage () {
        getTheUkranianLanguageItem().click();
    }


}
