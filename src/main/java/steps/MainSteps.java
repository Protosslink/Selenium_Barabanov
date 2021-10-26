package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps {

    @Step("выбран пункт сервис-меню {0}")
    public void stepSelectServiceMenu(String nameServiceMenu){
        new MainPage(driver).selectServiceMenu(nameServiceMenu);
    }

}
