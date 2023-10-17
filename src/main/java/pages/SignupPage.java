package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasicPage{
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getTheNameInput () {
        return driver.findElement(By.id("name"));
    }
    public void clearAndTypeNameInput (String name) {
        getTheNameInput().clear();
        getTheNameInput().sendKeys(name);
    }

    public WebElement getTheEmailInput () {
        return driver.findElement(By.id("email"));
    }
    public void clearAndTypeEmailInput (String email) {
        getTheEmailInput().clear();
        getTheEmailInput().sendKeys(email);
    }
    public String getAttributeTypeForEmailInput () {
        return getTheEmailInput().getAttribute("type");
    }
    public WebElement getThePasswordInput () {
        return driver.findElement(By.id("password"));
    }
    public void clearAndTypePasswordInput (String password) {
        getThePasswordInput().clear();
        getThePasswordInput().sendKeys(password);
    }
    public String getAttributeTypeForPasswordInput () {
        return getThePasswordInput().getAttribute("type");
    }
    public WebElement getTheConfirmPasswordInput () {
        return driver.findElement(By.id("confirmPassword"));
    }
    public void clearAndTypeConfirmPasswordInput (String password) {
        getTheConfirmPasswordInput().clear();
        getTheConfirmPasswordInput().sendKeys(password);
    }
    public String getAttributeTypeForConfirmPasswordInput () {
        return getTheConfirmPasswordInput().getAttribute("type");
    }
    public WebElement getTheSingMeUpButton () {
        return driver.findElement(By.cssSelector("button[type='submit']"));
    }
    public void clickOnTheSingMeUpButton () {
        getTheSingMeUpButton().click();
    }
}
