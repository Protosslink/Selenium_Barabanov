package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MarketPageElectronics;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketPageElectronicsSteps extends BaseSteps{

    @Step("Выбран пункт меню электроника {0}")
    public void stepSelectElectronicsMenu(String nameElectronicsMenu){
        new MarketPageElectronics(driver).selectElectronicsMenu(nameElectronicsMenu);
    }
}


