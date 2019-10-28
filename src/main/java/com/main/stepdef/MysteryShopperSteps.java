package com.main.stepdef;

import com.config.PageFactory;
import com.main.pages.DodoControl;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;

public class MysteryShopperSteps {
    DodoControl dodoControl = org.openqa.selenium.support.PageFactory.initElements(PageFactory.getDriver(), DodoControl.class);


    @And("^checking that following elements are present of the form$")
    public void checkUpNamesInForm(List<String> dataTable){
        dodoControl.checkUpNamesInForm(dataTable);
    }

    @And("^filling up the \"Mistery Shopper\" form$")
    public void fillUpForm(DataTable dataTable){
        Map<String, String> mapForm = dataTable.asMap(String.class, String.class);
        mapForm.forEach((k, v) -> {

        });
    }
}
