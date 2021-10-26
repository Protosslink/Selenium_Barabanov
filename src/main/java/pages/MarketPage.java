package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MarketPage {
    @FindBy(xpath = "//div[contains(@data-zone-name,'menu')]")
    WebElement marketMenu;

    public MarketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(marketMenu));
    }

    public void selectMarketMenu(String nameMarketMenu) {
        marketMenu.findElement(By.xpath("//span[text()='"+nameMarketMenu+"']")).click();
    }

}
