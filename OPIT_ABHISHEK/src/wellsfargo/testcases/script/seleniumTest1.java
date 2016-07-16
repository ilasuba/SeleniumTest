package wellsfargo.testcases.script;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class seleniumTest1 {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		//Launch the application
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ila Suba\\Documents\\chromedriver.exe");		
		driver = new ChromeDriver();

	    driver.get("https://www.wellsfargo.com/");

	    System.out.println("Application Launched.");
	    driver.manage().window().maximize();
		 
		  
	    //Verify Page
	    String titleActual = driver.getTitle();
	    System.out.println(titleActual);

	    String titleExpected = "Wells Fargo - Personal & Business Banking - Student, Auto & Home Loans - Investing & Insurance";

	    if(titleActual.equals(titleExpected)){
	    	System.out.println("Verify Title : Pass");
	    }else{
	    	System.out.println("Verify title : fail");
	    }

		System.out.println("Verified Personal Page");

		//About WellsFargo

		Thread.sleep(2000);
		WebElement about = driver.findElement(By.xpath("//div[@id='headerTools']/nav/ul/li[2]/a"));
		about.click();

		 String titAbtActual = driver.getTitle();
		 System.out.println(titAbtActual);

		 String titAbtExp = "About Wells Fargo";

		 if(titAbtActual.equals(titAbtExp)){
		    	System.out.println("About Page : Pass");
		    }else{
		    	System.out.println("About Page : fail");
		    }

		 System.out.println("Verified About Page Page");

		 //Confirm the page heading
		 WebElement heading =  driver.findElement(By.xpath("//div[@id='shell']/div[1]/h1"));
		 String headPageAct = heading.getText();

		String headPageExp = "About Wells Fargo";

		    if(headPageAct.equals(headPageExp)){
		    	System.out.println("Heading Page: Pass");
		    }else{
		    	System.out.println("Heading Page :fail");
		    }

			System.out.println("Verified Heading of the Page");

			//navigate to home page

			WebElement homePage = driver.findElement(By.xpath("//a[@id='tabNavPersonal']"));
			homePage.click();
			System.out.println("Back to Home page");

			//Verify for home page
		WebElement homePageBack = driver.findElement(By.xpath("//div[@id='brand']/a/img"));	
		String homePageTitle = homePageBack.getText();
		String expextedHomepageTitle = "About Wells Fargo";

		if(homePageTitle.equals(expextedHomepageTitle)){
	    	System.out.println("Personal Page: Pass");
	    }else{
	    	System.out.println("Personal Page :fail");
	    }

		System.out.println("I am on Home page Page");
		 	
		//Navigate insurance link

		Thread.sleep(3000);

		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ila Suba\\Documents\\chromedriver.exe");		
		//driver = new ChromeDriver();

		driver = new FirefoxDriver();    
		System.out.println("Application Launched.");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.wellsfargo.com/");

		Thread.sleep(5000);
		WebElement insurance = driver.findElement(By.xpath(".//*[@id='insuranceTab']/a"));
		WebElement HomeownerInsurence = driver.findElement(By.xpath(".//*[@id='insurance']/div[1]/div[2]/ul/li[1]/a"));

		Actions action = new Actions(driver);

		Thread.sleep(5000);
		action.moveToElement(insurance);
		action.perform();

		Thread.sleep(7000);

		action.moveToElement(HomeownerInsurence);
		action.click();
		action.perform();

		//zip code pop up

		WebElement popUp = driver.findElement(By.xpath("//div[@id='c28lightbox']"));
		//System.out.println(popUp.getText());
		popUp.click();

		Thread.sleep(3000);
		WebElement zipCode = driver.findElement(By.xpath("//div[@id='c28lightbox']//div[@class='c28contentContainer']//form[@id='zipStateForm']//div//input[@id='zipCode']"));
		Thread.sleep(30000);
		zipCode.sendKeys("94087");

		WebElement conti = driver.findElement(By.xpath("//div[@id='c28lightbox']//div[@class='c28contentContainer']//form[@id='zipStateForm']//div//input[@value='Continue']"));
		conti.click();

		driver.quit();

	}
}
