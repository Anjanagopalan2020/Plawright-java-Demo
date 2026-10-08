import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Locator.FilterOptions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

public class Demo {
	
	
	
	
	@Test
	public void createEvent()
	{
		Browser b=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").
				setSlowMo(2000));
		Page page=b.newPage();
	     page.setDefaultTimeout(80000);
		 page.navigate("https://eventhub.rahulshettyacademy.com/");
		 page.getByLabel("Email").fill("at@yopmail.com");
		 page.getByLabel("Password").fill("Test@123");
		 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Admin")).click();
		 page.getByText("Manage Events").first().click();
		 page.getByLabel("Title").fill("Test event");
		 page.locator("#category").selectOption("Sports");
		 page.getByLabel("City").fill("Bangalore");
		 page.getByLabel("Venue").fill("test Venue");
		 page.getByLabel("Event Date & Time").fill("2026-11-22T12:45");
		 page.getByPlaceholder("0.00").fill("2000");
		 page.locator("#total-seats").fill("50");
		 page.getByTestId("add-event-btn").click();
		 
		 PlaywrightAssertions.assertThat(page.getByText("Event created")).isVisible();
		 
		 page.getByTestId("nav-events").click();
		 Locator cards=page.getByTestId("event-card");
		 System.out.println(cards.count());
		 Locator target=cards.filter(new FilterOptions().setHasText("Test event"));
		 String seats=target.getByText("seats").innerText();
		 System.out.println(seats);
		 
		 
	}

}
