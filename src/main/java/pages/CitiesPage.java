package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CitiesPage extends BasicPage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getTheNewItemButton () {
        return driver.findElement(By.className("btnNewItem"));
    }
    public void clickOnTheNewItemButton () {
        getTheNewItemButton().click();
    }
    public WebElement getTheSearchInput () {
        return driver.findElement(By.id("search"));
    }
    public void clearAndTypeInSearchInput (String searchItem) {
        getTheSearchInput().clear();
        getTheSearchInput().sendKeys(searchItem);
    }
    public void waitForNewItemDialogToBeVisible () {
        wait    .withMessage("After clicking on the new item button the dialog should be visible.")
                .until(ExpectedConditions.visibilityOf
                        (driver.findElement(By.cssSelector("div[tabindex='0'].v-dialog__content .v-card"))));
    }
    public WebElement getInputFromNewItemDialog () {
        return driver.findElement(By.id("name"));
    }
    public String getAttributeTypeForInputFromNewItemDialog () {
        return getInputFromNewItemDialog().getAttribute("type");
    }
    public void clearAndTypeInputFromNewItemDialog (String cityName) {
        getInputFromNewItemDialog().clear();
        getInputFromNewItemDialog().sendKeys(cityName);
    }
    public WebElement getSaveButtonFromNewItemDialog () {
        return driver.findElement(By.className("btnSave"));
    }
    public void clickOnTheSaveButtonFromNewItemDialog () {
        getSaveButtonFromNewItemDialog().click();
    }
    public void waitForEditItemDialogToBeVisible () {
        wait    .withMessage("After clicking on the edit item button the edit dialog should be visible.")
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dlgNewEditItem"))));
    }
    public WebElement getInputFromEditItemDialog () {
        return driver.findElement(By.id("name"));
    }
    public void clearAndTypeInputFromEditItemDialog (String newName) {
        getInputFromEditItemDialog().sendKeys(Keys.chord(Keys.CONTROL, "a"), newName);
    }
    public WebElement getTheButtonSaveFromEditDialog () {
        return driver.findElement(By.cssSelector(".btnSave"));
    }
    public void clickOnTheButtonSaveFromEditDialog () {
        getTheButtonSaveFromEditDialog().click();
    }
    public void waitForDeleteItemDialogToBeVisible () {
        wait    .withMessage("After clicking on the bin button the delete dialog should be visible.")
                .until(ExpectedConditions.visibilityOf
                (driver.findElement(By.cssSelector("div[role='document'] div.v-dialog--active"))));
    }
    public WebElement getTheDeleteButtonFromDeleteDialog () {
        return driver.findElement(By.cssSelector("button[fdprocessedid='e31zxj']"));
    }
    public void clickOnTheDeleteButtonFromDeleteDialog () {
        getTheDeleteButtonFromDeleteDialog().click();
    }
    public void waitForTheSpecifiedNumberOfRowsToBeVisible (int numberOfRows) {
        wait    .withMessage("Number of table rows should be " + numberOfRows + ".")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody tr"), numberOfRows));
    }
    public WebElement specificCellFromSpecificRow (int numberOfRow, int numberOfCol) {
        return driver.findElement
                (By.cssSelector("tbody tr:nth-child(" + numberOfRow + ") td:nth-child(" + numberOfCol + ")"));
    }
    public List<WebElement> getEditButtonFromAllRows () {
        return driver.findElements(By.id("edit"));
    }
    public WebElement getEditButtonFromSpecificRow (int numberOfRow) {
        return getEditButtonFromAllRows().get(numberOfRow - 1);
    }
    public void clickOnTheEditButtonFromSpecificRow (int numberOfRow) {
        getEditButtonFromSpecificRow(numberOfRow).click();
    }
    public List<WebElement> getBinButtonFromAllRows () {
        return driver.findElements(By.id("delete"));
    }
    public WebElement getBinButtonFromSpecificRow (int numberOfRow) {
        return getBinButtonFromAllRows().get(numberOfRow - 1);
    }
}
