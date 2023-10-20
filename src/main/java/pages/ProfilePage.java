package pages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage{
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getInputEmail () {
        return driver.findElement(By.id("email"));
    }
    public void clearAndTypeInputEmail (String email) {
        getInputEmail().sendKeys(Keys.chord(Keys.CONTROL, "a"), email);
    }
    public String getAttributeValueFromInputEmail () {
        return getInputEmail().getAttribute("value");
    }
    public void waitForTheDialogToBeInvisible () {
        wait    .withMessage("Load dialog should be invisible after a few seconds")
                .until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div.v-dialog.v-dialog--persistent"))));
    }
    public String getAttributeTypeFromInputEmail() {
        return getInputEmail().getAttribute("type");
    }
    public String getAttributeDisabledFromInputEmail () {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return arguments[0].getAttribute('disabled');", getInputEmail()).toString();
    }
    public WebElement getInputName () {
        return driver.findElement(By.id("name"));
    }
    public void clearAndTypeInputName (String name) {
        getInputName().sendKeys(Keys.chord(Keys.CONTROL, "a"), name);
    }
    public String getAttributeTypeFromInputName () {
        return getInputName().getAttribute("type");
    }
    public WebElement getInputCity () {
        return driver.findElement(By.id("city"));
    }
    public void clearAndTypeInputCity (String city) {
        getInputCity().sendKeys(Keys.chord(Keys.CONTROL, "a"), city);
        getInputCity().sendKeys(Keys.ENTER);
    }
    public String getAttributeTypeFromInputCity () {
        return getInputCity().getAttribute("type");
    }
    public WebElement getInputCountry () {
        return driver.findElement(By.id("country"));
    }
    public String getAttributeTypeFromInputCountry () {
        return getInputCountry().getAttribute("type");
    }
    public WebElement getInputTwitter () {
        return driver.findElement(By.id("urlTwitter"));
    }
    public void clearAndTypeInputTwitter (String twitter) {
        getInputTwitter().sendKeys(Keys.chord(Keys.CONTROL, "a"), twitter);
    }
    public String getAttributeTypeFromInputTwitter () {
        return getInputTwitter().getAttribute("type");
    }
    public WebElement getInputGitHub () {
        return driver.findElement(By.id("urlGitHub"));
    }
    public void clearAndTypeInputGitHub (String gitHub) {
        getInputGitHub().sendKeys(Keys.chord(Keys.CONTROL, "a"), gitHub);
    }
    public String getAttributeTypeFromInputGitHub () {
        return getInputGitHub().getAttribute("type");
    }
    public WebElement getInputPhone () {
        return driver.findElement(By.id("phone"));
    }
    public void clearAndTypeInputPhone(String phone) {
        getInputPhone().sendKeys(Keys.chord(Keys.CONTROL, "a"), phone);
    }
    public String getAttributeTypeFromInputPhone () {
        return getInputPhone().getAttribute("type");
    }
    public WebElement getSaveButton () {
        return driver.findElement(By.cssSelector("button.btnSave"));
    }
    public void clickOnTheSaveButton () {
        getSaveButton().click();
    }


}
