import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class alerts {
	
	@Test
	public void alerts() {
		
		Browser b=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").
				setSlowMo(2000));
		Page page=b.newPage();
		page.navigate("https://demo.automationtesting.in/Alerts.html#google_vignette");
		/*page.getByText("Alert with OK ").first().click();
		page.onceDialog(dialog->dialog.accept());
		
		page.locator(".btn-danger").click();
		
		page.getByText("Alert with OK ").last().click();
		page.onceDialog(dialog->{
		    System.out.println(dialog.message()); // optional
		    dialog.accept();
		});
		page.locator(".btn-primary").click();*/
		
		page.getByText("Alert with Textbox ").click();
		page.onDialog(dialog->{
			System.out.println("Type: " + dialog.type());       // prompt
		    System.out.println("Message: " + dialog.message()); // prompt message
		    dialog.accept("test");
		    
		});
		

}
}
