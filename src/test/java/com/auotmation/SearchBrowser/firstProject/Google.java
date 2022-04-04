package com.auotmation.SearchBrowser.firstProject;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {

	WebDriver driver;
	JavascriptExecutor jse;

	@BeforeMethod
	public void beforeMethod() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		jse=  (JavascriptExecutor) driver;

		driver.get("https://www.walmart.ca/en");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void demoQaTitle() {

		String titleOfPage = driver.getTitle();
		System.out.println("Title of the Page: " + titleOfPage);
		Assert.assertEquals(titleOfPage, "ToolsQA");
	}

	public int sum(int a, int b) {
		return 10;

	}

	@Test(priority = 2, invocationCount = 3)
	@Ignore
	public void clickElementsOnHomePage() {
		WebElement element = driver.findElement(By.cssSelector("div[class='avatar mx-auto white']"));
		element.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String titleOfPage = driver.getTitle();
		System.out.println("Title of the Page: " + titleOfPage);
		Assert.assertEquals(titleOfPage, "ToolsQA");

	}

	// Clicking on Text Box
	@Test
	@Ignore
	public void clickText() {

		// navigating to Elements Page
		WebElement element = driver.findElement(By.cssSelector("div[class='avatar mx-auto white']"));
		element.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Clicking on text box
		WebElement textBox = driver.findElement(By.cssSelector("span[class='text']"));
		textBox.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void fillForm() {

		// navigating to Elements Page
		WebElement element = driver.findElement(By.cssSelector("div[class='avatar mx-auto white']"));
		element.click();

		// Clicking on text box
		WebElement textBox = driver.findElement(By.cssSelector("span[class='text']"));
		textBox.click();

		WebElement fullName = driver.findElement(By.id("userName"));
		WebElement email = driver.findElement(By.id("userEmail"));
		WebElement address = driver.findElement(By.id("currentAddress"));
		WebElement perAddress = driver.findElement(By.id("permanentAddress"));
		WebElement submitButton = driver.findElement(By.id("submit"));

		fullName.sendKeys("Joyce");
		email.sendKeys("dhinchakPooja@gmail.com");
		address.sendKeys("Brampton");
		perAddress.sendKeys("India");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		submitButton.click();

		WebElement Name = driver.findElement(By.id("name"));
		WebElement emailAddress = driver.findElement(By.id("email"));

		String nameDisplayed = Name.getText().substring(5, 10).trim();
		String emailDispalyed = emailAddress.getText().replace("Email:", "").trim();

		Assert.assertEquals(nameDisplayed, "Joyce");
		Assert.assertEquals(emailDispalyed, "harpreet@gmail.com");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	@Ignore
	public void clickCheckBox() {

		// navigating to Elements Page
		driver.findElement(By.cssSelector("div[class='avatar mx-auto white']")).click();

		// clciking on checkbox
		WebElement checkBoxPage = driver.findElement(By.id("item-1"));

		checkBoxPage.click();

		WebElement checkBox = driver.findElement(By.cssSelector("svg[class='rct-icon rct-icon-uncheck']"));

		System.out.println("Is checkbox selecetd: " + checkBox.isSelected());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// clicking on check box
		checkBox.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement selectedCheckBox = driver.findElement(By.cssSelector("svg[class='rct-icon rct-icon-check']"));
		// asserting if checkbox is selecetd
		Assert.assertTrue(selectedCheckBox.isDisplayed());
	}

	@Test
	@Ignore
	public void radioButton() {

		// navigating to Elements Page
		driver.findElement(By.cssSelector("div[class='avatar mx-auto white']")).click();

		// clicking on radio menu
		WebElement radioButton = driver.findElement(By.id("item-2"));

		radioButton.click();

		WebElement impressRadioButton = driver.findElement(By.cssSelector("label[for='impressiveRadio']"));

		impressRadioButton.click();

		WebElement getTextForSelectedRadioButton = driver.findElement(By.cssSelector("span[class='text-success']"));

		getTextForSelectedRadioButton.getText();
		Assert.assertEquals(getTextForSelectedRadioButton.getText(), "Impressive");

	}

	@Test
	@Ignore
	public void getTableText() {

		// selenium easy website

		WebElement table6thElement = driver
				.findElement(By.cssSelector("table[class='table table-hover'] tr:nth-child(6) td:last-of-type"));

		System.out.println("Text at 6th is : " + table6thElement.getText());

	}

	@Test
	@Ignore
	public void doubleClick() {
		WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));

		Actions action = new Actions(driver);

		action.doubleClick(doubleClickButton).perform();

		WebElement doubleClickSucessMessage = driver.findElement(By.id("doubleClickMessage"));

		Assert.assertEquals(doubleClickSucessMessage.getText(), "You have done a double click");

	}

	@Test
	public void rightClick() {
		WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));

		Actions action = new Actions(driver);

		action.contextClick(rightClickButton).perform();

		WebElement rightClickSucessMessage = driver.findElement(By.id("rightClickMessage"));

		Assert.assertEquals(rightClickSucessMessage.getText(), "You have done a right click");

	}

	@Test
	public void clickLink() {
		WebElement link = driver.findElement(By.cssSelector("div.element-list.collapse.show ul li#item-5"));

		link.click();

		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void uploadPicture() {
		WebElement chooseFile = driver.findElement(By.id("uploadPicture"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		chooseFile.sendKeys("put path of the file here");
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Test to switch between different tabs
	@Test
	public void newTab() {

		// Get current handle of the driver
		String Currenthandle = driver.getWindowHandle();

		WebElement tab = driver.findElement(By.id("tabButton"));
		System.out.println("Tab element is : " + tab);
		tab.click();

		// Get the handle of new tab
		String newHandle = handle(Currenthandle);

		System.out.println("Window handle before switch : " + Currenthandle);

		// Transfer driver handle to new tab
		driver.switchTo().window(newHandle);
		System.out.println("Current window handle is : " + newHandle);


		WebElement newWindow = driver.findElement(By.id("sampleHeading"));
		// Printout the text on new Tab
		System.out.println(newWindow.getText());

		// Driver switch handle to old tab
		driver.switchTo().window(Currenthandle);



		// click on new tab button on current window handle
		tab.click();


	}

	// Method of get the handle of new tab or window
	public String handle(String Currenthandle) {

		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String handle : allWindowHandles) {
			if (!handle.equals(Currenthandle)) {
				return handle;
			}
		}
		return null;
	}

	// Test to accept alerts
	@Test
	public void alertAccept() {
		WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
		timerAlertButton.click();
		
		List<String> name=new ArrayList<>();
		WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
		
		webDriverWait.until(ExpectedConditions.alertIsPresent());

		// alerts can either be accepted or dismissed, there are only 2 methods for that
		// alert.accept() or alert.dismiss()
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
		WebElement confirmText=driver.findElement(By.id("confirmResult"));
		
		Wait<WebDriver> fw = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoAlertPresentException.class);

		fw.until(ExpectedConditions.visibilityOf(confirmText));
		
		
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver).
				withTimeout(10,TimeUnit.SECONDS).pollingEvery(5,TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		
		fluentWait.until(ExpectedConditions.visibilityOf(confirmText));
		
		System.out.println(confirmText.getText());

	

	}

	// Test to perform Drag and drop using Actions Class
	@Test
	public void dragDrop() {
		WebElement item = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		Actions builder = new Actions(driver);

		Action dragandDrop = builder.clickAndHold(item).moveToElement(target).release(item).build();

		dragandDrop.perform();



	}
	
	@Test
	public void selectTest() {
		
	
		WebElement element=driver.findElement(By.id("id_contact"));
		Select select=new Select(element);

		element.click();

		select.selectByVisibleText("Customer service");
		

	}
	
	@Test
	public void testViewPort() {
		
		waitForDocumentCompleteState(0);

		driver.findElement(By.id("accept-privacy-policies")).click();

		WebElement photoCentre = driver.findElement(By.cssSelector(
				"#skip-to-footer div.css-gzci4i.eg5dgjz0>div:nth-child(2)>div:nth-child(6) ul li:nth-child(6) div a"));
		jse.executeScript("arguments[0].scrollIntoView(true);", photoCentre);

		photoCentre.click();

	}
	
	public void pageLoaded() {

		
	}

	public void waitForDocumentCompleteState(int secondsToWait) {
		new WebDriverWait(driver, secondsToWait).until((ExpectedCondition<Boolean>) v -> {

			while (true) {
				String readyState = getDocumentReadyState();
				System.out.println(readyState);

				if (readyState.equals("complete")) {
					System.out.println("Document Ready State is : " + readyState);
					return true;
				} else {
					System.out.println("Document is not in Ready State : " + readyState);
				}

			}
		});
	}

	private String getDocumentReadyState() {
		try {
			return jse.executeScript("return document.readyState").toString();

		} catch (WebDriverException e) {
			return null;
		}

	}

	void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	// Method to close the session of driver
	@AfterMethod
	public void afterMethod() {
		// driver.quit();

	}

}
