package com.main.pages;

import com.config.PageFactory;
import com.main.exceptions.AutotestException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class WrapperPage {
    private WebDriver driver = PageFactory.getDriver();

    @FindBy(xpath = "//button[text()='My order']")
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

    List<WebElement> navigationList;

    public String[] navigationNames = {"Pizza", "Snacks", "Desserts", "Drinks", "Deals", "Store info", "Live"};

    public WrapperPage(WebDriver driver) {
        this.driver = driver;
    }

    public void turnOffCokies() {
        PageFactory.getDriver().findElement(By.xpath("//div[@class='cookie-policy']//button")).click();
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
        new Actions(PageFactory.getDriver()).moveToElement(liveButton).build().perform();
        liveButton.click();

    }
}