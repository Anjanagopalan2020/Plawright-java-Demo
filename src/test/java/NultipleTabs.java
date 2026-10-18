import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NultipleTabs {
	
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
		 page.navigate("https://freelance-learn-automation.vercel.app/login");
	}
	
	
	@Test
	public void multipleWindow()
	{
		Locator pages=page.locator("//div[@class='social']//a");
		
		for(int i=0;i<pages.count();i++)
		{
			pages.nth(i).click();
		}
		
		List<Page>p=context.pages();
		
		for(Page p1:p)
		{
			if(p1.title().contains("Facebook"))
			{
				p1.getByText("Email").fill("anjana@gmail.com");
				break;
			}
		}
		
		page.getByPlaceholder("Enter Email").fill("at@yopmail.com");
	    
		context.close();
		b.close();
		
	}

}
