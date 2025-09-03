package com.example.feature_login.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.components.CustomTextField
import com.example.ui.theme.ComposeTheme

@Composable
fun CustomPhoneField(
    modifier: Modifier = Modifier,
    value: String, placeholder: String,
    onValueChange: (String) -> Unit
) {
    CustomTextField(
        value = value,
        placeholder = placeholder,
        modifier = modifier.height(36.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        onValueChange = onValueChange
    )
}

@Composable
fun CustomPasswordField(
    modifier: Modifier = Modifier,
    value: String, placeholder: String,
    onValueChange: (String) -> Unit
) {
    CustomTextField(
        value = value,
        placeholder = placeholder,
        modifier = modifier.height(36.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = onValueChange
    )
}

@Composable
fun CustomNameField(
    modifier: Modifier = Modifier,
    value: String, placeholder: String,
    onValueChange: (String) -> Unit
) {
    CustomTextField(
        value = value,
        placeholder = placeholder,
        modifier = modifier.height(36.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = onValueChange
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ComposeTheme {
        CustomPhoneField(
            value = "",
            placeholder = "placeholder",
            onValueChange = {}
        )
    }
}