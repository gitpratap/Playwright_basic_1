package basic_practice;

import java.nio.file.Paths;
import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ScreenshotCaret;


public class Handle_Screenshot {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium()
                .launch(new LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        // Navigate to the page
        page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        // Full page screenshot
        Page.ScreenshotOptions screenshotOptions = new Page.ScreenshotOptions()
                .setPath(Paths.get("./snaps/src.png"))
                .setFullPage(true);
        // page screenshot
        page.screenshot(screenshotOptions);
        // locator screenshot
        Locator bookBtn=page.locator("//button[@class='chfw-header_demo_btn']");
        bookBtn.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./snaps/locator.png")));
		//masking locator while screenshot
        Locator input=page.locator("input#user-message");
        input.type("Something");
        input.scrollIntoViewIfNeeded();      //setfullpage(false) for partial SS not full page
        page.screenshot(screenshotOptions.setPath(Paths.get("./snaps/input.png")).setFullPage(false)
        		.setMask(Arrays.asList(input)));
		//caret show/hide
		input.click();
		page.screenshot(
			    new Page.ScreenshotOptions()
			        .setCaret(ScreenshotCaret.HIDE)
			        .setPath(Paths.get("./snaps/CaretHide.png"))
			);

			page.screenshot(
			    new Page.ScreenshotOptions()
			        .setCaret(ScreenshotCaret.INITIAL)
			        .setPath(Paths.get("./snaps/caretinit.png"))
			);
page.close();
		playwright.close();
		
		
	}
	
}
