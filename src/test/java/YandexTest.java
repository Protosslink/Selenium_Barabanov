import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.MarketPage;
import pages.MarketPageElectronics;
import pages.TvAndAccessoriesPage;
import steps.BaseSteps;

import java.time.Duration;
import java.util.Set;

public class YandexTest extends BaseSteps {

    @Test
    //@Ignore
    //Сценарий №1
    public void testOne() throws InterruptedException {
        String menuMainItem = "Маркет";
        String menuMarketItem = "Электроника";
        String ElectronicsMenuItem = "Телевизоры";
        String companyLG = "LG";
        String companySamsung = "Samsung";
        String firstElement;
        String element;
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

        TvAndAccessoriesPage tvAndAccessoriesPage = new TvAndAccessoriesPage(driver);
        tvAndAccessoriesPage.clickButtonAllFilters();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Сбросить фильтры')]"))));
        tvAndAccessoriesPage.fillField(tvAndAccessoriesPage.priceOt, "500000");
        tvAndAccessoriesPage.waitTime(1000);
        tvAndAccessoriesPage.activateFilterCheckbox(companyLG);
        tvAndAccessoriesPage.activateFilterCheckbox(companySamsung);
        tvAndAccessoriesPage.checkFilterCheckbox(companyLG);
        tvAndAccessoriesPage.checkFilterCheckbox(companySamsung);
        tvAndAccessoriesPage.waitTime(1000);
        quantityOffers = tvAndAccessoriesPage.getQuantityOffers();
        tvAndAccessoriesPage.waitTime(1000);
        tvAndAccessoriesPage.showOffers();

        if (quantityOffers == tvAndAccessoriesPage.contentResults.size()) {
            System.out.println("Количество предложений совпадает " + quantityOffers + " = " + tvAndAccessoriesPage.contentResults.size());
        } else {
            System.out.println("Количество предложений не совпадает " + quantityOffers + " != " + tvAndAccessoriesPage.contentResults.size());
        }
        firstElement = tvAndAccessoriesPage.contentResults.get(1).getAttribute("title");
        tvAndAccessoriesPage.fillSearchBar(firstElement);
        tvAndAccessoriesPage.clickSearchButton();
        tvAndAccessoriesPage.waitTime(1000);
        element = tvAndAccessoriesPage.contentResults.get(0).getAttribute("title");
        tvAndAccessoriesPage.waitTime(1000);
        tvAndAccessoriesPage.checkOffer(element, firstElement);
    }

    @Test
    //@Ignore
    //Сценарий №2
    public void testTwo() throws InterruptedException {
        String menuMainItem = "Маркет";
        String menuMarketItem = "Электроника";
        String ElectronicsMenuItem = "Наушники и Bluetooth-гарнитуры";
        String companySennheiser = "Sennheiser";
        String firstElement;
        String element;
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

        TvAndAccessoriesPage tvAndAccessoriesPage = new TvAndAccessoriesPage(driver);
        tvAndAccessoriesPage.clickButtonAllFilters();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Сбросить фильтры')]"))));
        tvAndAccessoriesPage.fillField(tvAndAccessoriesPage.priceOt, "50000");
        tvAndAccessoriesPage.waitTime(1000);
        tvAndAccessoriesPage.activateFilterCheckbox(companySennheiser);
        tvAndAccessoriesPage.checkFilterCheckbox(companySennheiser);
        tvAndAccessoriesPage.waitTime(1000);
        quantityOffers = tvAndAccessoriesPage.getQuantityOffers();
        tvAndAccessoriesPage.waitTime(1000);
        tvAndAccessoriesPage.showOffers();

        if (quantityOffers == tvAndAccessoriesPage.contentResults.size()) {
            System.out.println("Количество предложений совпадает " + quantityOffers + " = " + tvAndAccessoriesPage.contentResults.size());
        } else {
            System.out.println("Количество предложений не совпадает " + quantityOffers + " != " + tvAndAccessoriesPage.contentResults.size());
        }
        firstElement = tvAndAccessoriesPage.contentResults.get(1).getAttribute("title");
        tvAndAccessoriesPage.fillSearchBar(firstElement);
        tvAndAccessoriesPage.clickSearchButton();
        tvAndAccessoriesPage.waitTime(1000);
        element = tvAndAccessoriesPage.contentResults.get(0).getAttribute("title");
        tvAndAccessoriesPage.waitTime(1000);
        tvAndAccessoriesPage.checkOffer(element, firstElement);
    }
}
