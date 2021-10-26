package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketPageElectronics {

    public MarketPageElectronics(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'theme_light')]")
    WebElement menuElectronics;

    public void selectElectronicsMenu(String nameElectronicsMenu) {
        menuElectronics.findElement(By.xpath("//a[text()='"+nameElectronicsMenu+"']")).click();
    }

}
