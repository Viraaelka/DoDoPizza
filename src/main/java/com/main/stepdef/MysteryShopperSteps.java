package com.main.stepdef;

import com.main.pages.DodoControl;
import com.main.pages.MainTestClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.Map;

public class MysteryShopperSteps {
    DodoControl dodoControl = new DodoControl();

    @And("^And filling up the \"Mistery Shopper\" form$")
    public void fillUpForm(DataTable dataTable){
        Map<String, String> mapForm = dataTable.asMap(String.class, String.class);
        mapForm.forEach((k, v) -> {

        });
    }
}
