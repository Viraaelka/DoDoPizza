package com.main.stepdef;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class StepDefinition {
    private WebDriver webdriver;

    @Given("^some map of values$")
    public void givenMap(Map<String, Integer> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

}
