package com.github.murillo.ui.utils

enum class CareerType(val typeCareer: String?) {
    TEACHER("PROFESSOR"),
    DEVELOPER("DEVELOPER"),
    ENGINEER("ENGINEER");

    companion object {
        fun getCareerType(): MutableList<CareerType> {
            val careerTypeList = mutableListOf<CareerType>()
            careerTypeList.add(TEACHER)
            careerTypeList.add(DEVELOPER)
            careerTypeList.add(ENGINEER)
            return careerTypeList
        }
    }
}