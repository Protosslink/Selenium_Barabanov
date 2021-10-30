import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;
import java.util.Set;

public class TestYandexForAllureReport extends BaseSteps {

    @Test
    @Title("Сценарий 1")
    public void testInsurance() throws InterruptedException {
        String menuMainItem = "Маркет";
        String menuMarketItem = "Электроника";
        String ElectronicsMenuItem = "Телевизоры";
        String companyLG = "LG";
        String companySamsung = "Samsung";
        String firstElement;
        String element;
        String price = "500000";
        int quantityOffers;

        MainSteps mainSteps = new MainSteps();
        MarketPageSteps marketPageSteps = new MarketPageSteps();
        MarketPageElectronicsSteps marketPageElectronicsSteps = new MarketPageElectronicsSteps();
        MarketPageElectronicsSubSteps marketPageElectronicsSubSteps = new MarketPageElectronicsSubSteps();

        driver.get(baseUrl);

        mainSteps.stepSelectServiceMenu(menuMainItem);
        mainSteps.mainWindow = driver.getWindowHandle();

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(mainSteps.mainWindow)) {
                driver.switchTo().window(window);
            }
        }

        marketPageSteps.stepSelectMarketMenu(menuMarketItem);
        marketPageElectronicsSteps.stepSelectElectronicsMenu(ElectronicsMenuItem);
        marketPageElectronicsSubSteps.stepClickButtonAllFilters();
        marketPageElectronicsSubSteps.stepFillField(price);
        marketPageElectronicsSubSteps.stepActivateFilterCheckbox(companyLG);
        marketPageElectronicsSubSteps.stepActivateFilterCheckbox(companySamsung);
        marketPageElectronicsSubSteps.stepCheckFilterCheckbox(companyLG);
        marketPageElectronicsSubSteps.stepCheckFilterCheckbox(companySamsung);
        quantityOffers = marketPageElectronicsSubSteps.stepGetQuantityOffers();
        marketPageElectronicsSubSteps.stepShowOffers();
        marketPageElectronicsSubSteps.stepCheckQuantityOffers(marketPageElectronicsSubSteps.contentResults,quantityOffers);
        firstElement = marketPageElectronicsSubSteps.contentResults.get(1).getAttribute("title");
        marketPageElectronicsSubSteps.stepFillSearchBar(firstElement);
                marketPageElectronicsSubSteps.stepClickSearchButton();
        element = marketPageElectronicsSubSteps.contentResults.get(0).getAttribute("title");
        marketPageElectronicsSubSteps.stepCheckOffer(element, firstElement);
    }
}
