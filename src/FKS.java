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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		webDriver.navigate().back();
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
		@ParameterizedTest
		@CsvFileSource(resources = ".csv")

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
	    String url = webDriver.getCurrentUrl();
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
	
	@Order(8)
	@Test
	void webShopKonfiguratorDresa() throws InterruptedException{
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[9]/a")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/main/section[1]/div/div/div[1]/div/div[3]/a")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/main/section/div/div/a[4]/div[1]/img")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//*[@id=\"add-cart-product\"]/div[3]/div[1]/div[2]/label")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//*[@id=\"add-cart-product\"]/div[3]/div[1]/div[2]/label")).click();
		Thread.sleep(1000);
		Select igrac = new Select(webDriver.findElement(By.xpath("//*[@id=\"choose_player\"]")));
		igrac.selectByVisibleText("Ahmetović 9");
		Thread.sleep(1000);
		Select logo = new Select(webDriver.findElement(By.xpath("//*[@id=\"logo_jersey\"]")));
		logo.selectByValue("all");
		Thread.sleep(1000);
		webDriver.navigate().back();
		Thread.sleep(1000);
		webDriver.navigate().back();
		Thread.sleep(1000);
		webDriver.navigate().back();
		Thread.sleep(1000);
	}
	
	@Order(9)
	@Test
	void testFanShopPrice() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(1000);
		
		webDriver.findElement(By.xpath("/html/body/nav/div/div[2]/div/ul/li[9]/a")).click();
		Thread.sleep(1000);
			
		Select logo = new Select(webDriver.findElement(By.id("logo_jersey")));
		logo.selectByVisibleText("BHTelecom");
		Thread.sleep(1000); 
		
		Select kolicina = new Select(webDriver.findElement(By.id("quantity_jersey")));
		kolicina.selectByVisibleText("10");
		
		String cijena = webDriver.findElement(By.xpath("/html/body/main/section[4]/div/div/div/div[2]/div/div/form/div[6]/span[1]")).getText();
		System.out.println(cijena);
		//Akcija je trenutno dresova pa je cijena 922 umjesto 1140, ne brinite ako vam izbaci error
		assertEquals("1140.00 BAM", cijena);
		}
	
	@Order(10)
	@Test
	void testAkademijaPositiveAndNegative() throws InterruptedException {
	webDriver.get(baseUrl);
	webDriver.manage().window().maximize();
	
	webDriver.findElement(By.xpath("/html/body/nav/div/div[2]/div/ul/li[6]/button")).click();
	Thread.sleep(2000);
	webDriver.findElement(By.xpath("/html/body/nav/div/div[2]/div/ul/li[6]/ul/li[2]/a")).click();
	Thread.sleep(1000);
	
	WebElement kadeti = webDriver.findElement(By.xpath("/html/body/div[3]/div/div[3]/h3[1]"));
	assertEquals("U-19",kadeti.getText());
	assertNotEquals("U-18",kadeti.getText());
	
	WebElement juniori = webDriver.findElement(By.xpath("/html/body/div[3]/div/div[3]/h3[6]"));
	assertEquals("U-14",juniori.getText());
	assertNotEquals("U-13",juniori.getText());
	
	WebElement pioniri = webDriver.findElement(By.xpath("/html/body/div[3]/div/div[3]/h3[10]"));
	assertEquals("U-10",pioniri.getText());
	assertNotEquals("U-9",pioniri.getText());
	}
	
	@Order(11)
	@Test
	void testSocialMediaLinks() throws InterruptedException {

	webDriver.get(baseUrl);
	webDriver.manage().window().maximize();

	//FACEBOOK
	WebElement facebookLink = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[1]/a[1]"));
    String url = facebookLink.getAttribute("href");
    try {
        webDriver.navigate().to(url);
        System.out.println(url + " is working.");
    } catch (Exception e) {
        System.out.println(url + " is not working. ");
    }
    Thread.sleep(1000);
    webDriver.navigate().back();
    Thread.sleep(3000);
    
    //INSTAGRAM
    WebElement instagramLink = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[1]/a[2]"));
    String url1 = instagramLink.getAttribute("href");
    try {
        webDriver.navigate().to(url1);
        System.out.println(url1 + " is working.");
    } catch (Exception e) {
        System.out.println(url1 + " is not working. ");
    }
    Thread.sleep(1000);
    webDriver.navigate().back();
    Thread.sleep(3000);
    
    //TWITTER
    WebElement twitterLink = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[1]/a[3]"));
    String url2 = twitterLink.getAttribute("href");
    try {
        webDriver.navigate().to(url2);
        System.out.println(url2 + " is working.");
    } catch (Exception e) {
        System.out.println(url2 + " is not working. ");
    }
    Thread.sleep(1000);
    webDriver.navigate().back();
    Thread.sleep(3000);
    
    //YOUTUBE
    WebElement youtubeLink = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[1]/a[4]"));
    String url3 = youtubeLink.getAttribute("href");
    try {
        webDriver.navigate().to(url3);
        System.out.println(url3 + " is working.");
    } catch (Exception e) {
        System.out.println(url3 + " is not working. ");
    }
}
	
	
	
	
	

}
