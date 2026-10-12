package basic_practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.List;

public class Handling_Dropdown {

	public static void main(String[] args) {
		String selectURL = "https://www.lambdatest.com/selenium-playground/select-dropdown-demo";
		String jqueryURL = "https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo";
		//launch browser in below ways or we can go for direct with page also
//		Playwright playwright = Playwright.create();
//		Browser browser =playwright.chromium().launch(new LaunchOptions().setHeadless(false));
//		Page page=browser.newPage();
		
		Page page=Playwright.create().chromium().launch(new LaunchOptions().setHeadless(false)).newPage();
		page.navigate(selectURL);
		page.waitForTimeout(5000);
		Locator daylocator=page.locator("select#select-demo");
	
//  select by value	
		daylocator.selectOption("Wednesday");
		assertThat(page.locator("select#select-demo")).containsText("Wednesday");
// Select by label		
		daylocator.selectOption(new SelectOption().setValue("Friday"));
		assertThat(page.locator("select#select-demo")).containsText("Friday");
	// Select  by index
		daylocator.selectOption(new SelectOption().setIndex(2));
// Select multiple (from multi demo list)
		Locator states=page.locator("select#multi-select");
		states.selectOption(new String[] {"New Jersey", "New York"});
		System.out.println("pass");
		Locator options=states.locator("option");
		System.out.println(options.count());
		List<String> all_states_list=options.allInnerTexts();
		all_states_list.forEach(option -> System.out.println(option));
// Select jquery
		
		page.navigate(jqueryURL);
		Locator country=page.locator("span.select2-container").first();
		country.click();
		Locator results = page.locator("//span[@class='select2-dropdown select2-dropdown--below']", new Page.LocatorOptions().
				setHasText("India"));
		results.click();
		System.out.println("Pass jqury");
		//By jquery value
		Locator files=page.locator("select[name='files']");
		files.selectOption("Ruby");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		 
	
	
	}
}
