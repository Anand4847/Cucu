package com.stepDef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	WebDriver driver;

	@Given("User should be on the login page")
	public void user_should_be_on_the_login_page() {

		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");

	}

	@When("I enter valid {string} and click on continue button")
	public void i_enter_valid_and_click_on_continue_button(String email)  {

		driver.findElement(By.cssSelector("[id='ap_email']")).sendKeys(email);
		driver.findElement(By.cssSelector("[id='continue']")).click();

	}

	@When("enter valid {string}")
	public void enter_valid(String password) {

		driver.findElement(By.cssSelector("[id='ap_password']")).sendKeys(password);

	}

	@When("click on signin button")
	public void click_on_signin_button()throws Exception {

		driver.findElement(By.id("signInSubmit")).click();
        Thread.sleep(3000);
	}

	@Then("it should navigate the user to the home page")
	public void it_should_navigate_the_user_to_the_home_page() {

		String url = driver.getCurrentUrl();
		if (url.contains("nav_custrec")) {

			Assert.assertTrue(true);
		} else

		{

			Assert.assertTrue(false);
		}

	}

	@When("enter invalid {string}")
	public void enter_invalid(String password) {

		driver.findElement(By.cssSelector("[id='ap_password']")).sendKeys(password);
	}

	@Then("it should throw the validation error")
	public void it_should_throw_the_validation_error() {

		String error = driver.findElement(By.xpath("//span[contains(text(),'Your password is incorrect')]")).getText();

		if (error.equalsIgnoreCase("Your password is incorrect"))

		{

			Assert.assertTrue(true);
		} else

		{

			Assert.assertTrue(false);
		}

	}

	@After

	public void tearDown()

	{

		driver.quit();
	}

}