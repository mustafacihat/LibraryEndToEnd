package com.cybertekschool.library.utils.common;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LibraryUserUtility {
    /**
     * take user type create map that contains student or librarian user form data
     *
     * @param userGroup
     * @return user map
     */


    public static Map<String, Object> createUser(int userGroup) {
        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        String usernameEmail = faker.name().username();
        String companyUrl = faker.company().url().substring(4);
        String email = usernameEmail + "@" + companyUrl;
        String address = faker.address().fullAddress();
        Map<String, Object> user = new HashMap<>();
        user.put("full_name", fullName);
        user.put("email", email);
        user.put("password", faker.number().digits(5));
        user.put("user_group_id", userGroup);
        user.put("status", "active");
        user.put("start_date", "2020-05-05");
        user.put("end_date", "2021-05-05");
        user.put("address", address);
        return user;
    }

    public static Map<String, String> createBook() {

        Map<String, String> book = new HashMap<>();
        Random rd = new Random();

        Faker faker = new Faker();
        String bookName = "Book" + rd.nextInt(500000) + 500000;
        String author = faker.book().author();
        String year = String.valueOf(rd.nextInt(2020));
        long l = 1000000000000L;
        int isbnTemp = rd.nextInt(1000000000) + 1000000000;
        String isbn = "aa" + String.valueOf(isbnTemp * 11L);
        String bookCatID = String.valueOf(rd.nextInt(4) + 1);
        String description = "Test Generated";

        book.put("name", bookName);
        book.put("isbn", isbn);
        book.put("year", year);
        book.put("author", author);
        book.put("book_category_id", bookCatID);
        book.put("description", description);

        return book;
    }

    public static Map<String, Object> editableBookInfo() {

        Map<String, Object> book = new HashMap<>();
        Random rd = new Random();

        Faker faker = new Faker();
        String bookName = "Book" + rd.nextInt(500000) + 500000;
        String author = faker.book().author();
        String year = String.valueOf(rd.nextInt(2020));
        long l = 1000000000000L;
        int isbnTemp = rd.nextInt(1000000000) + 1000000000;
        String isbn = "aa" + String.valueOf(isbnTemp * 11L);
        String bookCatID = String.valueOf(rd.nextInt(4) + 1);
        String description = "Test Generated";

        book.put("id", 100);
        book.put("name", bookName);
        book.put("isbn", isbn);
        book.put("year", year);
        book.put("author", author);
        book.put("book_category_id", bookCatID);
        book.put("description", description);

        return book;


    }

}
