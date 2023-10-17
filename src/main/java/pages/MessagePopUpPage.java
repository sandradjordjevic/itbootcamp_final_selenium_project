package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void waitForThePopUpToBeVisibleWhenCredentialAreWrong () {
        wait    .withMessage("Pop up message for invalid login should be visible.")
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.error div[role='status']"))));
    }
    public WebElement getThePopUpMessageWhenCredentialAreWrong () {
        return driver.findElement(By.cssSelector("div.error div[role='status'] ul li"));
    }
    public String getTheTextFromPopUpMessageWhenCredentialAreWrong () {
        return getThePopUpMessageWhenCredentialAreWrong().getText();
    }
    public WebElement getTheCloseButtonFromPopUpMessageWhenCredentialAreWrong () {
        return driver.findElement(By.cssSelector("div.error div[role='status'] button[fdprocessedid = 'h1bo3']"));
    }
    public void clickOnTheCloseButtonFromPopUpMessage () {
        getTheCloseButtonFromPopUpMessageWhenCredentialAreWrong().click();
    }
}
