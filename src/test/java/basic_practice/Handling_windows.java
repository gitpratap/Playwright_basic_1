package basic_practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Handling_windows {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser=playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://gmail.com");
		System.out.println(page.title());
		Page popup=page.waitForPopup(()->{

		page.getByText("Help").click();

		});
		popup.waitForLoadState();
		assertThat(popup).hasTitle("Google Account Help");
		System.out.println(popup.title());
		popup.locator("//a[normalize-space(.)='Sign in']").click();
	
	}
	
	
	
	

}
