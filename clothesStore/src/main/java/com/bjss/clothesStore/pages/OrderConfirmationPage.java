package com.bjss.clothesStore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage {

	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	private WebElement signOutLink;
	
    public boolean isPageLoaded(WebDriver driver) {
    	if (!"Order confirmation - My Store".equals(driver.getTitle())){
    		return false;
    	}
    	return true;
    }

    public WebElement locateSignOutLink() {
    	return signOutLink;
    }
    public void clickSignOutLink() {
    	signOutLink.click();
    }
} 
