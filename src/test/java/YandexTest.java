import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.MarketPage;
import pages.MarketPageElectronics;
import pages.MarketPageElectronicSub;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;
import java.time.Duration;


public class YandexTest extends BaseSteps {

    @Test
    @Ignore
    @Title("Сценарий 1")
    public void testOne() throws InterruptedException {
        String menuMainItem = "Маркет";
        String menuMarketItem = "Электроника";
        String ElectronicsMenuItem = "Телевизоры";
        String companyLG = "LG";
        String companySamsung = "Samsung";
        String firstElement;
        String element;
        String price = "500000";
        String mainWindow;
        int quantityOffers;
        int numItem = 0;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get(baseUrl);

        MainPage mainPage = new MainPage(driver);
        mainPage.selectServiceMenu(menuMainItem);

        setActivePageInPagesList();
        switchActivatePage();

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
        marketPageElectronicSub.checkQuantityOffers(quantityOffers);

        firstElement = marketPageElectronicSub.getTitleAttribute(numItem);
        marketPageElectronicSub.fillSearchBar(firstElement);
        marketPageElectronicSub.clickSearchButton();
        element = marketPageElectronicSub.getTitleAttribute(numItem);
        marketPageElectronicSub.checkOffer(element, firstElement);
    }

    @Test
    @Ignore
    @Title("Сценарий 2")
    public void testTwo() throws InterruptedException {
        String menuMainItem = "Маркет";
        String menuMarketItem = "Электроника";
        String ElectronicsMenuItem = "Наушники и Bluetooth-гарнитуры";
        String companySennheiser = "Sennheiser";
        String firstElement;
        String element;
        String price = "50000";
        int quantityOffers;
        int numItem = 0;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectServiceMenu(menuMainItem);

        setActivePageInPagesList();
        switchActivatePage();

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
        marketPageElectronicSub.checkQuantityOffers(quantityOffers);
        firstElement = marketPageElectronicSub.getTitleAttribute(numItem);
        marketPageElectronicSub.fillSearchBar(firstElement);
        marketPageElectronicSub.clickSearchButton();
        element = marketPageElectronicSub.getTitleAttribute(numItem);
        marketPageElectronicSub.checkOffer(element, firstElement);
    }

}
