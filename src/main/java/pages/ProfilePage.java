package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage{
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getInputEmail () {
        return driver.findElement(By.id("email"));
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
    public String getAttributeTypeFromInputName () {
        return getInputName().getAttribute("type");
    }
    public WebElement getInputCity () {
        return driver.findElement(By.id("city"));
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
    public String getAttributeTypeFromInputTwitter () {
        return getInputTwitter().getAttribute("type");
    }
    public WebElement getInputGitHub () {
        return driver.findElement(By.id("urlGitHub"));
    }
    public String getAttributeTypeFromInputGitHub () {
        return getInputGitHub().getAttribute("type");
    }
    public WebElement getInputPhone () {
        return driver.findElement(By.id("phone"));
    }
    public String getAttributeTypeFromInputPhone () {
        return getInputPhone().getAttribute("type");
    }

}
