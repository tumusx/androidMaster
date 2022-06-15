package com.github.murillo.ui.utils

enum class PersonType(val nome: String) {
    PERSON_1("CASCAO"),
    PERSON_2("MURILLO"),
    PERSON_3("JOSE"),
    PERSON_4("RAIMUNDO"),
    PERSON_5("CARLINHA");

    companion object {
        fun listName(): MutableList<PersonType> {
            val list = mutableListOf<PersonType>()
            list.add(PERSON_1)
            list.add(PERSON_2)
            list.add(PERSON_3)
            list.add(PERSON_4)
            list.add(PERSON_5)
            return list
        }
    }

}