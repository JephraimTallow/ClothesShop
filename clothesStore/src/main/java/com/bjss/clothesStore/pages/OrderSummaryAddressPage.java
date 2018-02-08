package com.bjss.clothesStore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummaryAddressPage {
	
	@FindBy(xpath = "//*[@id='center_column']/form/p/button/span")
	private WebElement proceedToCheckoutBtn;
	
	public void clickProceedToCheckout() {
		proceedToCheckoutBtn.click();
	}
	
	public WebElement locateProceedToCheckoutBtn() {
		return proceedToCheckoutBtn;
	}
	public void clickProceedToCheckoutBtn() {
		proceedToCheckoutBtn.click();
	}
		
}

