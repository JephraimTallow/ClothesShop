package com.bjss.clothesStore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy; 

public class WomenPage {

	@FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
	private WebElement item1Image;
	
	@FindBy(xpath = "//*[@id='center_column']/ul/li[2]/div/div[1]/div/a[1]/img")
	private WebElement item2Image;
	
	@FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[2]/span")
	private WebElement item1QuickView;
    
	@FindBy(xpath = "//*[@id='center_column']/ul/li[2]/div/div[1]/div/a[2]/span")
	private WebElement item2QuickView;
	
    public boolean isPageLoaded(WebDriver driver) {
    	if (!"Women - My Store".equals(driver.getTitle())){
    		return false;
    	}
    	return true;
    }

    public WebElement getItem1Image() {
    	return item1Image;
    }
    public WebElement getItem2Image() {
    	return item2Image;
    }
    public WebElement getImageQuickView() {
    	return item1QuickView;
    }
    public WebElement getImage2QuickView() {
    	return item2QuickView;
    }
    public void clickItem1QuickView() {
    	item1QuickView.click();
    }

} 

