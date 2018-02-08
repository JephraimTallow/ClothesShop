package com.bjss.clothesStore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaseSteps {
	
	protected List<ClothingItem> shoppingCartList = new ArrayList<>();
	
    protected void threadSleep(int seconds) {
    	// Wait required for iFrame to show. 
    	// TODO WebDriverWait does not work here, so using Thread sleep - will investigate further given time...
    	try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Add proper logging here - not just a default stack trace
			e.printStackTrace();
		}
    }
	public BigDecimal convertPriceToDecimal(String priceString) {
		return new BigDecimal(priceString.substring(priceString.indexOf("$") + 1));
	}
}
