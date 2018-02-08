package com.bjss.clothesStore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummaryPage {

	@FindBy(xpath = "//*[@id='product_1_3_0_51187']/td[2]/p/a")
	private WebElement product1Name;
	
	@FindBy(xpath = "//*[@id='product_2_7_0_51187']/td[2]/p/a")
	private WebElement product2Name;
	
	@FindBy(xpath = "//*[@id='product_1_3_0_51187']/td[2]/small[2]/a")
	private WebElement product1Size;
	
	@FindBy(xpath = "//*[@id='product_2_7_0_51187']/td[2]/small[2]/a")
	private WebElement product2Size;
	
	@FindBy(xpath = "//*[@id='product_price_1_3_51187']/span")
	private WebElement product1Price;
	
	@FindBy(xpath = "//*[@id='product_price_2_7_51187']/span")
	private WebElement product2Price;
	
	@FindBy(xpath = "//*[@id='total_product']")
	private WebElement productTotal;
	
	@FindBy(xpath = "//*[@id='total_shipping']")
	private WebElement shippingTotal;
	
	@FindBy(xpath = "//*[@id='total_price']")
	private WebElement overallTotal;
	
	@FindBy(xpath = "//*[@id='center_column']/form/p/button/span")
	private WebElement proceedToCheckoutBtnStep3;
	
	@FindBy(xpath = "//*[@id='center_column']/p[2]/a[1]/span")
	private WebElement proceedToCheckoutBtn;
	
	@FindBy(xpath = "//*[@id='cart_navigation']/button/span")
	private WebElement confirmOrderBtn;
	
	public void clickProceedToCheckoutStep3() {
		proceedToCheckoutBtnStep3.click();
	}
	
	public WebElement locateProceedToCheckoutBtnStep3() {
		return proceedToCheckoutBtnStep3;
	}
	public void clickConfirmOrderBtn() {
		confirmOrderBtn.click();
	}
	
	public WebElement locateProceedToCheckoutBtn() {
		return proceedToCheckoutBtn;
	}
	public void clickProceedToCheckoutBtn() {
		proceedToCheckoutBtn.click();
	}
	
	public WebElement getProduct1Name() {
		return product1Name;
	}
	
	public WebElement getProduct2Name() {
		return product2Name;
	}
	
	public WebElement getProduct1Size() {
		return product1Size;
	}
	public WebElement getProduct2Size() {
		return product2Size;
	}
	
	public WebElement getProduct1Price() {
		return product1Price;
	}
	
	public WebElement getProduct2Price() {
		return product2Price;
	}
	
	public WebElement getProductTotal() {
		return productTotal;
	}
	
	public WebElement getShippingTotal() {
		return shippingTotal;
	}
	public WebElement getOverallTotal() {
		return overallTotal;
	}	
}
