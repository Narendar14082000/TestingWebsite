package com.example.tests.tests;

import com.example.tests.pages.HomePage;
import com.example.tests.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class contains test cases for a web application.
 */
public class TestCases {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    /**
     * Sets up the WebDriver and initializes the page objects.
     */
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\naren\\OneDrive\\Documents\\DriverExcution\\chromedriver.exe");
        
        // Create a new instance of ChromeDriver
        driver = new ChromeDriver();
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Initialize page objects
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
    
    /**
     * Pauses the execution for a specified amount of time.
     */
    public void waitTime() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the login functionality.
     */
    public void testLoginPage() {
        // Navigate to the login page
        driver.get("https://sakshingp.github.io/assignment/login.html");
        waitTime();
        
        // Enter the username and password
        loginPage.enterUsername("Narendar");
        loginPage.enterPassword("password123");
        
        // Click the login button
        loginPage.clickLoginButton();
        
        // Check if the user is redirected to the home page
        if (driver.getCurrentUrl().equals("https://sakshingp.github.io/assignment/home.html")) {
            System.out.println("Login successful. Home page is displayed.");
        } else {
            System.out.println("Login failed. Home page is not displayed.");
        }
    }

    /**
     * Tests the "Remember Me" functionality.
     */
    public void testRememberMeFunctionality() {
        // Navigate to the login page
        driver.get("https://sakshingp.github.io/assignment/login.html");

        // Enter valid credentials
        String enteredUsername = "Narendar";
        loginPage.enterUsername(enteredUsername);
        loginPage.enterPassword("password123");

        // Check the "Remember Me" checkbox
        WebElement rememberMeCheckbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        rememberMeCheckbox.click();

        // Click the login button
        loginPage.clickLoginButton();

        // Assert that the user is redirected to the home page
        if (driver.getCurrentUrl().equals("https://sakshingp.github.io/assignment/home.html")) {
            System.out.println("Login successful. Home page is displayed.");
        } else {
            System.out.println("Login failed. Home page is not displayed.");
        }
        
        // Log out
        // Perform logout steps here
        
        // Go back to the login page
        driver.get("https://sakshingp.github.io/assignment/login.html");
        
        // Verify if the login page retains the entered username
        WebElement usernameInput = driver.findElement(By.id("username"));
        String retainedUsername = usernameInput.getAttribute("value");
        if (retainedUsername.equals(enteredUsername)) {
            System.out.println("Login page retains the entered username after logout.");
        } else {
            System.out.println("Login page does not retain the entered username after logout.");
        }
    }

    /**
     * Tests navigation to the home page with query parameters.
     */
    public void testNavigationWithQueryParameters() {
        // Navigate to the login page with query parameter
        driver.get("https://sakshingp.github.io/assignment/login.html?showAd=true");

        // Enter valid credentials
        loginPage.enterUsername("Narendar");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        // Assert that the user is redirected to the home page with the query parameter retained
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://sakshingp.github.io/assignment/home.html?showAd=true")) {
            System.out.println("Login successful. Home page with query parameter is displayed.");
        } else {
            System.out.println("Login failed. Home page with query parameter is not displayed.");
        }
    }

    /**
     * Tests navigation to the home page without query parameters.
     */
    public void testNavigationWithoutQueryParameters() {
        // Navigate to the login page
        driver.get("https://sakshingp.github.io/assignment/login.html");

        // Enter valid credentials
        loginPage.enterUsername("Narendar");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        // Assert that the user is redirected to the home page without any query parameters
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://sakshingp.github.io/assignment/home.html")) {
            System.out.println("Login successful. Home page without query parameter is displayed.");
        } else {
            System.out.println("Login failed. Home page without query parameter is not displayed.");
        }
    }

    /**
     * Tests the sorting functionality on the home page.
     */
    public void testHomePageSorting() {
        // Assuming already logged in and on the Home Page
        // Perform actions to navigate to the Home Page
        // For example:
        driver.get("https://sakshingp.github.io/assignment/home.html");
       
        // Click the AMOUNT header to sort the transaction table
        homePage.clickAmountHeader();

        // Get the sorted transaction amounts
        List<Double> sortedAmounts = homePage.getTransactionAmounts();

        // Create a copy of the amounts and sort it in ascending order
        List<Double> expectedSortedAmounts = new ArrayList<>(sortedAmounts);
        Collections.sort(expectedSortedAmounts);
        
        // Compare the sorted amounts with the expected sorted amounts
        System.out.println("Transaction amounts are not sorted correctly");
        System.out.println("So After sorting the amount will be......");
        if (expectedSortedAmounts.equals(sortedAmounts)) {
            System.out.println("Transaction amounts are sorted correctly.");
        } else {
            System.out.println("Transaction amounts are not sorted correctly.");
        }
    }

    /**
     * Tears down the WebDriver and closes the browser.
     */
    public void tearDown() {
        driver.quit();
    }

    /**
     * The main method to execute the test cases.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        TestCases testCases = new TestCases();
        testCases.setUp();
        testCases.testLoginPage();
        testCases.waitTime();
        testCases.testRememberMeFunctionality();
        testCases.waitTime();
        testCases.testNavigationWithQueryParameters();
        testCases.waitTime();
        testCases.testNavigationWithoutQueryParameters();
        testCases.waitTime();
        testCases.testHomePageSorting();
        testCases.waitTime();
        testCases.tearDown();
    }
}
