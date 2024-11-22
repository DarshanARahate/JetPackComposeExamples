package com.compose.jetpackcomposeexamples

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId

//import androidx.constraintlayout.widget.ConstraintLayout

/**
ConstraintSet {
// Create references for the composables to use in constraints
val box1 = createRefFor("box1")
val box2 = createRefFor("box2")

// Define constraints
constrain(box1) {
top.linkTo(parent.top)
start.linkTo(parent.start)
}
constrain(box2) {
top.linkTo(box1.bottom, margin = 16.dp)
start.linkTo(box1.end, margin = 16.dp)
}
}
 */

@Composable
fun ConstraintLayoutCompose() {
    val (flag) = createRefs()

    val constraintSet = ConstraintSet {
        val flag = createRefFor("flag")
        val country = createRefFor("country")
        val capital = createRefFor("capital")

        val officialName = createRefFor("officialName")
        val region = createRefFor("region")
        val subregion = createRefFor("subregion")
        val currencySymbol = createRefFor("currencySymbol")
        val currencyName = createRefFor("currencyName")
        val mobileCode = createRefFor("mobileCode")
        val tld = createRefFor("tld")

        constrain(flag) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        }
        constrain(country) {
            top.linkTo(flag.bottom)
            start.linkTo(parent.start)
            end.linkTo(flag.end)
        }
        constrain(capital) {
            top.linkTo(country.bottom)
            start.linkTo(parent.start)
            end.linkTo(flag.end)
        }

        constrain(officialName) {
            top.linkTo(parent.top)
            start.linkTo(flag.end)
            end.linkTo(parent.end)
        }

        constrain(region) {
            top.linkTo(officialName.bottom)
            start.linkTo(flag.end)
            end.linkTo(parent.end)
        }
        constrain(subregion) {
            top.linkTo(region.bottom)
            end.linkTo(parent.end)
        }
        constrain(currencySymbol) {
            top.linkTo(subregion.bottom)
            start.linkTo(capital.end)
        }
        constrain(currencyName) {
            top.linkTo(subregion.bottom)
            start.linkTo(currencySymbol.end)
            end.linkTo(mobileCode.start)
        }
        constrain(mobileCode) {
            top.linkTo(subregion.bottom)
            end.linkTo(parent.end)
        }
        constrain(tld) {
            top.linkTo(mobileCode.bottom)
            end.linkTo(parent.end)
        }

    }

    val imageResId = R.drawable.`in` // Replace with your PNG image resource ID
    val imagePainter: Painter = painterResource(id = imageResId)
    ConstraintLayout(
        constraintSet = constraintSet,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(5.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .layoutId("flag")
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = imagePainter, contentDescription = "Country Flag",
                modifier = Modifier
                    .width(100.dp)
                    .height(40.dp)

            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .padding(2.dp)
                .layoutId("country"),
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            text = "India"
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .padding(2.dp)
                .layoutId("capital"),
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            text = "New Delhi"
        )

        Text(
            text = "Republic of India",
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .layoutId("officialName")
                .background(Color.Cyan),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
        )

        Text(
            text = "Asia",
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .layoutId("region")
                .background(Color.Gray),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
        )

        Text(
            text = "South Asia",
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .layoutId("subregion")
                .background(Color.DarkGray),
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
        )

        Box(
            modifier = Modifier
                .width(35.dp)
                .height(35.dp)
                .padding(2.dp)
                .drawBehind {
                    drawCircle(
                        color = Color.LightGray,
                        radius = 15.dp.toPx()
                    )
                }
                .layoutId("currencySymbol"),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "₹",
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp),
                textAlign = TextAlign.Center
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(35.dp)
                .layoutId("currencyName"),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "India Rupee",
                fontSize = 12.sp,
            )
        }
        Text(
            text = "+91",
            modifier = Modifier
                .layoutId("mobileCode")
                .width(35.dp),
            fontSize = 12.sp,
            textAlign = TextAlign.End,
        )
        Text(
            text = ".in",
            modifier = Modifier
                .layoutId("tld")
                .width(35.dp),
            fontSize = 12.sp,
            textAlign = TextAlign.End,
        )
    }


}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutComposePreview() {
    ConstraintLayoutCompose()
}