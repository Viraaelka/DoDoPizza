import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestRunner extends BeforeAfterSetup{
    MainTestClass mainTestClass = PageFactory.initElements(driver, MainTestClass.class);
    WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Test
    public void getElementDisplayedOnNavigationPanel(){
        int count = 0;
        for(WebElement element : mainTestClass.navigationMenu){
            if(element.isDisplayed()){
                count++;
            }
        }
        System.out.println(count + " getTitle() = " + webDriver.getTitle());
        //   return navigationMenu.stream().filter(webElement -> webElement.isDisplayed()).peek();
       // return count;
    }
}
