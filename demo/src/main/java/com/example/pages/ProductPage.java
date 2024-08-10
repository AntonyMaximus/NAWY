package com.example.pages;

import com.microsoft.playwright.Page;

public class ProductPage {

    private final Page page;

    public ProductPage(Page page) {
        this.page = page;
    }

    public void addProductToCart(String productName) {
        page.click(productName);
        page.click("//button[text()='Add to cart']");
    }

}
