package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.*;

public class TvAndAccessoriesPage {
    public TvAndAccessoriesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> waiting = new WebDriverWait(driver,Duration.ofSeconds(30));
    }

    @FindBy(xpath = "//div[@data-grabber='SearchFilters']//span[text()='Все фильтры']")
    WebElement ButtonAllFilters;

    @FindBy(xpath = "//div[@data-filter-id='glprice']//div[@data-prefix='от']/input")
    public WebElement priceOt;

    @FindBy(xpath = "//section[@data-zone-name='all-filters-page']")
    WebElement searchFilterMenu;

    @FindBy(xpath = "//section[@data-zone-name='all-filters-page']//a[contains(text(),'Показать')]")
    WebElement showOffers;

    @FindBy(xpath = "//div[@data-apiary-widget-id='/content/results']//h3[@data-zone-name='title']//a[@title]")
    public List<WebElement> contentResults = new ArrayList<>();

    @FindBy(xpath = "//div[@data-apiary-widget-name='@MarketNode/HeaderSearch']//input[@placeholder='Искать товары']")
    WebElement searchBar;

    @FindBy(xpath = "//div[@data-apiary-widget-name=\"@MarketNode/HeaderSearch\"]//span[text()='Найти']")
    WebElement searchButton;

    public void clickButtonAllFilters() {
        this.ButtonAllFilters.click();
    }

    public void fillField(WebElement element, String valueString) {
        element.click();
        element.clear();
        element.sendKeys(valueString);
    }

    public void showOffers() {
        showOffers.click();
    }

    public int getQuantityOffers() {
        return Integer.parseInt(showOffers.getText().replaceAll("[^0-9]", ""));
    }

    public void fillSearchBar(String string) {
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(string);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void activateFilterCheckbox(String checkBoxCompanyName) {
        searchFilterMenu.findElement(By.xpath("//input[@type='checkbox' and @value='" + checkBoxCompanyName + "']/parent::label")).click();
    }

    public void checkFilterCheckbox(String checkBoxCompanyName) {
        searchFilterMenu.findElement(By.xpath("//input[@type='checkbox' and @value='" + checkBoxCompanyName + "']/parent::label")).isSelected();
    }

    public void waitTime(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    public void checkOffer(String firstElement, String secondElement) {
        System.out.println(firstElement);
        System.out.println(secondElement);
        Assert.assertEquals("Элементы не равны", firstElement, secondElement);
    }

}
