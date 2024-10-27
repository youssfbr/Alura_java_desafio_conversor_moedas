package com.github.youssfbr.conversor.dtos;

import com.google.gson.annotations.SerializedName;

public record ExchangeRate (
        String result ,

        @SerializedName("time_last_update_utc")
        String moment ,
        @SerializedName("base_code")
        String baseCode ,
        @SerializedName("target_code")
        String targetCode ,

        @SerializedName("conversion_rate")
        Double conversionRate ,

        @SerializedName("conversion_result")
        Double conversionResult

        ) {

        @Override
        public String toString() {
                return '[' + baseCode + ']' +
                        " atualizado em " + moment +
                        " \ncorresponde ao valor final de =>>> " +
                        conversionResult + " [" +
                        targetCode + ']';
        }
}
