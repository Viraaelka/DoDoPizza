import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BeforeAfterSetup {

    static WebDriver driver;
    private static String driverPath = "Macintosh HD\\Пользователи\\halilovaelvira\\Загрузки\\chromedriver.exe";
    private static String website = "https://dodopizza.ru/peterburg";

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(website);
    }

    @Before
    public void goToDodoPage(){
        driver.get(website);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
