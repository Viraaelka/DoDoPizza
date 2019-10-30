package com.main.stepdef;

import com.config.PageFactory;
import com.main.pages.DodoControl;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class DodoControlSteps {
    DodoControl dodoControl = org.openqa.selenium.support.PageFactory.initElements(PageFactory.getDriver(), DodoControl.class);

    @And("^проверяем наличие элементов на странице$")
    public void checkUpNamesInForm(List<String> dataTable){
        dodoControl.checkUpNamesInForm(dataTable);
    }

}
