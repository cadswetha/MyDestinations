package com.cads.mydestinations.network

import com.google.gson.annotations.SerializedName

data class Dest(
    @SerializedName("id") var id :Int = 0,
    @SerializedName("city") var city        : String?               = null,
    @SerializedName("country") var country       : String?            = null
)
