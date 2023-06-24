package com.example.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage { 
    private WebDriver driver;

    /**
     * Constructs a new LoginPage object.
     *
     * @param driver the WebDriver instance to use
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Enters the username into the username input field.
     *
     * @param username the username to enter
     */
    public void enterUsername(String username) {
        driver.findElement(By.id("username")).sendKeys(username);
    }

    /**
     * Enters the password into the password input field.
     *
     * @param password the password to enter
     */
    public void enterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    /**
     * Clicks the login button.
     */
    public void clickLoginButton() {
        driver.findElement(By.id("log-in")).click();
    }

    /**
     * Retrieves the entered username from the username input field.
     *
     * @return the entered username
     */
    public String getUsername() {
        return driver.findElement(By.id("username")).getAttribute("value");
    }
}
