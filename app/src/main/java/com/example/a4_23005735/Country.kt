package com.example.a4_23005735

import androidx.core.view.ContentInfoCompat.Flags

data class Country(
    val name: Name,
    val flags: Flags
)

data class Name(
    val common: String
)

data class Flags(
    val png: String
)
