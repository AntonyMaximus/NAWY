package com.example.pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void navigateToHomePage() {
        page.navigate("https://www.demoblaze.com/");
    }

    public void clickPhones() {
        page.click("Phones");
    }

}
