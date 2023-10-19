package pages;

import org.openqa.selenium.By;
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
}
