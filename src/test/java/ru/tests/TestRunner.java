package ru.tests;

import com.main.MainTestClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class TestRunner extends BeforeAfterSetup {

    MainTestClass mainTestClass = PageFactory.initElements(driver, MainTestClass.class);

    @Test
    public void getElementDisplayed() {
        //   mainTestClass.getElementDisplayedOnNavigationPanel();
        Assert.assertEquals(mainTestClass.findAmountOfElements(mainTestClass.getNavigationMenuList()), 10);
    }
    @Test
    public void choosePizzaWindow(){
      //  if (mainTestClass.chooseButton.isDisplayed())
           mainTestClass.chooseButton.click();
       Assert.assertEquals("Пепперони Фреш с перцем", mainTestClass.titleInChosenWindow.getText());
    }

   @Test
    // This method describes the way to move to another page:
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
