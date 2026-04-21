package com.example.composablet1.ui.theme

import android.graphics.Color
import android.graphics.drawable.shapes.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import org.w3c.dom.Text

//Colors
data class AppColorScheme(
    val background: Color,
    val onBackground: Color,
    val primary : Color,
    val onPrimary : Color,
    val secondary : Color,
    val onSecondary : Color
)

//Typography
data class AppTypography(
    val titleLarge : TextStyle,
    val titleNomal : TextStyle,
    val body : TextStyle,
    val labelLarge : TextStyle,
    val labelNormal : TextStyle,
    val labelSm : TextStyle
)

//Shape
data class AppShape(
    val container : Shape,
    val button: Shape
)

//Size
data class AppSize(
    val large : Dp,
    val medium : Dp,
    val normal : Dp,
    val small : Dp
)