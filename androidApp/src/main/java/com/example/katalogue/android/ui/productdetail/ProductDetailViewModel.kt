package com.example.katalogue.android.ui.productdetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.katalogue.dataLayer.model.Product
import com.example.katalogue.domain.usecase.GetProductDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductDetailsUseCase: GetProductDetailsUseCase
) : ViewModel() {

    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product

    fun getProductDetail(productId: Int) {
        viewModelScope.launch {
            try {
                _product.value = getProductDetailsUseCase(productId)
            } catch (e: Exception) {
                // Handle error
                Log.e("ProductDetailViewModel", "Error fetching product details", e)
            }
        }
    }
}