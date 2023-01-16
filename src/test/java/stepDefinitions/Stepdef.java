package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.en.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
//import junit.framework.Assert;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Stepdef extends BaseClass {

	Scenario sec;

	@Before
	public void setup() throws IOException {
		// Logging
		logger = Logger.getLogger("nopCommerceSDET");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);

		// Load properties file
		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);

		String br = configProp.getProperty("browser"); // getting the browser name from config.properties file

		// Launching browser
		if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}

		else if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}

		else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}

	}

	@Before(order = 1)
	public void Setup(Scenario sc) {
		sec = sc;
	}

	// Login steps....................
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		logger.info("************* Launching Browser *****************");
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		logger.info("************* Opening URL  *****************");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) {
		logger.info("************* Prvding user and password *****************");
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() {
		logger.info("************* click on login *****************");
		lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String exptitle) throws InterruptedException {

		if (driver.getPageSource().contains("Login was unsuccessful")) {
			logger.info("************* Login failed *****************");
			driver.close();
			Assert.assertTrue(false);
		} else {
			logger.info("************* Login Passed *****************");
			Assert.assertEquals(exptitle, driver.getTitle());
		}
		Thread.sleep(3000);

	}

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException {
		logger.info("************* clciking on logout *****************");
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		logger.info("************* cloding browser *****************");
		driver.quit();
	}

	// Customer feature step definitions..........................................

	@Then("User can view Dashboad")
	public void user_can_view_Dashboad() {

		addCust = new AddcustomerPage(driver);
		logger.info("********* Verifying Dashboad page title after login successful **************");
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() throws InterruptedException {
		Thread.sleep(3000);
		logger.info("********* Clicking on customer main menu **************");
		addCust.clickOnCustomersMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item() throws InterruptedException {
		Thread.sleep(2000);
		logger.info("********* Clicking on customer sub menu **************");
		addCust.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {
		addCust.clickOnAddnew();
		Thread.sleep(2000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = randomestring() + "@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		// Registered - default
		// The customer cannot be in both 'Guests' and 'Registered' customer roles
		// Add the customer to 'Guests' or 'Registered' customer role
		addCust.setCustomerRoles("Guest");
		Thread.sleep(3000);

		addCust.setManagerOfVendor("Vendor 2");
		addCust.setGender("Male");
		addCust.setFirstName("Pavan");
		addCust.setLastName("Kumar");
		addCust.setDob("7/05/1985"); // Format: D/MM/YYY
		addCust.setCompanyName("busyQA");
		addCust.setAdminContent("This is for testing.........");
	}

	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException {
		logger.info("********* Saving customer details **************");
		addCust.clickOnSave();
		Thread.sleep(2000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
	}

	// Searching customer by email ID.............................
	@When("Enter customer EMail")
	public void enter_customer_EMail() {
		searchCust = new SearchCustomerPage(driver);
		logger.info("********* Searching customer details by Email **************");
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCust.clickSearch();
		Thread.sleep(3000);
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_Email_in_the_Search_table() {
		boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}

	// steps for searching a customer by Name................
	@When("Enter customer FirstName")
	public void enter_customer_FirstName() {
		logger.info("********* Searching customer details by Name **************");
		searchCust = new SearchCustomerPage(driver);
		searchCust.setFirstName("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_LastName() {
		searchCust.setLastName("Terces");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_Name_in_the_Search_table() {
		boolean status = searchCust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
	}

	@Given("I open browser and navigate to {string}")
	public void i_open_browser_and_navigate_to_google(String string) {
		driver.get(string);
		//sec.write("Opened the url with " + string);
	}

	@Given("I lauch the URL {string}")
	public void i_lauch_the_URL(String string) {
		driver.get(string);
	}

	@Given("input value to name as {string}")
	public void input_value_to_name_as(String string) throws InterruptedException {
		driver.findElement(By.name("first_name")).sendKeys(string);
	
		Thread.sleep(4000);
	}

	@When("I want to write a step with {string}")
	public void i_want_to_write_a_step_with(String string)throws InterruptedException {
		driver.findElement(By.name("first_name")).sendKeys(string);
			}

	@Then("I check for the {string} in step")
	public void i_check_for_the_in_step(String string) throws InterruptedException{
		driver.findElement(By.name("last_name")).sendKeys(string);	
		}

	@Then("I verify the {string} in step")
	public void i_verify_the_in_step(String string)throws InterruptedException {
		driver.findElement(By.name("business_name")).sendKeys(string);	
		
		Thread.sleep(4000);
			}
	@When("i fill the valid date in the fields with list of list")
	public void i_fill_the_valid_date_in_the_fields(DataTable dataTable)throws InterruptedException {

		// Method 1 - Using  .cells ( similiar to .raw in old cucumber, which will convered data table to  list of lists
/*		 
 		List<List<String>> data = dataTable.cells();
//	    data=[[Fields, Values], [First Name, SARBIN], [Last Name, Data table], [businessname, tetqea DT]] 
		
		 driver.findElement(By.name("first_name")).sendKeys(data.get(1).get(1)); 
	    driver.findElement(By.name("last_name")).sendKeys(data.get(2).get(1));
		driver.findElement(By.name("business_name")).sendKeys(data.get(3).get(1));
		Thread.sleep(4000);
*/
		//*****************************************************************************************//
		
		// Method 2  - using  asList method to convert data table to list of list
		  
         List<List<String>> rows = dataTable.asLists(String.class);
//		 rows=[[Fields, Values], [First Name, SARBIN], [Last Name, Data table], [businessname, tetqea DT]] 
		
		 driver.findElement(By.name("first_name")).sendKeys(rows.get(1).get(1)); 
		  driver.findElement(By.name("last_name")).sendKeys(rows.get(2).get(1));
		 driver.findElement(By.name("business_name")).sendKeys(rows.get(3).get(1));
		 Thread.sleep(4000);
		
	driver.navigate().refresh();
	 Thread.sleep(4000);
	
	
	
	}

	@When("i fill the valid data using data Table with Header and Single Row with list of map")
	public void i_the_list_of_map(DataTable dataTable)throws InterruptedException
	{
		
	//Method 3  -	method to convert data table to list of map    
		
		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
//		rows =[ { "First Name": "SARBIN2", "Last Name": "Data table2",  "businessname": "tetqea DT2" } ] 
	             String FName = rows.get(0).get("First Name");
	             System.out.println("First Name :" + FName);
	             driver.findElement(By.name("first_name")).sendKeys(FName);
	            
	             String LName = rows.get(0).get("Last Name");
	             System.out.println("Last Name :" + LName);
	             driver.findElement(By.name("last_name")).sendKeys(LName);
	           
	             String BName = rows.get(0).get("businessname");
	             System.out.println("business_name :" + BName);
	             driver.findElement(By.name("business_name")).sendKeys(BName);
	 
	 
		 Thread.sleep(4000);	
		 driver.navigate().refresh();
		 Thread.sleep(4000);
		
	
	}
	
	@When("i fill the valid data using data Table with Header and Multiple Row with list of map")
	public void i_the_list_of_multimap(DataTable dataTable) throws InterruptedException
	{
		
	//Method 3  -	method to convert data table to list of map    
		
		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
//		rows =[ { "First Name": "SARBIN3", "Last Name": "Data table3",  "businessname": "tetqea DT3" },
// 		        { "First Name": "SARBIN4", "Last Name": "Data table4",  "businessname": "tetqea DT4" }			
//			  ] 
	        
		 for (Map<String, String> listitr : rows) {
		
		
		         String FName = listitr.get("First Name");
	             System.out.println("First Name :" + FName);
	             driver.findElement(By.name("first_name")).sendKeys(FName);
	            
	             String LName = listitr.get("Last Name");
	             System.out.println("Last Name :" + LName);
	             driver.findElement(By.name("last_name")).sendKeys(LName);
	           
	             String BName = listitr.get("businessname");
	             System.out.println("business_name :" + BName);
	             driver.findElement(By.name("business_name")).sendKeys(BName);
	 
	             driver.navigate().refresh();
	        	 Thread.sleep(4000);
                 
		 }
	}
	
@And("display message success in console")
public void display_message_success_in_console() {
  System.out.println("console set");

}

	@After
	public void teraDown() {
		driver.quit();
	}
}