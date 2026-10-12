package basic_practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Login_Logout {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser broswer =playwright.chromium().launch(new LaunchOptions().setHeadless(false)); 
		Page page=broswer.newPage();
		page.navigate("https://ecommerce-playground.lambdatest.io/index.php");
		Locator myaccount= page.locator("//a[contains(.,'My account')][@role='button']");
		myaccount.hover();
		page.locator("//a[contains(.,'Login')]").click();
		assertThat(page).hasTitle("Account Login");
		page.getByPlaceholder("E-Mail Address").type("koushik350@gmail.com");
		page.getByPlaceholder("Password").type("Pass123$");
		page.locator("//input[@value='Login']").click();
		assertThat(page).hasTitle("My Account");
		page.close();
		broswer.close();
		playwright.close();
	}
	
}
