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

        driver.findElement(By.xpath("//div[@class='online-card-program selected']//*[text()='Минимальная']")).click();
        driver.findElement(By.xpath("//button[@type='button' and text()='Оформить']")).click();
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
