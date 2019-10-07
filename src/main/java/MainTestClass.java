import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainTestClass{
    WebDriver webdriver;

    MainTestClass(WebDriver webDriver){
        this.webdriver = webDriver;
    }
    List<WebElement> navigationMenu = webdriver.findElements(By.xpath("//li[@class='navigation__item']"));

}
