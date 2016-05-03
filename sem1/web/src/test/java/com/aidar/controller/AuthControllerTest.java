package com.aidar.controller;

import com.aidar.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by paradise on 03.05.16.
 */
public class AuthControllerTest {

    @Autowired
    private UserService userService;

    private WebDriver driver;

    private String signInUrl = "http://localhost:8080/sign_in";
    private String signInWithErrorUrl = "http://localhost:8080/sign_in?error=true";

    @Before
    public void setup() throws IOException {
        driver = new HtmlUnitDriver();
    }

    @Test
    public void signInWithValidCredentialsShouldRedirectToHomePage() {
        driver.get(signInUrl);
        driver.findElement(By.id("email")).sendKeys("kobe@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("sign_in")).click();
        assertEquals("Home", driver.getTitle());
    }

    @Test
    public void signInWithInvalidCredentialsShouldRedirectToSignInPageWithErrorParameter() {
        driver.get(signInUrl);
        driver.findElement(By.id("email")).sendKeys("asd@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("sign_in")).click();
        assertTrue(driver.getCurrentUrl().startsWith(signInUrl));
        assertTrue(driver.getCurrentUrl().endsWith("error=true"));
    }

}
