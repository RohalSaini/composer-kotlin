package com.example.sanssystechnology.repository

class PersonRepository {
    fun getAllData(): List<Person> {
        return listOf(
            Person(
                id = 0,
                firstName = "John",
                lastName = "One",
                age = 20
            ),
            Person(
                id = 0,
                firstName = "John",
                lastName = "Two",
                age = 20
            ),
            Person(
                id = 0,
                firstName = "John",
                lastName = "Three",
                age = 20
            ),
            Person(
                id = 0,
                firstName = "John",
                lastName = "Four",
                age = 20
            )
        )
    }
}

data class  Person(
    var id:Int,
    var firstName:String,
    val lastName:String,
    var age:Int
)