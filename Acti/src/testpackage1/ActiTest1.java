package testpackage1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActiTest1 {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	
	
	@BeforeClass
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
	@Test(priority = 2,groups = "Report1")
	public void ReportClick(){
		act.moveToElement(driver.findElement(By.cssSelector("//*[@class=\"content reports\"]"))).click().build().perform();
		//act.moveToElement(driver.findElement(By.xpath("//span[@unselectable][text()=\"Create Chart\"]"))).click().build().perform();		
	}
	@Test(priority = 3,groups = "Report1")
	public void chart() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[10]/div/table/tbody/tr/td/div[3]/div/table/tbody/tr/td[2]/div[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[10]/div/table/tbody/tr/td/div[3]/div/table/tbody/tr/td[2]/input")).sendKeys("Timings Chart");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"createChartLightbox_content\"]/table/tbody/tr/td/div[3]/div/table/tbody/tr/td[3]/div")).click();
		Thread.sleep(4000);
	}
	
	
	@Test
	public void StaffSelection() {
		driver.findElement(By.id("ext-gen585")).click();
		driver.findElement(By.id("ext-gen672")).click();
		WebElement staff= driver.findElement(By.id("ext-gen585"));
		Select s1=new Select(staff);
	}
	@AfterClass
	public void launchBrowser5() {
		
		driver.close();
		
	}

}
