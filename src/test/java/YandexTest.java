import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.MarketPage;
import pages.MarketPageElectronics;
import pages.MarketPageElectronicSub;
import steps.BaseSteps;

import java.time.Duration;
import java.util.Set;

public class YandexTest extends BaseSteps {

    @Test
    @Ignore
    //Сценарий №1
    public void testOne() throws InterruptedException {
        String menuMainItem = "Маркет";
        String menuMarketItem = "Электроника";
        String ElectronicsMenuItem = "Телевизоры";
        String companyLG = "LG";
        String companySamsung = "Samsung";
        String firstElement;
        String element;
        String price = "500000";
        int quantityOffers;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get(baseUrl);

        MainPage mainPage = new MainPage(driver);
        mainPage.selectServiceMenu(menuMainItem);
        mainPage.mainWindow = driver.getWindowHandle();

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(mainPage.mainWindow)) {
                driver.switchTo().window(window);
            }
        }

        MarketPage marketPage = new MarketPage(driver);
        marketPage.selectMarketMenu(menuMarketItem);

        MarketPageElectronics marketPageElectronics = new MarketPageElectronics(driver);
        marketPageElectronics.selectElectronicsMenu(ElectronicsMenuItem);
        MarketPageElectronicSub marketPageElectronicSub = new MarketPageElectronicSub(driver);
        marketPageElectronicSub.clickButtonAllFilters();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Сбросить фильтры')]"))));
        marketPageElectronicSub.fillField(price);
        marketPageElectronicSub.activateFilterCheckbox(companyLG);
        marketPageElectronicSub.activateFilterCheckbox(companySamsung);
        marketPageElectronicSub.checkFilterCheckbox(companyLG);
        marketPageElectronicSub.checkFilterCheckbox(companySamsung);

        quantityOffers = marketPageElectronicSub.getQuantityOffers();
        marketPageElectronicSub.showOffers();
        marketPageElectronicSub.checkQuantityOffers(marketPageElectronicSub.contentResults, quantityOffers);
        firstElement = marketPageElectronicSub.contentResults.get(1).getAttribute("title");
        marketPageElectronicSub.fillSearchBar(firstElement);
        marketPageElectronicSub.clickSearchButton();
        element = marketPageElectronicSub.contentResults.get(0).getAttribute("title");
        marketPageElectronicSub.checkOffer(element, firstElement);
    }

    @Test
    @Ignore
    //Сценарий №2
    public void testTwo() throws InterruptedException {
        String menuMainItem = "Маркет";
        String menuMarketItem = "Электроника";
        String ElectronicsMenuItem = "Наушники и Bluetooth-гарнитуры";
        String companySennheiser = "Sennheiser";
        String firstElement;
        String element;
        String price = "50000";
        int quantityOffers;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectServiceMenu(menuMainItem);
        mainPage.mainWindow = driver.getWindowHandle();

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(mainPage.mainWindow)) {
                driver.switchTo().window(window);
            }
        }

        MarketPage marketPage = new MarketPage(driver);
        marketPage.selectMarketMenu(menuMarketItem);

        MarketPageElectronics marketPageElectronics = new MarketPageElectronics(driver);
        marketPageElectronics.selectElectronicsMenu(ElectronicsMenuItem);
        MarketPageElectronicSub marketPageElectronicSub = new MarketPageElectronicSub(driver);
        marketPageElectronicSub.clickButtonAllFilters();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Сбросить фильтры')]"))));
        marketPageElectronicSub.fillField(price);

        marketPageElectronicSub.activateFilterCheckbox(companySennheiser);
        marketPageElectronicSub.checkFilterCheckbox(companySennheiser);
        quantityOffers = marketPageElectronicSub.getQuantityOffers();
        marketPageElectronicSub.showOffers();
        marketPageElectronicSub.checkQuantityOffers(marketPageElectronicSub.contentResults, quantityOffers);
        firstElement = marketPageElectronicSub.contentResults.get(1).getAttribute("title");
        marketPageElectronicSub.fillSearchBar(firstElement);
        marketPageElectronicSub.clickSearchButton();
        element = marketPageElectronicSub.contentResults.get(0).getAttribute("title");
        marketPageElectronicSub.checkOffer(element, firstElement);
    }
}
