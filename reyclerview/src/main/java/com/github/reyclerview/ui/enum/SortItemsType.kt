package com.github.reyclerview.ui.enum

enum class SortItemsType(val numbers: Int) {
    NUMBER_1(1),
    NUMBER_2(2),
    NUMBER_3(3),
    NUMBER_4(4);

    companion object {
        fun getListNumber(): MutableList<SortItemsType> {
            val numbersList = mutableListOf<SortItemsType>()
            numbersList.add(NUMBER_3)
            numbersList.add(NUMBER_1)
            numbersList.add(NUMBER_2)
            numbersList.add(NUMBER_4)
            return numbersList
        }
    }
}