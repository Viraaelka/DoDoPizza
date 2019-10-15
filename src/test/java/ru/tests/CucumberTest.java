package ru.tests;

import cucumber.api.CucumberOptions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
/*
@RunWith(Cucumber.class) //inherit Cucumber class from io.cucumber.junit.Cucumber -> "<artifactId>cucumber-java</artifactId>"
@CucumberOptions(monochrome = true,
        features = {"src/test/ru.tests/features"},
        glue = {"ru.tests, com.main"},
        tags = {"@test"}
)
public class CucumberTest {
    @BeforeClass
    public static void beforeSetup(){
        new BeforeAfterSetup().setUp();
    }
    @AfterClass
    public static void afterClassAction(){
        new BeforeAfterSetup().tearDown();
    }
}*/