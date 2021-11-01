
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

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
        int numItem = 0;

        MainSteps mainSteps = new MainSteps();
        MarketPageSteps marketPageSteps = new MarketPageSteps();
        MarketPageElectronicsSteps marketPageElectronicsSteps = new MarketPageElectronicsSteps();
        MarketPageElectronicsSubSteps marketPageElectronicsSubSteps = new MarketPageElectronicsSubSteps();

        driver.get(baseUrl);

        mainSteps.stepSelectServiceMenu(menuMainItem);

        BaseSteps.setActivePageInPagesList();
        BaseSteps.switchActivatePage();

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
        marketPageElectronicsSubSteps.stepCheckQuantityOffers(quantityOffers);
        firstElement = marketPageElectronicsSubSteps.stepGetTitleAttribute(numItem);
        marketPageElectronicsSubSteps.stepFillSearchBar(firstElement);
        marketPageElectronicsSubSteps.stepClickSearchButton();
        element = marketPageElectronicsSubSteps.stepGetTitleAttribute(numItem);
        marketPageElectronicsSubSteps.stepCheckOffer(element, firstElement);
    }

    //@Test
    @Title("Сценарий 2")
    public void testInsuranceTwo() throws InterruptedException {
        String menuMainItem = "Маркет";
        String menuMarketItem = "Электроника";
        String ElectronicsMenuItem = "Наушники и Bluetooth-гарнитуры";
        String companySennheiser = "Sennheiser";
        String firstElement;
        String element;
        String price = "50000";
        int quantityOffers;
        int numItem = 0;

        MainSteps mainSteps = new MainSteps();
        MarketPageSteps marketPageSteps = new MarketPageSteps();
        MarketPageElectronicsSteps marketPageElectronicsSteps = new MarketPageElectronicsSteps();
        MarketPageElectronicsSubSteps marketPageElectronicsSubSteps = new MarketPageElectronicsSubSteps();

        driver.get(baseUrl);

        mainSteps.stepSelectServiceMenu(menuMainItem);

        BaseSteps.setActivePageInPagesList();
        BaseSteps.switchActivatePage();

        marketPageSteps.stepSelectMarketMenu(menuMarketItem);
        marketPageElectronicsSteps.stepSelectElectronicsMenu(ElectronicsMenuItem);
        marketPageElectronicsSubSteps.stepClickButtonAllFilters();
        marketPageElectronicsSubSteps.stepFillField(price);
        marketPageElectronicsSubSteps.stepActivateFilterCheckbox(companySennheiser);
        marketPageElectronicsSubSteps.stepCheckFilterCheckbox(companySennheiser);
        quantityOffers = marketPageElectronicsSubSteps.stepGetQuantityOffers();
        marketPageElectronicsSubSteps.stepShowOffers();
        marketPageElectronicsSubSteps.stepCheckQuantityOffers(quantityOffers);
        firstElement = marketPageElectronicsSubSteps.stepGetTitleAttribute(numItem);
        marketPageElectronicsSubSteps.stepFillSearchBar(firstElement);
        marketPageElectronicsSubSteps.stepClickSearchButton();
        element = marketPageElectronicsSubSteps.stepGetTitleAttribute(numItem);
        marketPageElectronicsSubSteps.stepCheckOffer(element, firstElement);
    }
}
