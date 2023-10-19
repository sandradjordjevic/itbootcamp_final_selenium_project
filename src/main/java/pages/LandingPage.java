package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasicPage{
    public LandingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getH1 () {
        return driver.findElement(By.tagName("h1"));
    }
    public String getTheTextFromH1 () {
        return getH1().getText();
    }
}
