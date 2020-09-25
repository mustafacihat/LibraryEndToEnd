package com.cybertekschool.library.pages;


import com.cybertekschool.library.utils.ui.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LibraryLoginPage extends BasePage {

    public LibraryLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#inputEmail")
    public WebElement emailInputBox;

    @FindBy(css = "#inputPassword")
    public WebElement passwordInputBox;

    @FindBy(css = "button[type='submit']")
    public WebElement signInButton;

    public void loginLibrary(String email, String password){
        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        signInButton.click();
    }
}


