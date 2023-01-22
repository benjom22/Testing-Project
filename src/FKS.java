import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
	@DisplayName("Baby Clanstvo Test")
	void BabyClanstvo() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[7]/a")).click();
		Thread.sleep(2000);
		WebElement baby = webDriver.findElement(By.xpath("/html/body/main/section[2]/div[1]/div/div[3]/a"));
		js.executeScript("arguments[0].scrollIntoView(true);", baby);
		Thread.sleep(1000);
		WebElement babyCijena = webDriver.findElement(By.xpath("/html/body/main/section[2]/div[1]/div/div[3]/a/h5"));
		assertEquals("BABY (39,90KM)", babyCijena.getText());
	}

	
	@Order(2)
	@Test
	@DisplayName("Login Test")
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
	@DisplayName("Karte Test")
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
	@DisplayName("Igraci Test")
	void Igraci() throws InterruptedException{
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
	@DisplayName("Performanse Stranice Test")
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
	@DisplayName("Fluent Test")
	void testFluent() {
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
	@DisplayName("Vijesti Test")
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
	@DisplayName("WebShop Dresovi Test")
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
	@DisplayName("FanShop Test")
	void FanShopPrice() throws InterruptedException {
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
		//Akcija je trenutno dresova pa je cijena 922 umjesto 1140
		assertEquals("1140.00 BAM", cijena);
		}
	
	@Order(10)
	@Test
	@DisplayName("Akademija Test")
	void AkademijaPositiveAndNegative() throws InterruptedException {
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
	@DisplayName("Drustvene mreze Test")
	void SocialMediaLinks() throws InterruptedException {

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
    String link = webDriver.getCurrentUrl();
    assertEquals("https://www.facebook.com/FudbalskiklubSarajevo/", link);
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
    String link2 = webDriver.getCurrentUrl();
    assertEquals("https://www.instagram.com/fk_sarajevo/", link2);
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
    String link3 = webDriver.getCurrentUrl();
    assertEquals("https://twitter.com/FK_Sarajevo", link3);
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
    String link4 = webDriver.getCurrentUrl();
    assertEquals("https://www.youtube.com/footballclubsarajevo", link4);
    Thread.sleep(1000);
	}
	
	@Order(12)
	@Test
	@DisplayName("Bordo TV Test")
	void bordoTv() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[8]/a")).click();
		Thread.sleep(500);
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/a")).click();
		Thread.sleep(500);
		System.out.println(webDriver.getTitle());
		assertEquals("Bordo TV: 76. GODINA BORDO KLUBA - FK SARAJEVO SLAVI ROĐENDAN - fksarajevo.ba", webDriver.getTitle());
		Thread.sleep(500);
	}
	
	@Order(13)
	@Test
	@DisplayName("Rezultati Kluba Test")
	void rezultatTabela() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[4]/button")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[4]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		WebElement prviNaTabeli = webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/table/tbody/tr[1]"));
		String klub = prviNaTabeli.getText();
		assertFalse(klub.contains("Sarajevo"));
		assertTrue(klub.contains("Zrinjski"));
	}
	
	@Order(14)
	@Test
	@DisplayName("Clanarina Prijava Test")
	void clanarinaPrijava() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[7]/a")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/main/section[1]/div/div[1]/div[1]/div/a[1]")).click();
		WebElement ime = webDriver.findElement(By.xpath("//*[@id=\"firstName\"]"));
		WebElement prezime = webDriver.findElement(By.xpath("//*[@id=\"lastName\"]"));
		ime.sendKeys("Ahmo");
		Thread.sleep(500);
		prezime.sendKeys("Ahmic");
		Thread.sleep(500);
		Select mjesec = new Select(webDriver.findElement(By.xpath("//*[@id=\"month\"]")));
		mjesec.selectByValue("1");
		Thread.sleep(500);
		WebElement dan = webDriver.findElement(By.xpath("//*[@id=\"day\"]"));
		Thread.sleep(500);
		WebElement godina = webDriver.findElement(By.xpath("//*[@id=\"year\"]"));
		dan.sendKeys("1");
		Thread.sleep(500);
		godina.sendKeys("1946");
		Thread.sleep(500);
		//Ovo nije radilo
		WebElement musko = webDriver.findElement(By.xpath("/html/body/main/div[1]/div[2]/div[2]/form/section/div[2]/div[4]/div/div[1]/label"));
		musko.click();
		Thread.sleep(500);
		WebElement broj = webDriver.findElement(By.xpath("//*[@id=\"cellphone\"]"));
		broj.sendKeys("061 111 111");
		Thread.sleep(500);
		WebElement emailClanstvo = webDriver.findElement(By.xpath("//*[@id=\"email\"]"));
		emailClanstvo.sendKeys("ahmoahmic@gmail.com");
		Thread.sleep(500);
		webDriver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Bulevar MeÅ¡e SelimoviÄ‡a 97");
		Thread.sleep(500);
		webDriver.findElement(By.xpath("//*[@id=\"zip\"]")).sendKeys("71000");
		Thread.sleep(500);
		webDriver.findElement(By.xpath("/html/body/main/div[1]/div[2]/div[2]/form/section/div[4]/div[2]/div")).click();
		Thread.sleep(500);
		webDriver.findElement(By.xpath("/html/body/main/div[1]/div[2]/div[2]/form/section/div[4]/div[2]/div/div[2]/div/div[3]")).click();
		Thread.sleep(500);
		webDriver.findElement(By.linkText("(opširnije)"));
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/main/div[1]/div[2]/div[2]/form/section/button")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//*[@id=\"hideModalAndNext\"]")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"payment_form\"]/section/div[2]/div[2]/div")).click();
		String cijena = webDriver.findElement(By.className("price-info")).getText();
		Thread.sleep(2000);
		assertEquals("15",cijena);
	
	}
 	
	
	@Order(15)
	@Test
	@DisplayName("Sponzor Errea Test")
	void SponzorErrea() throws InterruptedException {
		webDriver.get(baseUrl); 
		WebElement erreaLink = webDriver.findElement(By.xpath("/html/body/nav/div/div[1]/a[2]"));
	    String url = erreaLink.getAttribute("href");
		webDriver.navigate().to(url + "/world/sponsorship");
		webDriver.get(url + "/world/sponsorship"); 
		String source = webDriver.getPageSource();
		System.out.print(source);
		assertTrue(source.contains("FK SARAJEVO"));
		Thread.sleep(1000);
	}
	
	
	
	
	

}
