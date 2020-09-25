package com.cybertekschool.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends BasePage {


@FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
public WebElement firstBook;

@FindBy(xpath = "//input[@ placeholder ='Book Name']")
public WebElement bookName;

@FindBy(xpath = "//input[@ placeholder ='ISBN']")
public WebElement ISBN;

@FindBy(xpath = "//input[@ placeholder ='Author']")
public WebElement Author;

@FindBy(xpath = "//input[@ placeholder ='Year']")
public WebElement Year;



@FindBy(xpath = "//select[@id='book_group_id']")
public WebElement ddSelectObject;

@FindBy(xpath = "//button[.='Save changes']")
public WebElement saveChangesBtn;

@FindBy(xpath = "(//tbody/tr/td[3])[1]")
public WebElement actualName;

@FindBy(xpath = "(//tbody/tr/td[4])[1]")
public WebElement actualAuthor;

@FindBy(xpath = "(//tbody/tr/td[2])[1]")
public WebElement actualIsnb;

@FindBy(xpath = "(//tbody/tr/td[6])[1]")
public WebElement actualyear;

@FindBy(xpath = "(//tbody//tr//td)[1]")
public WebElement studentBooks;





public void clickSaveChangesBtn() throws InterruptedException {
    Thread.sleep(1500);
    saveChangesBtn.click();

}





}
