import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageSwitchLanguageTest {
    public WebDriver driver;
    public MainPage mainPage;

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", GlobalVariables.WEBDRIVER_PATH);
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);

        driver.navigate().to(MainPage.BASE_URL);
    }

    @Test
    public void SwitchLanguageTest() throws InterruptedException {
        driver.manage().window().maximize();
        new WebDriverWait(driver, 5000).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        mainPage.clickOnLanguageIconButton();
        //check if proper class has been assigned after click
        Assert.assertTrue(mainPage.getLanguageSelectDropdown().getAttribute("class").contains("--active"));
        mainPage.clickOnCroatianLanguageSelect();
        //check if redirected to croatian site
        Assert.assertEquals(driver.getCurrentUrl(), MainPage.BASE_URL + "hr");
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }

}
