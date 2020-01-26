package com.main.pages;

import com.config.PageFactory;
import com.main.exceptions.AutotestException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class WrapperPage {
    public static final Logger LOG = LoggerFactory.getLogger(WrapperPage.class);

    private WebDriver driver = PageFactory.getDriver();

    public static final String myButtonXpath = "//button[text()='My order']";

    @FindBy(xpath = myButtonXpath)
    public WebElement myOrderButton;

    @FindBy(xpath = "//div[@class='footer__bottom-navigation']/a[contains(@href, 'document')]")
    public WebElement termAndConditionLink;

    @FindBy(xpath = "//div[@class='footer__bottom-navigation']/a[contains(@href, 'dodopizzastory')]")
    public WebElement dodoPizzaStoryLink;

    @FindBy(xpath = "//div[@class='footer__social']/a[contains(@href, 'instagram')]")
    public WebElement instagramLink;

    @FindBy(xpath = "//div[@class='footer__social']/a[contains(@href, 'facebook')]")
    public WebElement facebookLink;

    @FindBy(xpath = "//div[contains(@class, 'CameraLiveContainer')]")
    public WebElement liveButton;

    @FindBy(xpath = "//div[contains(@class,'cookie-policy')]//button")
    public WebElement cookieExitButton;

    @FindBy(xpath = "//span[text()='Pizza delivery']/parent::div//a")
    public WebElement cityPizzaElement;

    private String pizzaPath = "//div[@class='container']//div[text()='%s']//parent::div//button/parent::div";
    private String cityXpath = "//h1[text()='Choose your city']//ancestor::div//a[contains(text(),'%s')]";

    List<WebElement> navigationList;

    public String[] navigationNames = {"Pizza", "Snacks", "Desserts", "Drinks", "Deals", "Store info", "Live"};

    public WrapperPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseCityPage(String cityName) {
        try {
            WebElement cityElement;
            if (isElementPresent(cityPizzaElement)) {
                cityPizzaElement.click();
            }
            cityElement = PageFactory.getDriver().findElement(By.xpath(String.format(cityXpath, cityName)));
            cityElement.click();
            LOG.info("The city \"" + cityName + "\" has been chosen");
        } catch (NoSuchElementException e) {
            throw new AutotestException("No such a city as \"" + "\" in the city list");
        }
    }

    public void checkCityPage(String cityName) {
        try {
            WebElement cityElemOnHomePage = PageFactory.getDriver().findElement(By.xpath("//a[contains(text(),'" + cityName + "')]"));
            Assert.assertTrue("The city displayed on the home page does not match the expected one",
                    cityElemOnHomePage.getText().contains(cityName));
            LOG.info("We have made sure that the city \"" + cityName + "\" had been selected before");
        } catch (NoSuchElementException e) {
            throw new AutotestException("The displayed city is not as expected");
        }
    }

    public void turnOffCokies() {
        String cookieBodyXpath = "//div[contains(@class,'cookie-policy')]";
        try {
            Assert.assertTrue("Cookie button is not present on the Home page", isElementPresent(cookieExitButton));
            cookieExitButton.click();
        } catch (NoSuchElementException e) {
            LOG.error("Cookie button has been not found on the Home page");
        }
        Assert.assertTrue("Cookie popup is still present on the Home page", isElementNotPresent(cookieBodyXpath));
        LOG.info("We have accepted \"cookies\" terms and conditions");
    }

    public List<WebElement> getList() {
        return navigationList = driver.findElements(By.xpath("//div[@class='navigation__inner']//li"));
    }

    public void checkNavigationMenu() {
        if (getList().size() != 0) {
            Assert.assertTrue("The size of String[] array does not match navigationList, expected = "
                            + navigationNames.length + " actual = " + getList().size(),
                    navigationNames.length == getList().size());
        } else
            throw new AutotestException("The navigition menu is not full, some elements are missing");
    }

    public void myOrderButtonNavigating() {
        Actions action = new Actions(PageFactory.getDriver());
        action.moveToElement(myOrderButton).build().perform();
        WebElement popUpElement;
        try {
            popUpElement = PageFactory.getDriver().findElement(By.xpath("//div[@class = 'navigation__cart']//h2"));
            Assert.assertEquals("Unable to read pop up message correctly",
                    popUpElement.getText(), "Oops, it’s empty here!");
        } catch (NoSuchElementException e) {
            throw new AutotestException("Unable to find the pop up window when navigating to My Oder button");
        }
    }

    public void clickToVerifyPage(String pageName) {
        String pageUrl = "";
        WebElement element = null;
        System.out.println("PAGENAME = " + pageName);
        switch (pageName) {
            case "Facebook": {
                element = facebookLink;
                pageUrl = "https://www.facebook.com/dodopizzamp/";
                break;
            }
            case "Instagram": {
                element = instagramLink;
                pageUrl = "https://www.instagram.com/dodopizzamemphis/";
                break;
            }
            case "Terms and conditions": {
                element = termAndConditionLink;
                pageUrl = "https://docs.google.com/document/d/1Q-6ZCaoZcWhN-EUybJ1RD17_fniEdSyL-cprnja5OYA/edit";
                break;
            }
            case "Dodo Pizza Story": {
                element = dodoPizzaStoryLink;
                pageUrl = "https://dodopizzastory.com/";
                break;
            }
        }
        new WebDriverWait(PageFactory.getDriver(), 5).until(ExpectedConditions.visibilityOf(element));
        new Actions(PageFactory.getDriver()).moveToElement(element).build().perform();
        Set<String> oldWindowsSet = driver.getWindowHandles();
        element.click();
        Set<String> newWindowsSet = driver.getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();
        driver.switchTo().window(newWindowHandle);
        Assert.assertTrue(String.format("Unable to reach %s page; expected: %s, actual: %s ", pageName,
                pageUrl, PageFactory.getDriver().getCurrentUrl()),
                pageUrl.equals(PageFactory.getDriver().getCurrentUrl()));
        driver.switchTo().window(oldWindowsSet.iterator().next());
    }

    public void checkCameraContainer() {
        WebElement element;
        if (getList() != null) {
            //  element = getList().stream().filter(elem -> elem.getText().equals("Live")).
            //  element = getList().g
            // et("List");
            element = PageFactory.getDriver().findElement(By.xpath("//div[@class='navigation__inner']//*[text()='Live']"));
            new Actions(PageFactory.getDriver()).moveToElement(element).build().perform();
            element.click();
        }
        Assert.assertTrue("Cannot find Camera container when the Live button is clicked", isElementPresent(liveButton));
    }

    public void selectPizza(String pizzaName) {
        WebElement pizzaElement;
        try {
            // todo via JSExecutor
            pizzaElement = PageFactory.getDriver().findElement(By.xpath(String.format(pizzaPath, pizzaName)));
            pizzaElement.click();
            Assert.assertTrue("Cannot find the element " + pizzaName, isElementPresent(PageFactory.getDriver().
                    findElement(By.xpath("//span[text()='" + pizzaName + "']"))));
        } catch (NoSuchElementException e) {

        }
    }

    public boolean isElementNotPresent(String xpathLocator) {
        try {
            new WebDriverWait(PageFactory.getDriver(), 5)
                    .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathLocator)));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            new WebDriverWait(PageFactory.getDriver(), 5)
                    .until(ExpectedConditions.visibilityOf(element));
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // todo try to remove this method and use isElementNotPresent for correct work
    public boolean isElementToBeClickable(WebElement element) {
        try {
            new WebDriverWait(PageFactory.getDriver(), 5)
                    .until(ExpectedConditions.elementToBeClickable(element));
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }
}