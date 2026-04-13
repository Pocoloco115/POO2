package com.example.formulario

data class OrderFormState(
    val customerName: String = "",
    val phone: String = "",
    val address: String = "",
    val product: String = "",
    val quantityText: String = "",
    val notes: String = ""
)

data class OrderFormErrors(
    val customerNameError: String? = null,
    val phoneError: String? = null,
    val addressError: String? = null,
    val productError: String? = null,
    val quantityError: String? = null
) {
    val hasErrors: Boolean
        get() = listOf(
            customerNameError,
            phoneError,
            addressError,
            productError,
            quantityError
        ).any { it != null }
}

object OrderFormValidator {

    fun validateCustomerName(name: String): String? =
        if (name.trim().length < 3) "Name must have at least 3 characters" else null

    fun validatePhone(phone: String): String? =
        when {
            phone.isBlank() -> "Phone is required"
            !phone.all { it.isDigit() } -> "Phone must contain digits only"
            phone.length < 8 -> "Phone must have at least 8 digits"
            else -> null
        }

    fun validateAddress(address: String): String? =
        if (address.isBlank()) "Address is required" else null

    fun validateProduct(product: String): String? =
        if (product.isBlank()) "Product is required" else null

    fun validateQuantity(quantityText: String): String? {
        if (quantityText.isBlank()) return "Quantity is required"
        val num = quantityText.toIntOrNull()
        return when {
            num == null -> "Quantity must be a valid number"
            num <= 0 -> "Quantity must be greater than zero"
            else -> null
        }
    }

    fun validateAll(state: OrderFormState): OrderFormErrors {
        return OrderFormErrors(
            customerNameError = validateCustomerName(state.customerName),
            phoneError = validatePhone(state.phone),
            addressError = validateAddress(state.address),
            productError = validateProduct(state.product),
            quantityError = validateQuantity(state.quantityText)
        )
    }

    fun isFormValid(state: OrderFormState): Boolean {
        val errors = validateAll(state)
        val requiredFilled =
            state.customerName.isNotBlank() &&
                    state.phone.isNotBlank() &&
                    state.address.isNotBlank() &&
                    state.product.isNotBlank() &&
                    state.quantityText.isNotBlank()

        return !errors.hasErrors && requiredFilled
    }
}