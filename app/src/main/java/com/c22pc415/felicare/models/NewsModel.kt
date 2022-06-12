package com.c22pc415.felicare.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsModel (
    val titlenews: String? = null,
    val createdAt: String? = null,
    val image: String? = null,
    val desc: String? = null
) : Parcelable
