package com.example.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage { 
    private WebDriver driver;

    /**
     * Constructs a new HomePage object.
     *
     * @param driver the WebDriver instance to use
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks the "Amount" header to sort the transaction table.
     */
    public void clickAmountHeader() {
        driver.findElement(By.id("amount")).click();
    }

    /**
     * Retrieves the transaction amounts from the table.
     *
     * @return a list of transaction amounts
     */
    public List<Double> getTransactionAmounts() {
        // Find all the elements containing transaction amounts
        List<WebElement> amountElements = driver.findElements(By.cssSelector(".transaction-amount"));

        // Extract the numerical values from the elements and store them as doubles in a list
        List<Double> amounts = amountElements.stream()
                .map(element -> Double.parseDouble(element.getText().replaceAll("[^0-9.]+", "")))
                .collect(Collectors.toList());

        return amounts;
    }
}
