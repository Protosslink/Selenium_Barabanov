package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage extends BaseSteps {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String mainWindow;

    @FindBy(xpath = "//ul[@class='services-new__list']")
    WebElement menuItems;

    public void selectServiceMenu(String menuMainItem) {
        menuItems.findElement(By.xpath("//div[text()='" + menuMainItem + "']")).click();
    }

}