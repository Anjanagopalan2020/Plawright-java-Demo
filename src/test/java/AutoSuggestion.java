import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutoSuggestion {
	
	@Test
	public void autoSuggestion() {
		
		Browser b=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").
				setSlowMo(2000));
		Page page=b.newPage();
	     page.setDefaultTimeout(80000);
	     page.navigate("https://www.google.com/");
	     page.locator("//textarea[@role='combobox']").fill("playwright");
	     Locator options=page.locator("//ul[@role='listbox']/li");
	     System.out.println(options.count());
	     for(int i=0;i<options.count();i++)
	     {
	    	 String name=options.nth(i).textContent();
	    	 System.out.println(name);
	     }
	}

}
