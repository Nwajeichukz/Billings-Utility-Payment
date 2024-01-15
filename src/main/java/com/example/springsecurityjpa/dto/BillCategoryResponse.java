package com.example.springsecurityjpa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillCategoryResponse {
    private int status;
    private String message;

    private BillsPaymentResponse.Data data;



    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Setter
    @Getter
    public class Data{
        private int id;
        private String biller_code;
        private String name;
        private String default_commission;
        private String date_added;
        private String country;
        private String is_airtime;
        private String biller_name;
        private String item_code;
        private String short_name;
        private String amount;
        private String fee;
        private String commission_on_fee;
        private String label_name;


    }
}
