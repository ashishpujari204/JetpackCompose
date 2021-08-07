package com.ashish.columnandrow

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ashish.columnandrow.ui.theme.ColumnAndRowTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnAndRowTheme {
                val context = LocalContext.current
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.size(10.dp))
                    CustomButton(
                        buttonTitle = resources.getString(R.string.row_column_button_title),
                        onClick = {
                            context.startActivity(Intent(context, RowAndColumn::class.java))
                        }
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    CustomButton(
                        buttonTitle = resources.getString(R.string.image_button_title),
                        onClick = {
                            context.startActivity(Intent(context, ImageCard::class.java))
                        }
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    CustomButton(
                        buttonTitle = resources.getString(R.string.button_textview),
                        onClick = {
                            context.startActivity(Intent(context, TextViewCompose::class.java))
                        }
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    CustomButton(
                        buttonTitle = resources.getString(R.string.title_activity_state_demo),
                        onClick = {
                            context.startActivity(Intent(context, StateDemo::class.java))
                        }
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    CustomButton(
                        buttonTitle = resources.getString(R.string.list_button_title),
                        onClick = {
                            context.startActivity(Intent(context, List::class.java))
                        }
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                }
            }
        }
    }
}

@Composable
fun CustomButton(
    buttonTitle: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        enabled = true,
        border = BorderStroke(width = 4.dp, color = Color.White),
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
    ) {
        Text(text = buttonTitle)
    }
}