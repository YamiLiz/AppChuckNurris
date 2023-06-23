package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.CategoryDetailModel
import com.example.myapplication.domain.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetCategoriesViewModel @Inject constructor(
    private val useCase: GetCategoriesUseCase
) : ViewModel (){

    val listCategories = MutableLiveData<List<String>>()
    val detailCategory = MutableLiveData<CategoryDetailModel>()

    fun getCategories(){
        viewModelScope.launch {
            listCategories.value = useCase.invoke()
        }
    }

    fun getDetailCategory(caterogy: String){
        viewModelScope.launch {
            detailCategory.value = useCase.searchCategories(caterogy)
        }
    }
}