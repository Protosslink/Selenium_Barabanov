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
import java.util.concurrent.TimeUnit;

public class InsuranceTest {
    WebDriver driver;
    String baseURL;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseURL = "https://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get(baseURL);

    }

    @Test

    public void testInsurance() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = driver.findElement(By.xpath("(//A[@href='/ru/person/bank_inshure/insuranceprogram/life/travel'][text()='Путешествия'])"));
        WebElement linkTravel = driver.findElement(By.xpath("//A[href='https://online.sber.insure/store/travel/'][text()='Страхование путешественников']"));

        driver.findElement(By.xpath("//a[@role=\"button\" and @aria-label=\"Страхование\"]")).click();
        wait.until(ExpectedConditions.visibilityOf(link)).click();

        driver.findElement(By.xpath("//span[@class=\"kitt-button__text\" and text()=\"Оформить онлайн\"]")).click();
        driver.findElement(By.xpath("//span[@class=\"kitt-button__text\" and text()=\"Оформить на сайте\"]")).click();

        wait.until(ExpectedConditions.visibilityOf(linkTravel));
        Assert.assertEquals("Ошибка сравнения заголовка вкладки", "Страхование путешественников", driver.getTitle());
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
