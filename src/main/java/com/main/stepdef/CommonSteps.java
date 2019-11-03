package com.main.stepdef;

import com.config.PageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.ru.Когда;
import com.main.pages.MainClassRussianTest;

public class CommonSteps {
    MainClassRussianTest mainTestClass = org.openqa.selenium.support.PageFactory.initElements(PageFactory.getDriver(), MainClassRussianTest.class);

    @Когда("^мы заходим на главную страницу и отключаем куки$")
    public void turnOffCokies() {
        mainTestClass.turnOffCokies();
    }

}
