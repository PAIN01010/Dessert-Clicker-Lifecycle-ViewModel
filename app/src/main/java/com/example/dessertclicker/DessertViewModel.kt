
package com.example.dessertclicker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dessertclicker.model.Dessert

class DessertViewModel : ViewModel() {

    var uiState by mutableStateOf(DessertUiState())
        private set

    fun onDessertClicked(price: Int) {
        uiState = uiState.copy(
            revenue = uiState.revenue + price,
            dessertsSold = uiState.dessertsSold + 1
        )
    }

    fun determineDessertToShow(desserts: List<Dessert>): Dessert {
        var dessertToShow = desserts.first()

        for (dessert in desserts) {
            if (uiState.dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                break
            }
        }

        return dessertToShow
    }
}
