package com.ashish.columnandrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ashish.columnandrow.ui.theme.ColumnAndRowTheme
import kotlinx.coroutines.launch

class TextViewCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fontFamily = FontFamily(
            Font(R.font.ptsansbold, FontWeight.Normal)
        )
        setContent {
            var password by rememberSaveable { mutableStateOf("") }
            var passwordVisibility by remember { mutableStateOf(false) }
            val scaffoldState = rememberScaffoldState()
            var textFieldState by remember {
                mutableStateOf("")
            }
            var sureNameTextFieldState by remember {
                mutableStateOf("")
            }
            var addressTextFieldState by remember {
                mutableStateOf("")
            }
            val scope = rememberCoroutineScope()
            ColumnAndRowTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)

                ) {
                    /* Text(
                         text = buildAnnotatedString {
                             withStyle(
                                 style = SpanStyle(
                                     color = Color.Red,
                                     fontSize = 40.sp
                                 )
                             ) {
                                 append("A")
                             }
                             append("shish")
                             withStyle(
                                 style = SpanStyle(
                                     color = Color.Red,
                                     fontSize = 40.sp
                                 )
                             ) {
                                 append(" P")
                             }
                             append("ujari")

                         },
                         fontSize = 24.sp,
                         color = Color.White,
                         fontFamily = fontFamily,
                         fontStyle = FontStyle.Italic,
                         textAlign = TextAlign.Center,
                         textDecoration = TextDecoration.Underline
                     )*/
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp)
                    ) {
                        EditTextField(
                            value = textFieldState,
                            label = "Enter First name",
                            onValueChange = {
                                textFieldState = it
                            },
                            isSingleLine = true,
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        EditTextField(
                            value = sureNameTextFieldState,
                            onValueChange = {
                                sureNameTextFieldState = it
                            },
                            label = "Enter last name",
                            isSingleLine = true,
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        EditTextField(
                            value = addressTextFieldState,
                            isSingleLine = false,
                            label = "Enter address",
                            onValueChange = {
                                addressTextFieldState = it
                            },
                            maxLines = 2
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Password") },
                            placeholder = { Text("Password") },
                            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            trailingIcon = {
                                val image = if (passwordVisibility)
                                    Icons.Filled.Visibility
                                else Icons.Filled.VisibilityOff

                                IconButton(onClick = {
                                    passwordVisibility = !passwordVisibility
                                }) {
                                    Icon(imageVector = image, "")
                                }
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        Button(
                            onClick = {
                                scope.launch {
                                    scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                                }
                            },
                            enabled = (textFieldState.isNotEmpty() && sureNameTextFieldState.isNotEmpty() && addressTextFieldState.isNotEmpty() && password.isNotEmpty())
                        ) {
                            Text(text = "Click me....")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EditTextField(
    value: String,
    isSingleLine: Boolean,
    modifier: Modifier = Modifier.fillMaxWidth(),
    label: String,
    maxLines: Int = 1,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        singleLine = isSingleLine,
        modifier = modifier,
        maxLines = maxLines
    )
}