package com.bjss.clothesStore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage {

	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/span")
	private WebElement continueShoppingButton;
	
	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
	private WebElement proceedToCheckoutButton;
	
	public void clickContinueShopping() {
		continueShoppingButton.click();
	}

	public void clickProceedToCheckout() {
		proceedToCheckoutButton.click();
	}
}
