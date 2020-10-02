package com.cybertekschool.library.pages;


import com.cybertekschool.library.utils.ui.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

public class BookManagementPage extends BasePage {

    public BookManagementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm  ']")
    public WebElement borrowbookbutton;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm  ']/../..")
    public WebElement bookrow;


    @FindBy(css = "select[name='tbl_books_length']")

    public WebElement recordsDropDown;

    @FindBy(css = "//a[@class='btn btn-primary btn-sm  ']")
    public WebElement book;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement thebookbarrowedverificiationtext;

    @FindBy(css = ".card-header")
    public WebElement bookList;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm  disabled']")
    public WebElement unabletobarrow;


    //broowed book infos
    //public String borrowedBookData = bookrow.getText();


    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(tagName = "input")
    public WebElement search;

    @FindBy(css = "[href='tpl/add-book.html']")
    public WebElement addBook;

    @FindBy(name = "name")
    public WebElement bookName;

    @FindBy(name = "isbn")
    public WebElement isbn;

    @FindBy(name = "year")
    public WebElement year;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement author;

    @FindBy(id = "description")
    public WebElement description;

    @FindBy(id = "book_group_id")
    public WebElement categoryElement;

    @FindBy(id = "book_categories")
    public WebElement mainCategoryElement;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm ']")
    public WebElement returnBook;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement returnBookVerificaiton;

    @FindBy(xpath = "//td[2]")
    public List<WebElement> borrowedbookList;

    @FindBy(xpath = "//thead/tr/th[7]")
    public WebElement borrowedBy;


    public WebElement editBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public Select categoryList() {
        return new Select(categoryElement);
    }

    public Select mainCategoryList() {
        return new Select(mainCategoryElement);
    }


    //For showing all books on the page select dropdown list
    public void recordSelector(String value) {
        Select select = new Select(recordsDropDown);


        select.selectByValue(value);
    }

    public String borrowedVerification() throws InterruptedException {


        //recordSelector("500");

        Thread.sleep(2000);
        borrowedBy.click();

        Thread.sleep(1000);
        String bookName = "";
        for (int i = 1; i <= 500; i++) {

            Driver.getDriver().findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).click();
            bookName = Driver.getDriver().findElement(By.xpath("//tbody/tr[" + i + "]/td[3]")).getText();


            try {
                if (thebookbarrowedverificiationtext.isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
                continue;
            }


        }

        return bookName;


    }


}
