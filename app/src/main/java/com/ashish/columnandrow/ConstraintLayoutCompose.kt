package com.ashish.columnandrow

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

class ConstraintLayoutCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val constraints = ConstraintSet {
                val greenBox = createRefFor("greenBox")
                val redBox = createRefFor("redBox")
                val topGuideline = createGuidelineFromTop(0.1f)
                constrain(greenBox) {
                    // top.linkTo(parent.top)
                    top.linkTo(topGuideline)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }
                constrain(redBox) {
                    //top.linkTo(parent.top)
                    top.linkTo(topGuideline)
                    start.linkTo(greenBox.end)
                    end.linkTo(parent.end)
                    // width = Dimension.fillToConstraints
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }
                //createHorizontalChain(greenBox,redBox)
                createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Spread)
            }
            ConstraintLayout(constraintSet = constraints, modifier = Modifier.fillMaxSize()) {
                val context = LocalContext.current
                Box(modifier = Modifier
                    .background(Color.Green)
                    .layoutId("greenBox")
                    .clickable {
                        context.startActivity(Intent(context, NetConstraintLayout::class.java))
                    })
                Box(
                    modifier = Modifier
                        .background(Color.Red)
                        .layoutId("redBox")
                )
            }
        }
    }
}
