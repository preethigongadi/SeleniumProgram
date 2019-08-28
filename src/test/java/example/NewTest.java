package example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class NewTest {
	
	private WebDriver driver;
	
	/*
	 * @Test public void elements() {
	 * 
	 * driver.get("http://demo.guru99.com/test/ajax.html"); List<WebElement>
	 * elements = driver.findElements(By.name("name"));
	 * System.out.println("Number of elements:" +elements.size());
	 * 
	 * for (int i=0; i<elements.size();i++){ System.out.println("Radio button text:"
	 * + elements.get(i).getAttribute("value")); }
	 * 
	 * }
	 */
  
  
  @Test
  public void open() {
	  
	  driver.get("http://demo.guru99.com/test/guru99home/");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Demo Guru99 Page")); 	
  }
  
  @Test
  public void mouseevenst(){
	  driver.get("http://demo.guru99.com/test/newtours/");  
	  WebElement link_Home = driver.findElement(By.linkText("Home"));
      WebElement td_Home = driver
              .findElement(By
              .xpath("//html/body/div"
              + "/table/tbody/tr/td"
              + "/table/tbody/tr/td"
              + "/table/tbody/tr/td"
              + "/table/tbody/tr"));    
       
      Actions builder = new Actions(driver);
      Action mouseOverHome = builder
              .moveToElement(link_Home)
              .build();
       
      String bgColor = td_Home.getCssValue("background-color");
      System.out.println("Before hover: " + bgColor);        
      mouseOverHome.perform();        
      bgColor = td_Home.getCssValue("background-color");
      System.out.println("After hover: " + bgColor);
  }
  @Test
  public void upload(){
	  driver.get("http://demo.guru99.com/test/upload/");  
	  WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

      // enter the file path onto the file-selection input field
      uploadElement.sendKeys("C:\\newhtml.html");

      // check the "I accept the terms of service" check box
      driver.findElement(By.id("terms")).click();

      // click the "UploadFile" button
      driver.findElement(By.name("send")).click();
	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();  
  }

  @AfterClass
  
  public void afterClass() {
  }

}
