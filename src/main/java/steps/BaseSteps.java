package steps;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;
import util.TestProperties;

import java.time.Duration;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class BaseSteps {

    public static WebDriver getDriver() {
        return driver;
    }

    static public List<String> windowsList = new ArrayList<>();
    protected static WebDriver driver;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();
    public static ArrayList<String> pages = new ArrayList<>();

    public static void setActivePageInPagesList() {
        BaseSteps.pages.add(driver.getWindowHandle());
    }

    public static void switchActivatePage() {
        Set<String> windowHandles = driver.getWindowHandles();
            for(String window: windowHandles){
                if(!pages.contains(window)){
                    driver.switchTo().window(window);
                }
            }
        }

   @Step("получили список вкладок браузера")
   public void stepSetActivePageInPagesList(){
        new BaseSteps().stepSetActivePageInPagesList();
   }

   @Step("активировали новую вкладку")
   public void stepSwitchActivatePage(){
        new BaseSteps().stepSwitchActivatePage();
   }


    @BeforeClass
    public static void setUp() throws Exception {
        switch (properties.getProperty("browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }

        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    protected void checkFillField(String value, By locator) {
        assertEquals(value, driver.findElement(locator).getAttribute("value"));
    }
}
