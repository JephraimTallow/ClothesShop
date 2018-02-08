package com.bjss.clothesStore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummaryPaymentPage {
	
	@FindBy(xpath = "//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")
	private WebElement payByWireBtn;
	
	public void clickPayByWireBtn() {
		payByWireBtn.click();
	}
	public WebElement locatePayByWireBtn() {
		return payByWireBtn;
	}
}

