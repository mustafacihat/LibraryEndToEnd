package com.cybertekschool.library.utils.api;

public interface Endpoints {
    String ADD_USER = "/add_user";
    String LOGIN = "/login";

    //books
    String GET_BOOK_BY_ID = "/get_book_by_id/{id}";
    String ADD_BOOK = "/add_book";
    String GET_BOOK_CATEGORIES = "/get_book_categories";
    String DELETE_BOOK = "/delete_book/{id}";
    String UPDATE_BOOK = "/update_book";
    String AVAILABLE_BOOKS= "/get_book_list_for_borrowing";
    String DASHBOARD_STATS ="/dashboard_stats";
}
