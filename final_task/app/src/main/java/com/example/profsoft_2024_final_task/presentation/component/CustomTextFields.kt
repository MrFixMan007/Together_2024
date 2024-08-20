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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profsoft_2024_final_task.presentation.theme.ComposeTheme
import com.example.profsoft_2024_final_task.presentation.theme.DarkGray
import com.example.profsoft_2024_final_task.presentation.theme.Typography

private val defaultContentColor = DarkGray
private val defaultContainerColor = DarkGray.copy(alpha = 0.2f)

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    placeholder: String = "",
    textStyle: TextStyle = Typography.bodySmall,
    containerColor: Color = defaultContainerColor,
    contentColor: Color = defaultContentColor,
    shape: Shape = RoundedCornerShape(size = 8.dp),
    keyboardOptions: KeyboardOptions,
    onValueChange: (String) -> Unit,
) {
    BasicTextField(
        value = value,
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
                if (value.isEmpty()) {
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