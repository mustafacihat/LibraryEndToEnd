package com.cybertekschool.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddBookPage extends BasePage {
    @FindBy(xpath = "(//*[@id=\"books\"]/div[1]/div[1]/h3)")
    public WebElement BooksPageTitle;
    @FindBy(xpath = "(//*[@id=\"books\"]/div[1]/div[1]/span/a)")
    public WebElement AddBookButton;
    @FindBy(xpath = "(//*[@id=\"add_book_form\"]/div[1]/div/div[1]/div[1]/div/input)")
    public WebElement BookNameInputBox;
    @FindBy(xpath = "(//input)[3]")
    public WebElement ISBNinputBox;
    @FindBy(xpath = "(//input)[4]")
    public WebElement YearInputBox;
    @FindBy(xpath = "(//*[@id=\"add_book_form\"]/div[1]/div/div[2]/div[1]/div/input)")
    public WebElement AuthorInputBox;
    @FindBy(xpath = "(//*[@id=\"description\"])")
    public WebElement DescriptionInputBox;
    @FindBy(xpath = "(//*[@id=\"add_book_form\"]/div[2]/button[2])")
    public WebElement SaveChangesButton;
    @FindBy(xpath = "(//*[@id=\"book_group_id\"])")
    public WebElement BookCategoryDropdown;
    @FindBy(xpath = "//button[.='Save changes']")
    public WebElement AddBookMenu;
    @FindBy(xpath = "(//*[@id=\"tbl_books_filter\"]/label/input)")
    public WebElement SearchBox;

    @FindBy(xpath = "//h5[.='Add Book']")
    public WebElement addBookText;

    @FindBy(css = "div#add_book_modal")
    public WebElement popUp;

    @FindBy(xpath = "(//td[3])[1]")
    public WebElement expextedBook;



}
