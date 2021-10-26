package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public String mainWindow;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'services-new__content')]")
    WebElement serviceMenu;

    public void selectServiceMenu(String nameServiceMenu) {
        serviceMenu.findElement(By.xpath("//div[contains(@class,\"services-new__item-title\") and text()='" + nameServiceMenu + "']")).click();
    }

}
