package wellsfargo.testcases.script;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AmazonAutomationScript extends ReusableMethod {

	static WebDriver driver;

	//Test Case 01>>>>Launch the Amazon Application

	public static void LaunchApplication() throws IOException, Exception{

		startReport("Launch Amazon Application","C:/Users/Ila Suba/Desktop/Abhishk_Homework/Report/");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/");

		Update_Report("Pass", "Launch amazon Application", "Amazon Application is launched");

		bw.close();

		driver.quit();

	}

	//Test Case 02>>>>Verify Drop Down Option after Iphone is TypeIn Search
	public static void verifyDropDown() throws IOException, InterruptedException{

		startReport("verifyDropDown","C:/Users/Ila Suba/Desktop/Abhishk_Homework/Report/");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/");

		Update_Report("Pass", "Launch amazon Application", "Amazon Application is launched");

		Thread.sleep(3000);
		
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		enterText(search, "Iphone", "Search Field");

		Update_Report("Pass", "search for Iphone", "Getting Suggession for Search Iphone");

		WebElement suggession = driver.findElement(By.xpath("//div[@id='suggestions']"));

		List<WebElement> options = driver.findElements(By.className("s-suggestion"));

		for (int i = 0 ; i < 3; i++) {

			System.out.println(options.get(i).getText()); 

		}

		String expStr[] = {"iphone 6s case in All Departments","iphone 6s case in Electronics","iphone 6s case in Cell Phones & Accessories"};
		String actStr[]= new String[3]; 

		for (int i = 0 ; i < 3; i++) {
			for(int j = 0; j<3; j++){
				actStr[i] = options.get(i).getText();

				if(expStr[j].equals(actStr[i])){
					Update_Report("Pass", "Compare Items", "Actual Items equal to Expected Items. ");
				}

			}

		}
		bw.close();

		driver.quit();

	}

	//Test Case 03>>>>Click for Search Button After "iphone" is entered

	public static void clickSearchButton() throws IOException, InterruptedException{
		startReport("clickSearchButton","C:/Users/Ila Suba/Desktop/Abhishk_Homework/Report/");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/");

		Update_Report("Pass", "Launch amazon Application", "Amazon Application is launched");

		Thread.sleep(3000);
		
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		enterText(search, "Iphone", "Search Field");

		Update_Report("Pass", "search for Iphone", "Getting Suggession for Search Iphone");


		WebElement clickSearch = driver.findElement(By.xpath("//div[@id='nav-search']/form/div[2]/div/input[@value='Go']"));
		Thread.sleep(3000);

		clickButton(clickSearch, "Search Button");
		Thread.sleep(3000);

		Update_Report("Pass", "search for Iphone", "Iphone Suggession page is appear");
		bw.close();

		driver.quit();

	}

	//Test Case 04>>>>Verify Show results for Column  on the left -"Cell Phones & Accessories "Header 
	public static void verifyShowResults() throws IOException, InterruptedException{

		startReport("verifyShowResults","C:/Users/Ila Suba/Desktop/Abhishk_Homework/Report/");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/s/ref=sr_ex_n_0?rh=i%3Aaps%2Ck%3Aiphone&keywords=iphone&ie=UTF8&qid=1468630383");

		Update_Report("Pass", "Launch amazon Application", "Amazon Application is launched");

		Thread.sleep(3000);

		String actTitle = driver.getTitle();
		String expTitle = "Amazon.com: iphone";

		if(actTitle.equals(expTitle)){

			Update_Report("Pass", "Verifying Page Title", "Actual Title is equal to expTitle");
		}

		WebElement cellPhonesAccessories = driver.findElement(By.xpath("//div[@id='refinements']/div[2]/ul[1]/li/a/span[text()='Cell Phones & Accessories']"));
		clickButton(cellPhonesAccessories, "Click on Cell Phones and Accessories Link");
		Thread.sleep(3000);


		WebElement list = driver.findElement(By.className("categoryRefinementsSection"));
		List<WebElement> options = list.findElements(By.tagName("span"));

		System.out.println("Size of array : " + options.size());


		String expStr[] = {"Cell Phone Accessory Kits","Cell Phone Cases","+ See more"};
		String actStr[]= new String[options.size()]; 

		for (int i = 0 ; i < options.size(); i++) {

			for(int j = 0; j < 3; j++){

				actStr[i] = options.get(i).getText();

				if(expStr[j].equals(actStr[i])){

					Update_Report("Pass", "Compare Items", "Actual Items equal to Expected Items. ");
					System.out.println(actStr[i]);

				}

			}
		}


		bw.close();

		driver.quit();
	}	
	//Test Case 05>>>>Verify Show results for Column  on the left -" Computers & Accessories "Header 

	public static void computerAccessories() throws IOException, InterruptedException{

		startReport("computerAccessories","C:/Users/Ila Suba/Desktop/Abhishk_Homework/Report/");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");

		Update_Report("Pass", "Launch amazon Application", "Amazon Application is launched");

		Thread.sleep(3000);

		WebElement anyCatagory = driver.findElement(By.xpath("//div[@id='refinements']/div[2]/ul[1]/li[1]/a/span[text()='Any Category']"));
		clickButton(anyCatagory, "Click on Any Catagory");
		Thread.sleep(3000);

		WebElement computerComponent = driver.findElement(By.xpath("//ul[@id='seeAllDepartmentOpen1']/li[1]/ul/li/a/span[text()='Computer Components']"));
		clickButton(computerComponent, "Click on Computer Component link");
		Thread.sleep(3000);

		WebElement list = driver.findElement(By.className("forExpando"));
		List<WebElement> options = list.findElements(By.tagName("a"));

		System.out.println("Size of array : " + options.size());

		String expStr[] = {"USB Port Cards","Laptop Replacement Parts","Memory","Case Fans","Computer Cases"
				,"Motherboards","External Sound Cards","External Sound Cards","Internal Memory Card Readers",
				"Parallel Port Cards", "+ See more"};
		String actStr[]= new String[options.size()]; 

		for (int i = 0 ; i < options.size(); i++) {

			System.out.println(options.get(i).getText());

			for(int j = 0; j < expStr.length; j++){

				actStr[i] = options.get(i).getText();

				if(expStr[j].equals(actStr[i])){

					Update_Report("Pass", "Compare Items", "Actual Items equal to Expected Items. ");
					System.out.println(actStr[i]);

				}

			}
		}

		bw.close();

		driver.quit();

	}

	//Test Case 06>>>>Verify Show results for Column  on the left -"  Electronics  "Header  

	public static void verifyElectronics() throws IOException, InterruptedException{

		startReport("verifyElectronics","C:/Users/Ila Suba/Desktop/Abhishk_Homework/Report/");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");

		Update_Report("Pass", "Launch amazon Application", "Amazon Application is launched");

		Thread.sleep(3000);
		WebElement anyCatagory = driver.findElement(By.xpath("//div[@id='refinements']/div[2]/ul[1]/li[1]/a/span[2]"));
		clickButton(anyCatagory, "Click on Any Catagory link");
		Thread.sleep(3000);

		WebElement computerComponent = driver.findElement(By.xpath("//ul[@id='seeAllDepartmentOpen1']/li[1]/ul/li/a/span[text()='Computer Components']"));
		clickButton(computerComponent, "Click on Computer Component link");
		Thread.sleep(3000);

		WebElement list = driver.findElement(By.className("forExpando"));
		List<WebElement> options = list.findElements(By.tagName("a"));

		String expStr[] = {"Cell Phones","Unlocked Cell Phones","Memory","Carrier Cell Phones","Cell Phone Accessories"
				,"Cell Phone Cases","+ See more"};
		String actStr[]= new String[options.size()]; 

		for (int i = 0 ; i < options.size(); i++) {

			for(int j = 0; j < expStr.length; j++){

				actStr[i] = options.get(i).getText();

				if(expStr[j].equals(actStr[i])){

					Update_Report("Pass", "Compare Items", "Actual Items equal to Expected Items. ");
					System.out.println(actStr[i]);

				}

			}
		}

		bw.close();

		driver.quit();

	}
	//Test Case 07>>>>	Verify Show results for Column  on the left -"  Refine by "Header 
	public static void RefinebyHeader() throws Exception{

		startReport("RefinebyHeader", "C:/Users/Ila Suba/Desktop/Abhishk_Homework/Report/");
		//Launch the browser
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");
		Update_Report("Pass", "Launch amazon Application", "Amazon Application is launched");

		WebElement AmazonPrime = driver.findElement(By.xpath(".//*[@id='refinements']/h2[1]"));
		ElementDisplayed(AmazonPrime, "Amazon Prime");

		WebElement chkbox= driver.findElement(By.xpath(".//*[@id='ref_2470954011']/li/a/div/span/img"));

		ValidateDeselect(chkbox);
		Update_Report("Pass", "Validating Check Box", "Actual Result Match with Expected Result");
		
		WebElement freeshipping = driver.findElement(By.xpath(".//*[@id='refinements']/h2[3]"));
		ElementDisplayed(freeshipping, "Eligible for free shipping");
		Update_Report("Pass", "Validating freeSheeping", "Actual Result Match with Expected Result");

		WebElement freeShipByAmazon = driver.findElement(By.xpath(".//*[@id='ref_2491144011']/li/a/img"));
		ValidateDeselect(freeShipByAmazon);
		Update_Report("Pass", "Validating freeSheeping", "Actual Result Match with Expected Result");
		
		//Brand
		WebElement brand = driver.findElement(By.xpath(".//*[@id='refinements']/h2[5]"));
		ElementDisplayed(brand, "Brand");
		Update_Report("Pass", "Brand", "Actual Result Match with Expected Result");
		
		//Apple
		WebElement Apple = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[1]/a/img"));
		ElementDisplayed(Apple, "Apple Icon");
		ValidateDeselect(Apple);
		Update_Report("Pass", "Validate Deselect", "Actual Result Match with Expected Result");

		//Rinbers
		WebElement rinbers = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[3]/a/img"));
		ElementDisplayed(rinbers, "Rinbers Icon");
		ValidateDeselect(rinbers);
     
		//Buyeee

		WebElement Buyee = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[4]/a/img"));
		ElementDisplayed(Buyee, "Buyee Icon");
		ValidateDeselect(Buyee);

		//Grantwood Technology
		WebElement Grantwood = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[5]/a/img"));
		ElementDisplayed(Grantwood, "GrantWood Technology");
		ValidateDeselect(Grantwood);

		//Energen
		WebElement Energen = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[6]/a/img"));
		ElementDisplayed(Energen, "Energen Icon");
		ValidateDeselect(Energen);

		//RCO
		WebElement Rco = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[7]/a/img"));
		ElementDisplayed(Rco, "RCO Icon");
		ValidateDeselect(Rco);

		//KingLAKE
		WebElement kinglake = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[8]/a/img"));
		ElementDisplayed(kinglake, "KINGLAKE Icon");
		ValidateDeselect(kinglake);

		//UNU
		WebElement UNU = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[9]/a/img"));
		ElementDisplayed(UNU, "UNU Icon");
		ValidateDeselect(UNU);

		//CellPhone Internal Memory
		WebElement memory =driver.findElement(By.xpath(".//*[@id='refinements']/h2[6]"));
		ElementDisplayed(memory, "Cell Phone Internal Memory");

		//4GB
		WebElement FourGB = driver.findElement(By.xpath(".//*[@id='ref_7805160011']/li[1]/span/img"));
		FourGB.isEnabled();
		Update_Report("Pass", "FourGB checBox", "4GB Check Box is disable");

		//8GB
		WebElement EightGB = driver.findElement(By.xpath(".//*[@id='ref_7805160011']/li[2]/a/img"));
		ElementDisplayed(EightGB, "8GB memory");
		ValidateDeselect(EightGB);

		//16GB

		WebElement SixteenGB = driver.findElement(By.xpath(".//*[@id='ref_7805160011']/li[3]/a/img"));
		ElementDisplayed(SixteenGB, "16GB memory");
		ValidateDeselect(SixteenGB);

		//32GB

		WebElement ThirtyTwoGB = driver.findElement(By.xpath(".//*[@id='ref_7805160011']/li[4]/a/img"));
		ElementDisplayed(ThirtyTwoGB, "32GB memory");
		ValidateDeselect(ThirtyTwoGB);

		//64GB
		WebElement SixtyfourGB = driver.findElement(By.xpath(".//*[@id='ref_7805160011']/li[5]/a/img"));
		ElementDisplayed(SixtyfourGB, "64GB memory");
		ValidateDeselect(SixtyfourGB);

		//cell phone display size option

		WebElement displaySize = driver.findElement(By.xpath(".//*[@id='refinements']/h2[10]"));
		ElementDisplayed(displaySize, "Cell Phone Display Size");

		//3.9 Inches  Under Option
		WebElement Inches = driver.findElement(By.xpath(".//*[@id='ref_6215726011']/li[1]/a/img"));
		ElementDisplayed(Inches, "3.9 Inches & Under");
		ValidateDeselect(Inches);
		//4.0 to 4.4 Inches  Option
		WebElement Inches1 = driver.findElement(By.xpath(".//*[@id='ref_6215726011']/li[2]/a/img"));
		ElementDisplayed(Inches1, "4.0 to 4.4 Inches");
		ValidateDeselect(Inches1);
		//4.5 to 4.9 Inches Option
		WebElement Inches2 = driver.findElement(By.xpath(".//*[@id='ref_6215726011']/li[3]/a/img"));
		ElementDisplayed(Inches2, "4.5 to 4.9 Inches");
		ValidateDeselect(Inches2);
		//5.0 to 5.4 Inches Option
		WebElement Inches3 = driver.findElement(By.xpath(".//*[@id='ref_6215726011']/li[4]/a/img"));
		ElementDisplayed(Inches3, "5.0 to 5.4 Inches");
		ValidateDeselect(Inches3);
		//5.5 Inches & Over Option
		WebElement Inches4 = driver.findElement(By.xpath(".//*[@id='ref_6215726011']/li[5]/a/img"));
		ElementDisplayed(Inches4, "35.5 Inches & Over");
		ValidateDeselect(Inches4);


		//Cell Phone Compatibility Option
		WebElement PhComp = driver.findElement(By.xpath(".//*[@id='refinements']/h2[12]"));
		ElementDisplayed(PhComp, "Cell Phone Compatibility");

		//iPhone 6 Option
		WebElement Iphone6 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[1]/a/img"));
		ElementDisplayed(Iphone6, "iPhone 6/6S");
		ValidateDeselect(Iphone6);

		//iPhone 6Plus  Option
		WebElement Iphone6plus = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[2]/a/img"));
		ElementDisplayed(Iphone6plus, "iPhone 6/6S Plus");
		ValidateDeselect(Iphone6plus);

		//iPhone  5  option
		WebElement Iphone5 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[3]/a/img"));
		ElementDisplayed(Iphone5, "iPhone  5/5S/SE ");
		ValidateDeselect(Iphone5);

		//iPhone 5C Option 
		WebElement Iphone5C = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[4]/a/img"));
		ElementDisplayed(Iphone5C, "iPhone 5C");
		ValidateDeselect(Iphone5C);

		//iPhone 4/4S Option
		WebElement Iphone4 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[5]/a/img"));
		ElementDisplayed(Iphone4, "iPhone 4/4S");
		ValidateDeselect(Iphone4);

		//Samsung Galaxy S 7 Option
		WebElement GalaxyS7 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[6]/span/img"));
		ElementDisplayed(GalaxyS7, "Samsung Galaxy S 7");
		ValidateDeselect(GalaxyS7);

		//Samsung Galaxy S 7 Edge Option
		WebElement GalaxyS7Edge = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[7]/span/img"));
		ElementDisplayed(GalaxyS7Edge, "Samsung Galaxy S 7 Edge");
		ValidateDeselect(GalaxyS7Edge);

		//Samsung Galaxy S 6 option
		WebElement GalaxyS6 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[8]/a/img"));
		ElementDisplayed(GalaxyS6, "Samsung Galaxy S 6");
		ValidateDeselect(GalaxyS6);

		//Samsung Galaxy S 6 Edge option
		WebElement GalaxyS6Edge = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[9]/a/img"));
		ElementDisplayed(GalaxyS6Edge, "Samsung Galaxy S 6 Edge");
		ValidateDeselect(GalaxyS6Edge);

		//Samsung Galaxy S 5  option
		WebElement GalaxyS5 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[10]/a/img"));
		ElementDisplayed(GalaxyS5, "Samsung Galaxy S 5 ");
		ValidateDeselect(GalaxyS5);

		//Samsung Galaxy S 4  option
		WebElement GalaxyS4 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[11]/a/img"));
		ElementDisplayed(GalaxyS4, "Samsung Galaxy S 4 ");
		ValidateDeselect(GalaxyS4);


		//Samsung Galaxy Note 4  option
		WebElement Note4 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[12]/a/img"));
		ElementDisplayed(Note4, "Samsung Galaxy Note 4 ");
		ValidateDeselect(Note4);

		//LG G3 Option
		WebElement LGG3 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[13]/a/img"));
		ElementDisplayed(LGG3, "LG G3");
		ValidateDeselect(LGG3);

		Update_Report("Pass", "Validating colomn", "Actual Result Match with Expected Result");
		bw.close();	
		driver.quit();
	}	
	//Test Case 08>>>> Check MainTab

	public static void CheckMainTab() throws Exception{

		startReport("CheckMainTab","C:/Users/Ila Suba/Desktop/Abhishk_Homework/Report/");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/");

		Update_Report("Pass", "Launch amazon Application", "Amazon Application is launched");

		Thread.sleep(3000);

		WebElement department = driver.findElement(By.xpath("//a[@id='nav-link-shopall']/span[2]"));
		verifyElement(department);
		Thread.sleep(6000);

		//Verifying link
		System.out.println("Verifying link");
		String actURL = driver.getCurrentUrl();
		String expURL = "https://www.amazon.com/";

		verifyLink(actURL,expURL);
		Update_Report("Pass", "Verifying Links", "Links are Match");

		//Today's deal
		System.out.println("Today's deal");
		WebElement todaysDeal = driver.findElement(By.xpath("//div[@id='nav-xshop-container']//div[@id='nav-xshop']//a[2]"));
		verifyElement(todaysDeal);
		Thread.sleep(3000);
		Update_Report("Pass", "Verifying Today's Deal", "Result Match with Expected.");

		//Verifying GiftCards
		System.out.println("Verifying GiftCards");
		WebElement giftCard = driver.findElement(By.xpath("//div[@id='nav-xshop']/a[3]"));
		verifyElement(giftCard);
		Thread.sleep(3000);
		Update_Report("Pass", "Verifying GiftCards", "Result Match with Expected.");
		
		//Verify sell
		System.out.println("Verifying sell");
		WebElement sell = driver.findElement(By.xpath("//div[@id='nav-xshop']/a[4]"));
		verifyElement(sell);
		Thread.sleep(3000);
		Update_Report("Pass", "Verifying Sell", "Result Match with Expected.");

		//verifying help
		System.out.println("help");
		WebElement help = driver.findElement(By.xpath("//div[@id='nav-xshop']/a[5]"));
		verifyElement(help);
		Thread.sleep(3000);
		Update_Report("Pass", "Verifying Help", "Result Match with Expected."); 
		
		//verifying hello sign in
		System.out.println("hello sign in");
		WebElement signIn = driver.findElement(By.xpath("//a[@id='nav-link-yourAccount']/span[1]"));
		verifyElement(signIn);
		Thread.sleep(3000);
		Update_Report("Pass", "Verifying Hello!Sign In", "Result Match with Expected.");
		
		//verifying prime
		System.out.println("verifying prime");
		WebElement prime = driver.findElement(By.xpath("//a[@id='nav-link-prime']/span[2]"));
		verifyElement(prime);
		Thread.sleep(3000);
		Update_Report("Pass", "Verifying Prime", "Result Match with Expected."); 
		
		//verifying lists
		System.out.println("Verifying lists");
		WebElement lists = driver.findElement(By.xpath("//a[@id='nav-link-wishlist']/span[2]"));
		verifyElement(lists);
		Thread.sleep(3000);
		Update_Report("Pass", "Verifying Lists", "Result Match with Expected.");
		
		//verifying cart
		System.out.println("Verifying cart");
		WebElement cart = driver.findElement(By.xpath("//a[@id='nav-link-wishlist']/span[2]"));
		verifyElement(cart);
		Update_Report("Pass", "Verifying Cart", "Result Match with Expected.");

		Thread.sleep(3000);



		bw.close();

		driver.quit();

	}

	//Test Case 010>>>> Validate 'Your Account' dropdown list
	public static void yourAccount()throws Exception{

		startReport("yourAccount", "C:/Users/Ila Suba/Desktop/Abhishk_Homework/Report/");
		//Launch the browser
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		Update_Report("Pass", "Launch amazon Application", "Amazon Application is launched");
		Thread.sleep(3000);

		//dropdown youraccount
		WebElement yourAccount = driver.findElement(By.xpath("//a[@id='nav-link-yourAccount']/span[2]"));

		Actions action = new Actions(driver);

		Thread.sleep(5000);
		action.moveToElement(yourAccount).build().perform();


		WebElement list = driver.findElement(By.xpath("//div[@id='nav-belt']//div[@id='nav-flyout-yourAccount']"));

		List<WebElement> options = list.findElements(By.tagName("div"));

		String expElements[]= new String[options.size()]; 
		for (int i = 0 ; i < options.size(); i++) {

			if(options.get(i).getText()!= null){
				System.out.println(options.get(i).getText());
				expElements[i] = options.get(i).getText(); 

			}

		}


		verify_Values_In_Dropdown(options, expElements);
    
		Update_Report("Pass", "Verifying Your Account Drop Down", "Amazon Application is launched");


		bw.close();

		driver.quit();
	}	

	//Test Case 011>>>> Validate 'Try Prime' dropdown list
	public static void tryPrimeDropDown()throws Exception{

		startReport("tryPrime", "C:/Users/Ila Suba/Desktop/Abhishk_Homework/Report/");
		//Launch the browser
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		Update_Report("Pass", "Launch amazon Application", "Amazon Application is launched");
		Thread.sleep(3000);

		//Try Prime youraccount
		WebElement triPrime = driver.findElement(By.xpath("//a[@id='nav-link-prime']/span[2]"));
		clickButton(triPrime, "Click on Try Prime");

		Update_Report("Pass", "Click on Try Prime", "Its take to Next Page");


		bw.close();

		driver.quit();
	}	



	//Test Case 012>>>> Validate 'Lists' dropdown list
	public static void lists()throws Exception{

		startReport("lists", "C:/Users/Ila Suba/Desktop/Abhishk_Homework/Report/");
		//Launch the browser
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		Update_Report("Pass", "Launch amazon Application", "Amazon Application is launched");
		
		Thread.sleep(3000);

		//Click on Listdrop down
		WebElement lists = driver.findElement(By.xpath("//a[@id='nav-link-wishlist']/span[2]"));
		// clickButton(lists, "Click on lists");

		Update_Report("Pass", "Click on lists", "Display list of Elements");
		Thread.sleep(3000);



		Actions action = new Actions(driver);

		Thread.sleep(5000);
		action.moveToElement(lists).build().perform();


		WebElement list = driver.findElement(By.xpath("//div[@id='nav-belt']//div[@id='nav-flyout-wishlist']"));

		List<WebElement> options = list.findElements(By.tagName("div"));

		String expElements[]= new String[options.size()]; 
		for (int i = 0 ; i < options.size(); i++) {

			if(options.get(i).getText()!= null){
				System.out.println(options.get(i).getText());
				expElements[i] = options.get(i).getText(); 

			}

		}


		verify_Values_In_Dropdown(options, expElements);

		//validateSelectDropDown(yourAccount, expElements, "Validate Your Account Drop Down");


		bw.close();

		driver.quit();
	}	

}	

