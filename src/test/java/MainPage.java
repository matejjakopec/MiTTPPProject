import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertEquals;

public class MainPage {
    public static final String BASE_URL = "https://factory.dev/";
    WebDriver driver;
    By ContactExpertButtonPath =By.xpath("/html/body/div/div[1]/div/div[1]/div/div/a");
    By LanguageSelectDropdown =By.xpath("/html/body/div/header/div/div/div[2]/div/div/ul");
    By LanguageIconButton =By.xpath("/html/body/div/header/div/div/div[2]/div/div/div");
    By CroatianLanguageSelectAnchor =By.xpath("/html/body/div/header/div/div/div[2]/div/div/ul/li[2]/a");
    By CareerNavigation =By.xpath("/html/body/div[1]/header/div/div/div[2]/nav/ul/li[4]");
    By CareerDropdown =By.xpath("/html/body/div[1]/header/div/div/div[2]/nav/ul/li[4]/div");
    By JobsAnchor =By.xpath("/html/body/div[1]/header/div/div/div[2]/nav/ul/li[4]/div/ul/li[1]/a");

    public MainPage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement getExpertButton() {
        return driver.findElement(ContactExpertButtonPath);
    }

    public WebElement getLanguageIconButton() {
        return driver.findElement(LanguageIconButton);
    }

    public WebElement getLanguageSelectDropdown() {
        return driver.findElement(LanguageSelectDropdown);
    }

    public WebElement getCroatianLanguageSelectAnchor() {
        return driver.findElement(CroatianLanguageSelectAnchor);
    }

    public WebElement getCareerNavigation() {
        return driver.findElement(CareerNavigation);
    }

    public WebElement getCareerDropdown() {
        return driver.findElement(CareerDropdown);
    }

    public WebElement getJobsAnchor() {
        return driver.findElement(JobsAnchor);
    }

    public void clickOnContactExpertButton() {
        getExpertButton().click();
    }

    public void clickOnLanguageIconButton() {
        getLanguageIconButton().click();
    }

    public void clickOnCroatianLanguageSelect() {
        getCroatianLanguageSelectAnchor().click();
    }

    public void hoverCareerNavigation() {
        Actions action = new Actions(this.driver);
        action.moveToElement(this.getCareerNavigation()).perform();
    }

    public void clickOnJobsAnchor() {
        getJobsAnchor().click();
    }
}
