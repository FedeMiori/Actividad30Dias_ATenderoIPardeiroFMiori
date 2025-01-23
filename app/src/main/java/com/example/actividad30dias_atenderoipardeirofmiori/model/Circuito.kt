package com.example.actividad30dias_atenderoipardeirofmiori.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Circuito (
    @StringRes val nombre: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val descripcion: Int
)