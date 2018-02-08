package com.bjss.clothesStore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage {

	@FindBy(xpath = "//*[@id='center_column']/div/div[1]/ul/li[1]/a")
	private WebElement orderHistoryButton;
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
	private WebElement womenLink;
    
    public boolean isPageLoaded(WebDriver driver) {
    	if (!"My account - My Store".equals(driver.getTitle())){
    		return false;
    	}
    	return true;
    }
    public void clickOrderHistory() {
    	orderHistoryButton.click();
    }
    public void clickWomenLink() {
    	womenLink.click();
    }

} 

