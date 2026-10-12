package basic_practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Interactwith_Input {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		page.locator("input#user-message").type("Hey Tester");
		page.waitForTimeout(2000);
		page.locator("id=showInput").click();
		String message=page.locator("#message").textContent();
		System.out.println(message);
		assertThat(page.locator("#message")).hasText("Hey Tester");
		
		//type vs fill
		
		page.navigate("https://www.testmuai.com/selenium-playground/generate-file-to-download-demo/");
		page.locator("#textbox").fill("I would review the requirement/SRS and acceptance criteria. If my expected behavior is supported by the requirement, I would discuss it with the developer/BA/Product Owner during defect triage. If the requirement confirms the developer's behavior, I would close/update the defect accordingly.");
		
		// Get the input values
		try {
		    page.navigate("https://letcode.in/edit");

		    String inputValue = page.locator("#getMe").inputValue();
		    System.out.println(inputValue);

		    Locator fullnameLocator = page.locator("#fullName");

		    String placeholder = fullnameLocator.getAttribute("placeholder");
		    System.out.println(placeholder);

		    assertThat(fullnameLocator)
		        .hasAttribute("placeholder", "Enter first & last name");

		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}

		// Check / uncheck checkbox
		page.navigate("https://www.lambdatest.com/selenium-playground/checkbox-demo");

		Locator isAge = page.locator("#isAgeSelected");

		assertThat(isAge).isChecked();

		isAge.check();

		assertThat(isAge).isChecked();

		playwright.close();

		
		
		
		
		
		
		
		
		
	
	}
	
}
