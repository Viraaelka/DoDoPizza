package ru.tests;

import com.main.MainTestClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.tests.BeforeAfterSetup;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class TestRunner extends BeforeAfterSetup {
    long max_wait_time = 6000;
    long start_time = System.currentTimeMillis();

        MainTestClass mainTestClass = PageFactory.initElements(driver, MainTestClass.class);

    @Test
    public void getElementDisplayed(){
        mainTestClass.getElementDisplayedOnNavigationPanel();
    }

    @Test
    public void someSimpleTest() {
        driver.get("http://internetka.in.ua");

        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();

        driver.findElement(By.tagName("a")).click();

        String newWindow = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );

        driver.switchTo().window(newWindow);

        System.out.println("New window title: " + driver.getTitle());
        driver.close();

        driver.switchTo().window(originalWindow);
        System.out.println("Old window title: " + driver.getTitle());

    }
}
