package com.example.gm_coding.util

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("app:toggleProgressState")
fun <T> ProgressBar.toggleProgressState(state: ApiState<T>?) {
    visibility = if (state is ApiState.Loading) View.VISIBLE else View.GONE
}

@BindingAdapter("app:toggleButtonState")
fun <T> MaterialButton.toggleButtonState(state: ApiState<T>?) {
    val isLoading = state is ApiState.Loading
    isEnabled = isLoading.not()
}

@BindingAdapter(value = ["app:stateLD", "app:query"])
fun <T> TextInputLayout.toggleSearchState(
    stateLD: LiveData<ApiState<T>?>,
    query: ObservableField<String>? = null
) {
    val apiState = stateLD.value
    if (apiState is ApiState.Error) error = apiState.msg
    isErrorEnabled = apiState is ApiState.Error || query?.get().isNullOrBlank()
}

@BindingAdapter("app:toCurrency")
fun MaterialTextView.toCurrency(num: Double) {
    text = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(num)
}

@BindingAdapter(value = ["app:date", "app:genre"])
fun MaterialTextView.setSubtitle(date: String, genre: String) {
    val formattedDate = try {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        sdf.parse(date)?.let {
            SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(it)
        }
    } catch (e: Exception) {
        null
    }
    text = String.format("%s %s", formattedDate, genre)
}