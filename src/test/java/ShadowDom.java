import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDom {
	Browser b=null;
	Page p=null;
	@Test
	public void shadow()
	{
		try {
			b=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setSlowMo(3000));
			 p=b.newPage();
			p.navigate("https://testautomationpractice.blogspot.com/");
			//p.locator("#shadow_host").locator("#nested_shadow_host").locator("input[type='text']").fill("test");
			
			p.locator("input[type='text']").fill("Hello");
			
	}
		finally
		{
			b.close();
			p.close();
			
		}
	}

}
