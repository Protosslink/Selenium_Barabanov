package steps;

import pages.MarketPageElectronicSub;
import ru.yandex.qatools.allure.annotations.Step;


public class MarketPageElectronicsSubSteps extends BaseSteps {

    @Step("выполнено нажатие на кнопку - Все фильтры")
    public void stepClickButtonAllFilters() {
        new MarketPageElectronicSub(driver).clickButtonAllFilters();
    }

    @Step("поле цена от заполняется значением {0}")
    public void stepFillField(String valueString) {
        new MarketPageElectronicSub(driver).fillField(valueString);
    }

    @Step("выполнено нажатие на кнопку - Показать предложения")
    public void stepShowOffers() {
        new MarketPageElectronicSub(driver).showOffers();
    }

    @Step("получение значения количества предложений")
    public int stepGetQuantityOffers() throws InterruptedException {
        return new MarketPageElectronicSub(driver).getQuantityOffers();
    }

    @Step("поле поиска заполняется значением {0}")
    public void stepFillSearchBar(String string) {
        new MarketPageElectronicSub(driver).fillSearchBar(string);
    }

    @Step("выполнено нажатие на кнопку - Найти")
    public void stepClickSearchButton() {
        new MarketPageElectronicSub(driver).clickSearchButton();
    }

    @Step("выполнена активация чекбокса {0}")
    public void stepActivateFilterCheckbox(String checkBoxCompanyName) {
        new MarketPageElectronicSub(driver).activateFilterCheckbox(checkBoxCompanyName);
    }

    @Step("выполнена проверка на активацию чекбокса {0}")
    public void stepCheckFilterCheckbox(String checkBoxCompanyName) {
        new MarketPageElectronicSub(driver).checkFilterCheckbox(checkBoxCompanyName);
    }

    @Step("выполнена проверка равенства элементов {0} и {1}")
    public void stepCheckOffer(String firstElement, String secondElement) {
        new MarketPageElectronicSub(driver).checkOffer(firstElement, secondElement);
    }

    @Step("выполнена проверка количества предложений {0} и {1}")
    public void stepCheckQuantityOffers(int quantityOffers){
        new MarketPageElectronicSub(driver).checkQuantityOffers(quantityOffers);
    }

    @Step("получен title элемента {0} из списка contentResults")
    public String stepGetTitleAttribute(int numItem){
        return new MarketPageElectronicSub(driver).getTitleAttribute(numItem);
    }

}
