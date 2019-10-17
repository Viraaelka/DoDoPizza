package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.NoSuchElementException;

public class MainTestClass{
    private WebDriver webdriver = com.config.PageFactory.getDriver();

    public String framePizzaWindow = "//div[@class='popup__dialog-inner']";

    @FindBy (xpath = "(//div[@id='pizzas']//button[1]")
    public WebElement chooseButton;

    @FindBy (xpath = "//div[@class='popup__dialog-inner']/descendant::span[contains(@class, ProductCardNameValue)][1]")
    public WebElement titleInChosenWindow;

/* ============================ Applying promocode ==========================================*/
    @FindBy(xpath = "//div[@class = 'menu__promocode']/descendant-or-self::input")
    public WebElement promocodeInput;

    @FindBy(xpath = "//div[@class = 'menu__promocode']/descendant-or-self::button")
    public WebElement applyPromoButton;

    @FindBy(xpath = "")
    public WebElement promoPopupMessage;



    /*  public void getElementDisplayedOnNavigationPanel(){
          int count = 0;
          for(WebElement element : navigationMenu){
              if(element.isDisplayed()){
                  count++;
              }
          }
          System.out.println(count + " getTitle() = " + webdriver.getTitle());
          //   return navigationMenu.stream().filter(webElement -> webElement.isDisplayed()).peek();
          // return count;
      }
      */
    public List<WebElement> getNavigationMenuList(){
       for(WebElement elem : webdriver.findElements(By.xpath("//ul[@class='navigation__list']/descendant::a"))){
            System.out.println(elem.getText());
        }
        return webdriver.findElements(By.xpath("//ul[@class='navigation__list']/descendant::a"));
    }

    public int findAmountOfElements(List<WebElement> array){
        if(array.isEmpty())
            throw new NoSuchElementException("The list of elements is empty " + array.toString());
        return array.size();
    }


    public void clickOnItem(WebElement element){
        if(element.isDisplayed())
            element.click();
        else
            throw new NoSuchElementException("Unable to find and click on the element " + element.getText());
    }

    @FindBy(xpath = "//div[@class='popup__dialog-inner']//following-sibling::span")
    public WebElement pizzaTitle;

}
