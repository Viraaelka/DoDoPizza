package com.main.stepdef;

import com.config.PageFactory;
import com.main.pages.DodoControl;
import com.main.pages.MainClassRussianTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class DodoControlSteps {
    private WebDriver driver = PageFactory.getDriver();
    public DodoControl dodoControl = org.openqa.selenium.support.PageFactory.initElements(driver, DodoControl.class);

    @And("^проверяем наличие элементов для заполнения на странице$")
    public void checkUpFieldsToFill(DataTable dataTable) {
        dodoControl.checkUpNamesInForm(dataTable);
    }
    @And ("^проверяем наличие элементов на странице$")
    public void checkFields(List<String> filedsList){
        dodoControl.checkFields(filedsList);
    }


}
