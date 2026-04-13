package com.example.formulario
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun OrderFormScreen() {
    var formState by remember { mutableStateOf(OrderFormState()) }
    var formErrors by remember { mutableStateOf(OrderFormErrors()) }

    var isSending by remember { mutableStateOf(false) }
    var statusMessage by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    val isFormValid by remember(formState) {
        derivedStateOf { OrderFormValidator.isFormValid(formState) }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Order Form",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = formState.customerName,
            onValueChange = { value ->
                formState = formState.copy(customerName = value)
                formErrors = formErrors.copy(
                    customerNameError = OrderFormValidator.validateCustomerName(value)
                )
            },
            label = { Text("Customer name") },
            isError = formErrors.customerNameError != null,
            modifier = Modifier.fillMaxWidth()
        )
        formErrors.customerNameError?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = formState.phone,
            onValueChange = { value ->
                formState = formState.copy(phone = value)
                formErrors = formErrors.copy(
                    phoneError = OrderFormValidator.validatePhone(value)
                )
            },
            label = { Text("Phone") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = formErrors.phoneError != null,
            modifier = Modifier.fillMaxWidth()
        )
        formErrors.phoneError?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = formState.address,
            onValueChange = { value ->
                formState = formState.copy(address = value)
                formErrors = formErrors.copy(
                    addressError = OrderFormValidator.validateAddress(value)
                )
            },
            label = { Text("Address") },
            isError = formErrors.addressError != null,
            modifier = Modifier.fillMaxWidth()
        )
        formErrors.addressError?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = formState.product,
            onValueChange = { value ->
                formState = formState.copy(product = value)
                formErrors = formErrors.copy(
                    productError = OrderFormValidator.validateProduct(value)
                )
            },
            label = { Text("Product") },
            isError = formErrors.productError != null,
            modifier = Modifier.fillMaxWidth()
        )
        formErrors.productError?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = formState.quantityText,
            onValueChange = { value ->
                formState = formState.copy(quantityText = value)
                formErrors = formErrors.copy(
                    quantityError = OrderFormValidator.validateQuantity(value)
                )
            },
            label = { Text("Quantity") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = formErrors.quantityError != null,
            modifier = Modifier.fillMaxWidth()
        )
        formErrors.quantityError?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = formState.notes,
            onValueChange = { value ->
                formState = formState.copy(notes = value)
            },
            label = { Text("Additional notes (optional)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = {
                    formState = OrderFormState()
                    formErrors = OrderFormErrors()
                    statusMessage = ""
                },
                enabled = !isSending
            ) {
                Text("Clear")
            }

            Button(
                onClick = {
                    if (isSending) return@Button

                    val fullErrors = OrderFormValidator.validateAll(formState)
                    formErrors = fullErrors

                    if (fullErrors.hasErrors) return@Button

                    isSending = true
                    statusMessage = "Sending order..."

                    scope.launch {
                        delay(2000)
                        isSending = false
                        statusMessage =
                            "Order sent successfully. Thank you, ${formState.customerName}!"
                    }
                },
                enabled = isFormValid && !isSending
            ) {
                if (isSending) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        strokeWidth = 2.dp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Sending...")
                } else {
                    Text("Send")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (statusMessage.isNotBlank()) {
            Text(
                text = statusMessage,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
