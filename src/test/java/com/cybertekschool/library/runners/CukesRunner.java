package com.cybertekschool.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        },

        features = "src/test/resources/features",
        glue = "com/cybertekschool/library/step_definitions",
        dryRun = false,
<<<<<<< HEAD
        tags = "@Dashboard"
=======

        tags = "@addbook-api"

>>>>>>> ef8671c63121601dee1e74f36c7b4f524151318b
)
public class CukesRunner {
}
