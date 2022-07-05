package com.ashish.columnandrow

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ashish.columnandrow.ui.theme.ColumnAndRowTheme

class CustomCheckBox : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            var checkBox1 by remember {
                mutableStateOf(false)
            }
            var checkBox2 by remember {
                mutableStateOf(false)
            }
            var checkBox3 by remember {
                mutableStateOf(false)
            }

            ColumnAndRowTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(checked = checkBox1, onCheckedChange = { checked ->
                            checkBox1 = checked
                        })
                        Spacer(modifier = Modifier.size(10.dp))
                        Text("Checkbox")
                    }
                    MyCheckBox(checkboxText = "CheckBox1", isSelected = checkBox2, onClick = {
                        checkBox2 = it
                        Toast.makeText(context, "Clicked $it", Toast.LENGTH_LONG).show()
                    })
                    MyCheckBox(checkboxText = "CheckBox2", isSelected = checkBox3, onClick = {
                        checkBox3 = it
                        Toast.makeText(context, "Clicked $it", Toast.LENGTH_LONG).show()
                    })
                    MyCheckBoxList()
                }
            }
        }
    }
}

@Composable
fun MyCheckBox(
    checkboxText: String,
    isSelected: Boolean,
    onClick: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isSelected,
            onCheckedChange = onClick,
            colors = CheckboxDefaults.colors(Color.Red)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(checkboxText)
    }
}

@Composable
fun MyCheckBoxList() {
    val list = arrayListOf("Android", "Apple", "Windows", "Google")
    list.forEach {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            var comman by remember {
                mutableStateOf(false)
            }
            Checkbox(
                checked = comman,
                onCheckedChange = {
                    comman = it
                },
                colors = CheckboxDefaults.colors(Color.Red)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(it)
        }
    }
}