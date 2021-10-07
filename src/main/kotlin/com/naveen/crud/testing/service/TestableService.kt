package com.naveen.crud.testing.service



class TestableService {
    // Nikhil - HelloNikhil
    fun getDataFromDb(testParameter: String): String {
        // query database and return matching value
        return "Hello$testParameter"
    }

    // anything-> I don't want to!
    fun doSomethingElse(testParameter: String): String {
        return "I don't want to!"
    }
}