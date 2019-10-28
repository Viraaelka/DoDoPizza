package ru.tests;

import com.main.pages.MainClassRussianTest;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class TestRunner extends BeforeAfterSetup {
    long max_wait_time = 6000;
    long start_time = System.currentTimeMillis();
    /* ----------- Expected values -----------------*/
    int navigaionMenuElementsNumber = 10;

    MainClassRussianTest mainTestClass = PageFactory.initElements(BeforeAfterSetup.driver, MainClassRussianTest.class);

    // public void clickOnElemenet() {PageFactory.initElements(driver, MainTestClass.class).clickOnItem();}

   // @Test
    public void getElementDisplayed() {
        //   mainTestClass.getElementDisplayedOnNavigationPanel();
        Assert.assertEquals(mainTestClass.findAmountOfElements(mainTestClass.getNavigationMenuList()), navigaionMenuElementsNumber);
    }
   // @Test
    public void choosePizzaWindow(){
      //  if (mainTestClass.chooseButton.isDisplayed())
           mainTestClass.chooseButton.click();
       Assert.assertEquals("Пепперони Фреш с перцем", mainTestClass.titleInChosenWindow.getText());
    }

  //  @Test
    public void someSimpleTest() {
     /*   driver.get("http://internetka.in.ua");

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
*/
    }
}
