package com.main.stepdef;

import com.config.PageFactory;
import com.main.pages.DodoControl;
import com.main.pages.MainTestClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class MysteryShopperSteps {
    DodoControl dodoControl = new DodoControl();

    @And("^checking that following elements are present of the form$")
    public void checkUpNamesInForm(DataTable dataTable){
        dodoControl.checkUpNamesInForm(dataTable);
    }

    @And("^filling up the \"Mistery Shopper\" form$")
    public void fillUpForm(DataTable dataTable){
        Map<String, String> mapForm = dataTable.asMap(String.class, String.class);
        mapForm.forEach((k, v) -> {

        });
    }
}
