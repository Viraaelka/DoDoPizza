package com.main.pages;

import com.config.PageFactory;
import com.main.exceptions.AutotestException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class DodoControl {
    private String xpath = "//div[text()='%s']/following-sibling::span";
    public Map<String, String> mapFormXpath = new HashMap<>();
    public Set<String> hashSetXpath = new HashSet<>();

    public void setHashMap() {
        mapFormXpath.put("Страна", "//div[text()='Страна']/following-sibling::span");
        mapFormXpath.put("Город", "//div[text()='Город']/following-sibling::span");
        mapFormXpath.put("Адрес пиццерии", "//div[text()='Адрес ']/following-sibling::span//span[@role='combobox']");
        mapFormXpath.put("Имя", "//div[text()='Имя']/following-sibling::input");
        mapFormXpath.put("Дата рождения", "//div[text()='Дата ']/following-sibling::input");
        mapFormXpath.put("Телефон", "//div[text()='Телефон']/following-sibling::input");
        mapFormXpath.put("Вконтакте", "//div[text()='Вконтакте']/following-sibling::input");
        mapFormXpath.put("Вы или ваши знакомые работали в Додо Пицце?", "//div[@class='form__main'][1]//following-sibling::label[@class='main']");
        mapFormXpath.put("Нет", "//div[@class='form__main'][1]//following-sibling::label[@for='1']");
        mapFormXpath.put("Да, раньше", "//div[@class='form__main'][1]//following-sibling::label[@for='2']");
        mapFormXpath.put("Да, прямо сейчас", "//div[@class='form__main'][1]//following-sibling::label[@for='1']");
        mapFormXpath.put("Что вы готовы проверять?", "//div[@class='form__main'][2]//following-sibling::label[@class='main']");
        mapFormXpath.put("Ресторан", "//div[@class='form__main'][2]//following-sibling::label[@for='4']");
        mapFormXpath.put("Доставку", "//div[@class='form__main'][2]//following-sibling::label[@for='5']");
        mapFormXpath.put("И то, и другое", "//div[@class='form__main'][2]//following-sibling::label[@for='6']");
        //   mapFormXpath.put("Согласен на обработку персональных данных", "");
        //   mapFormXpath.put("Согласен на получение рекламных рассылок", "");
        mapFormXpath.put("Отправить", "//button[text()='Отправить']");

    }

    public void setHashSet() {
        hashSetXpath.add("//div[text()='Страна']/following-sibling::span");
        hashSetXpath.add("//div[text()='Город']/following-sibling::span");
        hashSetXpath.add("//div[text()='Адрес ']/following-sibling::span//span[@role='combobox']");
        hashSetXpath.add("//div[text()='Имя']/following-sibling::input");
        hashSetXpath.add("//div[text()='Дата ']/following-sibling::input");
        hashSetXpath.add("//div[text()='Телефон']/following-sibling::input");
        hashSetXpath.add("//div[text()='Вконтакте']/following-sibling::input");
        hashSetXpath.add("//div[@class='form__main'][1]//following-sibling::label[@class='main']");
        hashSetXpath.add("//div[@class='form__main'][1]//following-sibling::label[@for='1']");
        hashSetXpath.add("//div[@class='form__main'][1]//following-sibling::label[@for='2']");
        hashSetXpath.add("//div[@class='form__main'][1]//following-sibling::label[@for='1']");
        hashSetXpath.add("//div[@class='form__main'][2]//following-sibling::label[@class='main']");
        hashSetXpath.add("//div[@class='form__main'][2]//following-sibling::label[@for='4']");
        hashSetXpath.add("//div[@class='form__main'][2]//following-sibling::label[@for='5']");
        hashSetXpath.add("//div[@class='form__main'][2]//following-sibling::label[@for='6']");
        hashSetXpath.add("");
        hashSetXpath.add("");
        hashSetXpath.add("//button[text()='Отправить']");

    }

    public String[] strXpath = {
            "//div[text()='Страна']/following-sibling::span",
            "//div[text()='Город']/following-sibling::span",
            "//div[text()='Адрес ']/following-sibling::span//span[@role='combobox']",
            "//div[text()='Имя']/following-sibling::input",
            "//div[text()='Дата ']/following-sibling::input",
            "//div[text()='Телефон']/following-sibling::input",
            "//div[text()='Вконтакте']/following-sibling::input",
            "//div[@class='form__main'][1]//following-sibling::label[@class='main']",
            "//div[@class='form__main'][1]//following-sibling::label[@for='1']",
            "//div[@class='form__main'][1]//following-sibling::label[@for='2']",
            "//div[@class='form__main'][1]//following-sibling::label[@for='1']",
            "//div[@class='form__main'][2]//following-sibling::label[@class='main']",
            "//div[@class='form__main'][2]//following-sibling::label[@for='4']",
            "//div[@class='form__main'][2]//following-sibling::label[@for='5']",
            "//div[@class='form__main'][2]//following-sibling::label[@for='6']",
            "//button[text()='Отправить']"
    };

    //todo find all xpath ways!
    // @ElementTitle("Страна - условие")
    @FindBy(xpath = "//div[text()='Страна']")
    public WebElement countryText;

    // @ElementTitle("Страна")
    @FindBy(xpath = "//div[text()='Город']/following-sibling::span")
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

    private WebDriver webDriver = PageFactory.getDriver();

    public DodoControl(WebDriver driver) {
        this.webDriver = driver;
    }

    public void fillUpForm(DataTable dataTable) {
        Map<String, String> mapForm = dataTable.asMap(String.class, String.class);
        mapForm.forEach((k, v) -> {
            WebElement element;
            try {
                element = PageFactory.getDriver().findElement(By.xpath(String.format(xpath, k)));
            } catch (NoSuchElementException e) {
                throw new AutotestException(String.format("No such element %s was found in class %s", k, this.getClass().getName()), e);
            }
        });

    }

    public void checkUpNamesInForm(DataTable dataTable) {
        Map<String, String> mapForm = dataTable.asMap(String.class, String.class);
        setHashMap();

        // for(String sXpath : strXpath){
        mapForm.forEach((k, v) -> {
            System.out.println("k = " + k + " v = " + v);
            mapFormXpath.forEach((kXpath, vXpath) -> {

                WebElement element = null;
                try {
                    if (k.equals(kXpath)) {
                        element = PageFactory.getDriver().findElement(By.xpath(vXpath));
                        System.out.println("kXpath = " + kXpath + " k = " + k);
                        System.out.println("ELEMENT = " + element.getText() + " and v = " + v);
                        Assert.assertEquals("Texts do not match", element.getText(), v);
                    }
                } catch (NoSuchElementException e) {
                    throw new AutotestException(String.format("No such element %s was found in class %s", v, this.getClass().getName()), e);
                }
            });
        });
        // }

    }
}

