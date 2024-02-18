import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TalentLyft {
    public static final String BASE_URL = "https://factory.talentlyft.com/";
    public static final String HOVER_COLOR = "rgba(68, 64, 255, 0.835)";
    WebDriver driver;
    By ActiveJobsContainer =By.xpath("/html/body/section[2]/div[4]/div");
    By FirstActiveJobsAnchor =By.xpath("/html/body/section[2]/div[4]/div/a");
    By ActiveJobsSearch =By.xpath("/html/body/section[2]/div[2]/input");

    public TalentLyft(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement getActiveJobsContainer() {
        return driver.findElement(ActiveJobsContainer);
    }

    public WebElement getFirstActiveJobsAnchor() {
        return driver.findElement(FirstActiveJobsAnchor);
    }

    public WebElement getActiveJobsSearch() {
        return driver.findElement(ActiveJobsSearch);
    }

    public void hoverFirstActiveJobsAnchor() {
        Actions action = new Actions(this.driver);
        action.moveToElement(this.getFirstActiveJobsAnchor()).perform();
    }

    public void writeActiveJobsSearch(String input) {
        this.getActiveJobsSearch().sendKeys(input);
    }
}
