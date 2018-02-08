package com.bjss.clothesStore.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	private WebElement signInLink;
	
    @FindBy(id = "city")
    private WebElement cityInput;
    
    @FindBy(xpath = "//*[@id='root']/div/div[2]/div[1]/span[1]/span[1]")
    private WebElement dayTwoRow;
    
    @FindBy(xpath = "//*[@id='root']/div/div[1]/div[3]")
    private WebElement dayTwoDetail;
    
    public boolean isPageLoaded(WebDriver driver) {
    	if (!"My Store".equals(driver.getTitle())){
    		return false;
    	}
    	return true;
    }
    
    public void clickSignIn() {
    	signInLink.click();
    }
    
    public void setCityName(String cityName) {
    	cityInput.clear();
        cityInput.sendKeys(cityName);
        cityInput.sendKeys(Keys.ENTER);
    }
    
    public void clickDayTwoRow() {
    	dayTwoRow.click();
    }
    
    public String getDayTwoDetails() {
    	return dayTwoDetail.getText();
    }

} 
