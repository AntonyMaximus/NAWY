package com.example.pages;

import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage {
    private final Page page;
    private String dialogMessage;

    public HomePage(Page page) {
        this.page = page;
    }

    public void navigateToHomePage() {
        page.navigate("https://www.demoblaze.com/");
    }

    public void clickSignup() {
        page.click("#signin2");
    }

    public void register(String username, String password) {
        page.waitForSelector("//h5[text()='Sign up']");
        page.type("//h5[text()='Sign up']/../..//input[@id='sign-username']", username);
        page.type("//h5[text()='Sign up']/../..//input[@id='sign-password']", password);
        page.onDialog(dialog -> {
            System.out.println(dialog.message());
            dialogMessage = dialog.message();
            dialog.dismiss();
        });
        page.click("[onclick='register()']");
    }

    public void assertMessageAfterRegister() {
        assert dialogMessage.equals("Sign up successful..");
    }

    public void clickPhones() {
        page.click("Phones");
    }

}
