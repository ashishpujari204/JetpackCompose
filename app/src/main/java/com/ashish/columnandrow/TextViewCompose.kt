package com.ashish.columnandrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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
            val scaffoldState = rememberScaffoldState()
            var textFieldState by remember {
                mutableStateOf("")
            }
            var sureNameTextFieldState by remember {
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
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp)
                    ) {
                        OutlinedTextField(
                            value = textFieldState,
                            label = {
                                Text(text = "Enter First name")
                            },
                            onValueChange = {
                                textFieldState = it
                            },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        OutlinedTextField(
                            value = sureNameTextFieldState, onValueChange = {
                                sureNameTextFieldState = it
                            },
                            label = {
                                Text(text = "Enter last name")
                            },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        Button(onClick = {
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                            }
                        }) {
                            Text(text = "Click me....")
                        }
                    }

                }
            }
        }
    }
}