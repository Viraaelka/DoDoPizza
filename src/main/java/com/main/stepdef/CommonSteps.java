package com.main.stepdef;

import com.config.PageFactory;
import com.main.pages.MainTestClass;
import io.cucumber.java.en.And;

public class CommonSteps {
    // MainTestClass mainTestClass = org.openqa.selenium.support.PageFactory.initElements(PageFactory.getDriver(), MainTestClass.class);

    @And("^checking that titles match$")
    public void checkTitle(){

    }

    /**
     * Initialize a page with corresponding title that is defined via @PageEntry
     *
     * @param title
     */
    @And("^opening the page \"([^\"]*)\"$")
    public void openPage(String title) throws Exception{
        for(String windowHandle : PageFactory.getDriver().getWindowHandles()){
            PageFactory.getDriver().switchTo().window(windowHandle);
        }
        PageFactory.getInstance().getPage(title);
    }

}
