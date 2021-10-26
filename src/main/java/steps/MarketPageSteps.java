package steps;
import pages.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;


public class MarketPageSteps extends BaseSteps {

    @Step("выбран пункт меню магазина {0}")
    public void stepSelectMarketMenu(String nameMarketMenu) {
        new MarketPage(driver).selectMarketMenu(nameMarketMenu);
    }
}


