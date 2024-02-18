import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TalentLyftHoverEffectsTest {
    public WebDriver driver;
    public TalentLyft talentLyft;

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", GlobalVariables.WEBDRIVER_PATH);
        driver = new ChromeDriver();
        talentLyft = new TalentLyft(driver);

        driver.navigate().to(TalentLyft.BASE_URL);
    }

    @Test
    public void HoverEffectsTest() throws InterruptedException {
        driver.manage().window().maximize();
        new WebDriverWait(driver, 5000).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", talentLyft.getActiveJobsContainer());
        talentLyft.hoverFirstActiveJobsAnchor();
        Assert.assertEquals(talentLyft.getFirstActiveJobsAnchor().getCssValue("background-color"), TalentLyft.HOVER_COLOR);
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
