import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

@TestMethodOrder(OrderAnnotation.class)
class FKS {
	
	static WebDriver webDriver;
	static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\benjo\\Desktop\\chromedriver_win32\\chromedriver.exe");
		webDriver=new ChromeDriver();
		webDriver.manage().window().maximize();
		baseUrl="https://fksarajevo.ba/";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Order(1)
	@Test
	void Clanstvo() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[7]/a")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/a")).click();
		Thread.sleep(1000);
	}
	
	/*@Order(2)
	@Test
	void ClanarinaPrijava() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[7]/a")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/main/section[1]/div/div[1]/div[1]/div/a[2]")).click();
		WebElement ime = webDriver.findElement(By.xpath("//*[@id=\"firstName\"]"));
		WebElement prezime = webDriver.findElement(By.xpath("//*[@id=\"lastName\"]"));
		ime.sendKeys("Ahmo");
		Thread.sleep(2000);
		prezime.sendKeys("Ahmic");
		Thread.sleep(2000);
		Select mjesec = new Select(webDriver.findElement(By.xpath("//*[@id=\"month\"]")));
		mjesec.selectByValue("1");
		Thread.sleep(2000);
		WebElement dan = webDriver.findElement(By.xpath("//*[@id=\"day\"]"));
		Thread.sleep(2000);
		WebElement godina = webDriver.findElement(By.xpath("//*[@id=\"year\"]"));
		dan.sendKeys("1");
		Thread.sleep(2000);
		godina.sendKeys("1946");
		Thread.sleep(2000);
		WebElement musko = webDriver.findElement(By.id("male"));
		musko.click();
		Thread.sleep(2000);
		WebElement broj = webDriver.findElement(By.xpath("//*[@id=\"cellphone\"]"));
		broj.sendKeys("061 111 111");
		Thread.sleep(2000);
		WebElement emailClanstvo = webDriver.findElement(By.xpath("//*[@id=\"email\"]"));
		emailClanstvo.sendKeys("ahmoahmic@gmail.com");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"place-municipality\"]/div/div[1]/div/div")).click();
		WebElement opstina = webDriver.findElement(By.xpath("//*[@id=\"place-municipality\"]/div/div[2]/input"));
		opstina.sendKeys("Novi Grad Sarajevo");
		Thread.sleep(2000);
		

	}*/
	
	@Order(2)
	@Test
	void Prijava() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("//*[@id=\"header-top\"]/div/div[1]/a[5]")).click();
		Thread.sleep(2000);
		WebElement email = webDriver.findElement(By.name("email"));
		WebElement password = webDriver.findElement(By.name("password"));
		email.sendKeys("benjom@bih.net.ba");
		password.sendKeys("ha10be14");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"web-login\"]/div[2]/div/div[2]/div/div/form/div[3]/button")).click();
		Thread.sleep(1000);
		String bodovi = webDriver.findElement(By.xpath("/html/body/div[3]/span/span")).getText();		
	    assertTrue(bodovi.equals("84"));
	    Thread.sleep(1000);
	    webDriver.findElement(By.xpath("//*[@id=\"header-top\"]/div/div[1]/div/button")).click();
	    Thread.sleep(1000);
	    webDriver.findElement(By.xpath("//*[@id=\"header-top\"]/div/div[1]/div/ul/li[3]/a")).click();
	    Thread.sleep(1000);

	}
	
	@Order(3)
	@Test
	void Karte() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/button")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/ul/li[1]/a")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//*[@id=\"single-article\"]/div/div[3]/p[2]/em/a")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/nav/div/a")).click();
		Thread.sleep(1000);
	}
	
	
	

	@Order(4)
	@Test
	void igraci() throws InterruptedException{
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/button")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/ul/li[1]/a")).click();
		Thread.sleep(1000);
		String mersudin = webDriver.findElement(By.xpath("/html/body/div[2]/div[5]/div[2]/div/div[4]/div[1]")).getText();
		assertEquals(mersudin, "MERSUDIN");
		Thread.sleep(1000);
	}
	
	@Order(5)
	@Test
	  public void testPagePerformance() {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();

	    // Get the time it took for the page to fully load
	    long loadTime = (Long) ((JavascriptExecutor) webDriver).executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");

	    // Check if the load time is within an acceptable range (e.g. less than 5000 milliseconds)
	    if (loadTime > 5000) {
	      throw new AssertionError("Page load time was not within acceptable range. Actual load time: " + loadTime + "ms");
	    }
	  }
	
	@Order(6)
	@Test
	void tesFluent() {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();

		//WebDriverWait wait = new WebDriverWaitWebDriverr, Duration.ofSeconds(5));
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(webDriver);
		
		wait.withTimeout(Duration.ofSeconds(5));
		wait.pollingEvery(Duration.ofMillis(250));
		
		
		String element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.xpath("/html/body/div[1]/div/span")
					)
			).getText();

		assertEquals("ZVANIČNA STRANICA FK SARAJEVO",element);
	}
	
	@Order(7)
	@Test
	void Vijesti() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("//*[@id=\"highlighted-news\"]/div[1]/div[2]/a/div[2]")).click();
		Thread.sleep(2000);
		String vijesti = webDriver.findElement(By.xpath("//*[@id=\"single-article\"]/div[2]/div[1]/h5")).getText();
		assertEquals(vijesti, "VIJESTI");
		Thread.sleep(2000);
	}
	
	

}
