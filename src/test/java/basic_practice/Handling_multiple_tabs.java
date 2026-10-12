package basic_practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Handling_multiple_tabs {
	
public static void main(String[] args) {
	Browser browser = Playwright.create().chromium().launch();
	BrowserContext context= browser.newContext(); 
	Page page=context.newPage();
	page.navigate("https://freelance-learn-automation.vercel.app/login");
	Page newPage = context.waitForPage(()->{
	page.locator("//div[@class='container-child']//a[4]//*[name()='svg']").click();
	});
	newPage.locator("//input[@name='email']").last().fill("xyz@gmial.com");
	


}
	 
}
