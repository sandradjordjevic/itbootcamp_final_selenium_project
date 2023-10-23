package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected NavPage navPage;
    protected LoginPage loginPage;
    protected MessagePopUpPage messagePopUpPage;
    protected SignupPage signupPage;
    protected CitiesPage citiesPage;
    protected LandingPage landingPage;
    protected ProfilePage profilePage;
    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navPage = new NavPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        messagePopUpPage = new MessagePopUpPage(driver, wait);
        signupPage = new SignupPage(driver, wait);
        citiesPage = new CitiesPage(driver, wait);
        landingPage = new LandingPage(driver, wait);
        profilePage = new ProfilePage(driver, wait);
    }
    @BeforeMethod
    public void beforeMethod () {
        driver.navigate().to(baseUrl);
    }
    @AfterMethod
    public void afterMethod (ITestResult result) throws IOException {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
        String stringDate = dateFormat.format(date);

        if (ITestResult.FAILURE==result.getStatus()) {
            File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(file.toPath(), new File("screenshots/screenshot-" + stringDate + ".jpg").toPath());
        }
    }
    @AfterClass
    public void afterClass () {
        driver.quit();
    }

}
