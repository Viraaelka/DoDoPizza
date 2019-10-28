package com.main.pages;

import com.config.PageFactory;
import com.main.exceptions.AutotestException;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class DodoControl extends MainTestClass{
    private String xpath = "//div[text()='%s']/following-sibling::span";

    //todo find all xpath ways!
   // @ElementTitle("Страна - условие")
    @FindBy(xpath = "//div[text()='Country']")
    public WebElement countryText;

   // @ElementTitle("Страна")
    @FindBy(xpath = "//div[text()='City']/following-sibling::span")
    public WebElement countryInputText;

 //   @ElementTitle("Город - условие")
    @FindBy(xpath = "")
    public WebElement cityText;

 //   @ElementTitle("Город")
    @FindBy(xpath = "")
    public WebElement cityInputText;

  //  @ElementTitle("Адрес пиццерии")
    @FindBy(xpath = "")
    public WebElement addressText;

  //  @ElementTitle("Имя")
    @FindBy(xpath = "")
    public WebElement nameText;

   // @ElementTitle("Дата рождения")
    @FindBy(xpath = "")
    public WebElement birthdayText;

  //  @ElementTitle("Телефон")
    @FindBy(xpath = "")
    public WebElement phoneText;

 //   @ElementTitle("Вконтакте")
    @FindBy(xpath = "")
    public WebElement vkText;

 //   @ElementTitle("Вы или ваши знакомые работали в Додо Пицце?")
    @FindBy(xpath = "")
    public WebElement askQuestionText;

 //   @ElementTitle("Нет")
    @FindBy(xpath = "")
    public WebElement noReplyText;

 //   @ElementTitle("Да, раньше")
    @FindBy(xpath = "")
    public WebElement yepReplyText;

 //   @ElementTitle("Да, прямо сейчас")
    @FindBy(xpath = "")
    public WebElement YepRightNowText;


  //  @ElementTitle("Что вы готовы проверять?")
    @FindBy(xpath = "")
    public WebElement question_Text;

    public DodoControl(WebDriver driver) {
        super(driver);
    }

    public void fillUpForm(DataTable dataTable){
        Map<String, String> mapForm = dataTable.asMap(String.class, String.class);
        mapForm.forEach((k, v) -> {
            WebElement element;
            try{
                element = PageFactory.getDriver().findElement(By.xpath(String.format(xpath, k)));
            }catch (NoSuchElementException e)
            {
                throw new AutotestException(String.format("No such element %s was found in class %s", k, this.getClass().getName()), e);
            }
        });

    }

 public void checkUpNamesInForm(List<String> mapForm){
      mapForm.forEach(s -> {
          WebElement element;
          try{
              if (s.equals("Country"))
              {
                  xpath = "//div[text()='Страна']";
              }
              element = PageFactory.getDriver().findElement(By.xpath(String.format(xpath, s)));
          }catch (NoSuchElementException e)
          {
              throw new AutotestException(String.format("No such element %s was found in class %s", s, this.getClass().getName()), e);
          }
          Assert.assertEquals("Texts do not match", element.getText(), s);
      });

  }

}

