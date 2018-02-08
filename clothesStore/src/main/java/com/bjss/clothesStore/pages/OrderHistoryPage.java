package com.bjss.clothesStore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage {

	@FindBy(xpath = "//*[@id='order-list']/tbody/tr[1]/td[1]/a")
	private WebElement firstHistoryItem;
	
	@FindBy(name = "id_product")
	private WebElement productSelect;

	@FindBy(xpath = "//*[@id='sendOrderMessage']/div/button")
	private WebElement sendMessageBtn; 

	@FindBy(xpath = "//*[@id='block-order-detail']/table")
	private WebElement summaryTable;
	
	@FindBy(xpath = "//*[@id='sendOrderMessage']/p[3]/textarea")
	private WebElement commentBox;
	
	@FindBy(xpath = "//*[@id='block-order-detail']/div[5]/table/tbody")
	private WebElement submittedCommentsTable;
	
	public WebElement locateSubmittedCommentsTable() {
		return submittedCommentsTable;
	}
	
	
	public void addComments(String comments) {
		commentBox.sendKeys(comments);
	}
	
	public WebElement locateSummaryTable() {
		return summaryTable;
	}
	
	public WebElement locateProductSelect() {
		return productSelect;
	}
	
	public void clickSendMessageBtn() {
		sendMessageBtn.click();
	}
	
	public void clickFirstHistoryItem() {
		firstHistoryItem.click();
	}
}
