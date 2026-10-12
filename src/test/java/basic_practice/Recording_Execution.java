package basic_practice;

	
	import com.microsoft.playwright.*;
	import com.microsoft.playwright.options.*;
	import com.microsoft.playwright.Browser.NewContextOptions;
	import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.*;

	public class Recording_Execution {
	  public static void main(String[] args) {
	    Playwright playwright = Playwright.create(); {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
	      Page page = context.newPage();
	      page.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
	      Locator myaccount= page.locator("//a[contains(.,'My account')][@role='button']");
			myaccount.hover();
			page.locator("//a[contains(.,'Login')]").click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail Address")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail Address")).fill("koushik350@gmail.com");
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("Pass123$");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
	      page.locator(".col-6").first().click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit your account")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name*")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name*")).fill("Chatter");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
	      Locator sucessMessage=page.getByText("Success: Your account has");
	      assertThat(sucessMessage).isVisible();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout").setExact(true)).click();
	      Locator logoutElement=page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(" Account Logout"));
	      assertThat(logoutElement).isVisible();
	      page.close();
	      context.close();
	      browser.close();
	      playwright.close();	      
	    }
	  }
	}


