package com.github.reyclerview.ui.enum

enum class SortItemsType(val numbers: Int, val txtOrder: String) {
    NUMBER_1(1, "OLA"),
    NUMBER_2(2, "RAIMUNDO"),
    NUMBER_3(3, "JOSE"),
    NUMBER_4(4, "RAIMUNDO");

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