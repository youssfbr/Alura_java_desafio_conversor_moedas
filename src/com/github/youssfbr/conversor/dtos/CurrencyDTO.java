package com.github.youssfbr.conversor.dtos;

import com.google.gson.annotations.SerializedName;

public record CurrencyDTO(
        String result ,
        @SerializedName("base_code")
        String baseCode ,

        @SerializedName("conversion_rates")
        ConversionRates conversionRates
) {
}
