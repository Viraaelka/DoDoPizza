package com.main.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DodoControl {
    //todo find all xpath ways!
  //  @ElementTitle("Страна - условие")
    @FindBy(xpath = "")
    public WebElement countryText;

 //   @ElementTitle("Страна")
    @FindBy(xpath = "")
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

}

