package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameResourceId: Int,
    val numberAssociatedCourse: Int,
    @DrawableRes val imageResourceId: Int
)

