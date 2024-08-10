package com.example;

import com.example.pages.CartPage;
import com.example.pages.HomePage;
import com.example.pages.ProductPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Main {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        HomePage homePage = new HomePage(page);
        homePage.navigateToHomePage();
        homePage.clickPhones();

        ProductPage productPage = new ProductPage(page);
        productPage.addProductToCart("Sony xperia Z5");

        CartPage cartPage = new CartPage(page);
        cartPage.placeOrder();

        browser.close();
        playwright.close();
    }
}