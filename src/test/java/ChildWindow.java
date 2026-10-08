import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ChildWindow {
	
	Browser b;
	BrowserContext context;
	Page page;
	
	@BeforeMethod
	public void setup()
	{
		 b=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").
				setSlowMo(2000));
		 context=b.newContext();
		 page=context.newPage();
	     page.setDefaultTimeout(80000);
		 page.navigate("https://rahulshettyacademy.com/loginpagePractise/");
	}
	
	
	@Test
	public void createEvent()
	{
		Page newpage=page.waitForPopup(()->page.getByText("Free Access").click());
		String text=newpage.locator(".red").textContent();
		String email=text.split("at ")[1].split(" ")[0];
		page.bringToFront();
		newpage.bringToFront();
		page.getByLabel("Username").fill(email);
		String name=page.getByLabel("Username").inputValue();
		System.out.println(name);
		newpage.close();
	
		
	}

}
