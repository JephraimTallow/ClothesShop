package com.bjss.clothesStore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummaryShippingPage {
	
	//*[@id="form"]/p/button/span
	@FindBy(xpath = "//*[@id='form']/p/button/span")
	private WebElement proceedToCheckoutBtn;
	
	@FindBy(id = "cgv")
	private WebElement termsAndConditionsCheck;
	
	@FindBy(xpath = "//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")
	private WebElement payByWireBtn;
	
	public void clickProceedToCheckout() {
		proceedToCheckoutBtn.click();
	}
	
	public WebElement locateProceedToCheckoutBtn() {
		return proceedToCheckoutBtn;
	}
	public void clickProceedToCheckoutBtn() {
		proceedToCheckoutBtn.click();
	}
	public void clickPayByWireBtn() {
		payByWireBtn.click();
	}
	
	public boolean isTermsAndConditionsChecked() {
		return termsAndConditionsCheck.isSelected();
	}
	
	public void toggleTermsAndConditions() {
		termsAndConditionsCheck.click();
	}
}

