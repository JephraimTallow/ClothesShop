package com.bjss.clothesStore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {

	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	private WebElement signInLink;
    
    @FindBy(id = "email")
    private WebElement emailInput;
    
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    
    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;
    
    public boolean isPageLoaded(WebDriver driver) {
    	if (!"Login - My Store".equals(driver.getTitle())){
    		return false;
    	}
    	return true;
    }
    public void enterLoginDetails() {
    	emailInput.sendKeys("jephraim.tallow@gmail.com");
    	passwordInput.sendKeys("BJSSTest");
    	loginButton.click();
    }

} 

