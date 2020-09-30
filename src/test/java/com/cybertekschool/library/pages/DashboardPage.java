package com.cybertekschool.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(css = "#user_count")
    public WebElement userCount;

    @FindBy(css = "#book_count")
    public WebElement bookCount;


    @FindBy(css = "#borrowed_books")
    public WebElement borrowedBooks;





}
