package com.main.hooks;


import com.config.PageFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        new PageFactory().setUp();
    }

    @After
    public void quitDriver() {
        new PageFactory().quitDriver();
    }
}
