package com.bjss.clothesStore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuickViewPage {

	@FindBy(css = "#add_to_cart > button")
	private WebElement addToCartButton;
	
	@FindBy(css = "#group_1")
	private WebElement sizeDropDown;
	
    public WebElement getSizeDropDown() {
    	return sizeDropDown;
    }
    
    public void clickAddToCartButton() {
    	addToCartButton.click();
    }
}
