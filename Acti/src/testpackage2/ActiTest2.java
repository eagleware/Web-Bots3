package testpackage2;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActiTest2 {

	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	
	
	@BeforeClass(groups="Report1")
	public void launchBrowser1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\Selenium JAR\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demo.actitime.com/user/submit_tt.do");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 40);
		
	}
	@Test(priority = 1,groups = "Report1")
	public void LoginCredentials() throws InterruptedException {		 	
		driver.findElement(By.cssSelector("input#username")).sendKeys("admin");
		//Thread.sleep(2000);
		driver.findElement(By.name("pwd")).sendKeys("manager");
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton"))).click();
		//Thread.sleep(10000);
	

	}
	@Test(priority=2,groups="Report1")
	public void Create_new_task() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[19]/form/table/tbody/tr/td/table[1]/tbody/tr[3]/td[1]/table/tbody/tr/td[7]/div")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("/html/body/div[29]/div/div[1]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/div/div[1]/div[1]/div")).click();
		Thread.sleep(10000);
		List<WebElement> list =driver.findElements(By.xpath("//div[@class='scrollableDropdownView']//div/descendant::div[@class='itemRow ']"));
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			Thread.sleep(4000);
			System.out.println(list.get(i).getText());
			Thread.sleep(4000);
			if(list.get(i).getText().contains("- New Customer -")) {
				Thread.sleep(4000);
				list.get(i).click();
				Thread.sleep(4000);
				break;
			}
		}
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[contains(@class,'newCustomer ')and contains(@class,'newCustomerProjectField')]")).sendKeys("Milan");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[contains(@class,'newProject')][contains(@placeholder,'Enter')]")).sendKeys("ActiTime");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//td[contains(@class,'nameCell')]/input[@type='text'][@class='inputFieldWithPlaceholder']")).sendKeys("Hjgh");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//td[@class='estimateCell']/input[@type='text']")).sendKeys("12:00");
			Thread.sleep(5000);
	
		}
		
 
	@Test(priority=3,groups="Report1")
	public void Enter_Customer () throws InterruptedException {
		
		driver.findElement(By.xpath("//td[@class='x-btn-center']/em[@unselectable='on']/button[contains(@class,'x-btn-text') and contains(@id,'ext-gen34')]")).click();
		Thread.sleep(2000);
		String Expected_month = "March 2019";
		String Current_month = driver.findElement(By.xpath("//tr[@id='ext-gen97']/td[@class='x-btn-center']/em[@unselectable='on']/button[@class='x-btn-text']")).getText();
		System.out.println(Expected_month);
		System.out.println(Current_month);
		for(int i=1;i<12;i++) {
			Thread.sleep(50);
			driver.findElement(By.xpath("//td[@class='x-date-right']/a[@id='ext-gen79']")).click();
			Thread.sleep(1000);
			if(Expected_month.equals(Current_month)) {
				System.out.println("Month Selected");
				break;
			}
			
		}
		Thread.sleep(4000);
		
		WebElement datepicker = driver.findElement(By.xpath("//td[@colspan='3']/table[@class='x-date-inner']/tbody/tr[5]"));
		List<WebElement> dates=datepicker.findElements(By.xpath("//td[@colspan='3']/table[@class='x-date-inner']/tbody/tr[5]//span"));
		System.out.println(dates);
		for(WebElement date : dates ) {
			String calDate=date.getText().toString();
			Thread.sleep(2000);
			if(calDate.equals("22")) {
				date.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//div[@class='commitButtonPlaceHolder']/div[contains(@class,'components_button withPlusIcon')]/div[@class='components_button_label']")).click();

	}
	@AfterClass(groups="Report1")
	public void closebrowser() {
		driver.close();
	}
}

		

   
