package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.ui.theme.ComposeTheme
import com.example.ui.theme.DarkGray
import com.example.ui.theme.Typography

val defaultTextFieldContentColor = DarkGray
val defaultTextFieldContainerColor = DarkGray.copy(alpha = 0.2f)

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    placeholder: String = "",
    textStyle: TextStyle =  Typography.bodySmall,
    containerColor: Color = defaultTextFieldContainerColor,
    contentColor: Color = defaultTextFieldContentColor,
    shape: Shape = RoundedCornerShape(size = 8.dp),
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
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

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ComposeTheme {
        CustomTextField(
            value = "",
            placeholder = "placeholder",
            onValueChange = {}
        )
    }
}