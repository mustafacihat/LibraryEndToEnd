package com.cybertekschool.library.step_definitions.ENDtoEND;

import com.cybertekschool.library.pages.LibraryLoginPage;
import com.cybertekschool.library.utils.common.Encoder;
import com.cybertekschool.library.utils.common.Environment;
import com.cybertekschool.library.utils.common.LibraryUserUtility;
import io.cucumber.java.en.When;
import org.junit.Test;

public class LoginStepDefs {

    @When("the user logs in as student")
    public void the_user_logs_in_as_student() {
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
        libraryLoginPage.loginLibrary(Environment.getProperty("student_email"),Encoder.decrypt(Environment.getProperty("student_password")));
    }


    @When("the user logs in as librarian")
    public void the_user_logs_in_as_librarian() {
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
        libraryLoginPage.loginLibrary(Environment.getProperty("librarian_email"),Encoder.decrypt(Environment.getProperty("librarian_password")));
    }


}
