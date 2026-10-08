import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Scenario1 {
	
	Browser b=null;
	Page p=null;
	@Test
	public void s1()
	{
		
		try {
		b=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setSlowMo(3000));
		 p=b.newPage();
		p.navigate("https://freelance-learn-automation.vercel.app/login");
		String title=p.title();
		PlaywrightAssertions.assertThat(p).hasTitle("Learn Automation Courses");
		
        p.getByPlaceholder("Enter Email").fill("admin@gmail.com");
        p.locator("input[name='password1']").fill("admin123");
        p.getByText("Sign in").last().click();
        PlaywrightAssertions.assertThat(p.getByText("Welcome")).isVisible();
        Locator cards=p.locator("//div[@class='home-container']/div");
        int count=cards.count();
        System.out.println(count);
        Assert.assertTrue(count>0);
        Locator buttons=p.locator("//div[@class='social-btns']/a");
        int bcount=buttons.count();
        System.out.println(bcount);
        Assert.assertTrue(bcount>0);
        
		}
		
		finally
		{
			b.close();
			p.close();
		}
	

	}

}

