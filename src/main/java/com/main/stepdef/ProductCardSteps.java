package com.main.stepdef;

import com.config.PageFactory;
import com.main.pages.ProductCard;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ProductCardSteps {
    ProductCard productCard = org.openqa.selenium.support.PageFactory.initElements(PageFactory.getDriver(), ProductCard.class);

    @And("^checking the size and the kind of pastry$")
    public void checkSizeAndPastry(DataTable dataTable){
        productCard.checkSizeAndPastry(dataTable);
    }

    @And("^changing the size of the pizaa to \"([^\"]*)\"$")
    public void changePizzaDiameter(String size){
        productCard.changePizzaDiameter(size);
    }

    @And("^adding the pizza to cart$")
    public void addProductToCart(){
        productCard.addProductToCart();
    }

    @Then("^the amount of pizza added equals \"([^\"]*)\"$")
    public void checkPizzaAmount(String pizzaAmount){
        productCard.checkPizzaAmount(pizzaAmount);
    }
}
