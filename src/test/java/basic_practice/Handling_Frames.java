package basic_practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Handling_Frames {
	
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		BrowserType browsertype=playwright.chromium();
		Page page=browsertype.launch(new LaunchOptions().setHeadless(false)).newPage();
		page.navigate("https://jqueryui.com/");
		page.locator("//a[normalize-space()='Droppable']").click();
		FrameLocator framelocator=page.frameLocator("#mce_0_ifr");
		Locator bodylocator=framelocator.locator("body");
		bodylocator.click();
		bodylocator.clear();
		bodylocator.fill("Hey, This bhanupratap writing playwright script");
	
	
	
	
	}
	
		
	  

}
