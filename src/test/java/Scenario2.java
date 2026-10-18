import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Scenario2 {
	
	Browser b=null;
	Page p=null;
	@Test
	public void s2()
	{
		try {
			b=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setSlowMo(3000));
			 p=b.newPage();
			p.navigate("https://freelance-learn-automation.vercel.app/login");
			String title=p.title();
			PlaywrightAssertions.assertThat(p).hasTitle("Learn Automation Courses");
			PlaywrightAssertions.assertThat(p.getByText("New user")).isVisible();
			p.getByText("New user").click();
			p.getByPlaceholder("Name").fill("Anjana");
			p.getByPlaceholder("Email").fill("ag10@yopmail.com");
			p.locator("input[name='password']").fill("test123");
			p.locator("//label[text()='Selenium']//preceding::input[@type='checkbox']").click();
			p.locator("//input[@id='gender2']").click();
			p.locator("#state").selectOption("Assam");
			String op[]= {"Playing","Dancing"};
			p.locator("#hobbies").selectOption(op);
			PlaywrightAssertions.assertThat(p.locator("//button[@type='submit']")).isEnabled();
			p.getByText("Sign up").last().click();
			PlaywrightAssertions.assertThat(p.getByText("Signup successfully")).isVisible();
			
			
			
	}
		finally
		{
			b.close();
			p.close();
		}

}
}
