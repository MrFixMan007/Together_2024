package com.example.profsoft_2024_final_task.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profsoft_2024_final_task.presentation.theme.ComposeTheme
import com.example.profsoft_2024_final_task.presentation.theme.DarkGray
import com.example.profsoft_2024_final_task.presentation.theme.Typography

private val defaultContentColor = DarkGray
private val defaultContainerColor = DarkGray.copy(alpha = 0.2f)
private const val minPasswordLength = 8

@Composable
fun CustomTextField(
    textState: MutableState<TextFieldValue>, placeholder: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = Typography.bodySmall,
    containerColor: Color = defaultContainerColor,
    contentColor: Color = defaultContentColor,
    shape: Shape = RoundedCornerShape(size = 8.dp),
    keyboardOptions: KeyboardOptions,
    onValueChange: (TextFieldValue) -> Unit,
) {
    BasicTextField(
        value = textState.value,
        onValueChange = onValueChange,
        textStyle = textStyle.copy(color = contentColor),
        singleLine = true,
        decorationBox = { innerTextField ->
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = modifier
                    .background(containerColor, shape)
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth()
            ) {
                if (textState.value.text.isEmpty()) {
                    Text(
                        text = placeholder,
                        style = Typography.bodySmall,
                        color = contentColor
                    )
                }
                innerTextField()
            }
        },
        keyboardOptions = keyboardOptions,
        modifier = Modifier
    )
}

@Composable
fun CustomPhoneField(
    textState: MutableState<TextFieldValue>, placeholder: String,
    modifier: Modifier = Modifier,
    isValidState: MutableState<Boolean>
) {
    CustomTextField(
        textState = textState,
        placeholder = placeholder,
        modifier = modifier.height(36.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        onValueChange = {
            val phoneNumberRegex = "^[+]?[0-9]*\$".toRegex()

            if (it.text.isNotEmpty() && it.text.matches(phoneNumberRegex) && it.text.first() != '0') {
                val newValue = if ((it.text == "+" || it.text == "7") && textState.value.text == "")
                    it.copy(
                        text = "+7",
                        selection = TextRange(2)
                    )
                else it

                if ((newValue.text.startsWith("+7") && newValue.text.length <= 12)) {
                    textState.value = newValue
                    isValidState.value = newValue.text.length == 12
                } else if (newValue.text.length <= 11) {
                    textState.value = newValue
                    isValidState.value = newValue.text.length == 11
                }

            } else if (it.text.isEmpty() && textState.value.text.isNotEmpty()) {
                textState.value = it
                isValidState.value = false
            }
        }
    )
}

@Composable
fun CustomPasswordField(
    textState: MutableState<TextFieldValue>, placeholder: String,
    modifier: Modifier = Modifier,
    isValidState: MutableState<Boolean>
) {
    CustomTextField(
        textState = textState,
        placeholder = placeholder,
        modifier = modifier.height(36.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = {
            textState.value = it
            isValidState.value = it.text.length >= minPasswordLength
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ComposeTheme {
        CustomPhoneField(
            textState = remember { mutableStateOf(TextFieldValue("")) },
            placeholder = "placeholder",
            isValidState = remember { mutableStateOf(false) }
        )
    }
}