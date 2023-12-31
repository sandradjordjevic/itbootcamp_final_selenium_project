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
    public void waitForThePopUpToBeVisible() {
        wait    .withMessage("Pop up message for invalid login should be visible.")
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.error div[role='status']"))));
    }
    public WebElement getThePopUpMessage () {
        return driver.findElement(By.cssSelector("div.error div[role='status'] ul li"));
    }
    public String getTheTextFromPopUpMessage () {
        return getThePopUpMessage().getText();
    }
    public WebElement getTheCloseButtonFromPopUpMessage () {
        return driver.findElement(By.cssSelector("button.btnClose"));
    }
    public void clickOnTheCloseButtonFromPopUpMessage () {
        getTheCloseButtonFromPopUpMessage().click();
    }
    public void waitForThePopUpMessageWhenUserSignupToBeVisible () {
        wait    .withMessage("Popup message when user signup should be visible.")
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.v-card"))));
    }
    public WebElement getPopUpMessageWhenUserSignUp () {
        return driver.findElement(By.cssSelector("div.v-card div.v-card__title"));
    }
    public String getTheTextFromPopUpMessageWhenUserSignUp () {
        return getPopUpMessageWhenUserSignUp().getText();
    }
    public WebElement getSuccessPopUpMessage () {
        return driver.findElement(By.cssSelector("div.success div[role='status']"));
    }
    public void waitForSuccessPopUpMessage() {
        wait    .withMessage("Successfully pop up message should be visible.")
                .until(ExpectedConditions.visibilityOf(getSuccessPopUpMessage()));
    }
    public boolean getTheTextFromSuccessPopMessage(String message) {
        return getSuccessPopUpMessage().getText().contains(message);
    }
}
