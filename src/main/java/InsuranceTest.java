import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class InsuranceTest {
    WebDriver driver;
    String baseURL;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseURL = "https://www.sberbank.ru/ru/person";
        //baseURL = "https://online.sber.insure/store/travel/";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(baseURL);




    }

    @Test

    public void testInsurance() {

        String firstName = "Дмитрий";
        String lastName = "Барабанов";
        String birthDate = "13.03.1989";
        String passportDateOfIssue = "07.04.2009";
        String passportSeries = "1111";
        String passportNumber = "111111";
        String passportIssue = "Россия";

        String mainWindow;
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = driver.findElement(By.xpath("(//A[@href='/ru/person/bank_inshure/insuranceprogram/life/travel'][text()='Путешествия'])"));

        mainWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[@role='button' and @aria-label='Страхование']")).click();
        wait.until(ExpectedConditions.visibilityOf(link)).click();

        driver.findElement(By.xpath("//span[@class='kitt-button__text' and text()='Оформить онлайн']")).click();
        driver.findElement(By.xpath("//span[@class='kitt-button__text' and text()='Оформить на сайте']")).click();

        Set<String> windows = driver.getWindowHandles();

        for(String window: windows){
            if(!window.equals(mainWindow)){
                driver.switchTo().window(window);
            }
        }

        Assert.assertEquals("Ошибка сравнения заголовка вкладки", "Страхование путешественников", driver.getTitle());

        driver.findElement(By.xpath("//div[@class='online-card-program selected']//*[text()='Минимальная']"));
        driver.findElement(By.xpath("//button[@type='button' and text()='Оформить']")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("documentDate"))));


        fillField(By.id("surname_vzr_ins_0"), lastName);
        fillField(By.id("name_vzr_ins_0"), firstName);
         fillField(By.id("person_lastName"), lastName);
        fillField(By.id("person_firstName"), firstName);
        fillField(By.id("passportSeries"), passportSeries);
        fillField(By.id("passportNumber"), passportNumber);
        fillField(By.id("documentIssue"), passportIssue);
        fillField(By.id("documentDate"), passportDateOfIssue);
        fillField(By.id("person_birthDate"), birthDate);
        fillField(By.id("birthDate_vzr_ins_0"), birthDate);

        Assert.assertEquals("Ошибка ввода поля Фамилия",lastName, driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("Ошибка ввода поля Имя",firstName,driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("Ошибка ввода поля Фамилия",lastName,driver.findElement(By.id("person_lastName")).getAttribute("value"));
        Assert.assertEquals("Ошибка ввода поля Имя",firstName, driver.findElement(By.id("person_firstName")).getAttribute("value"));
        Assert.assertEquals("Ошибка ввода поля Серия паспорта",passportSeries, driver.findElement(By.id("passportSeries")).getAttribute("value"));
        Assert.assertEquals("Ошибка ввода поля Номер паспорта",passportNumber, driver.findElement(By.id("passportNumber")).getAttribute("value"));
        Assert.assertEquals("Ошибка ввода поля Кем выдан",passportIssue, driver.findElement(By.id("documentIssue")).getAttribute("value"));
        Assert.assertEquals("Ошибка ввода поля Дата выдачи",passportDateOfIssue, driver.findElement(By.id("documentDate")).getAttribute("value"));
        Assert.assertEquals("Ошибка ввода поля Дата рождения",birthDate, driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        Assert.assertEquals("Ошибка ввода поля Дата рождения",birthDate, driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));

        driver.findElement(By.xpath("//div[@class='btn-group']/label[contains(text(), 'гражданин РФ')]"));
        driver.findElement(By.xpath("//label[@for=\"checkbox-person_isEmptyMiddleName\"]/span[@class=\"checkbox\"]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        System.out.println("qq");


    }



    public void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    @After
    public void afterTest() {
        driver.quit();
    }

}
