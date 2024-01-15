package com.example.springsecurityjpa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class BillsPaymentResponse {
    private int status;
    private String message;

    private  Data data;



    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Setter
    @Getter
    public class Data{
        private String phone_number;
        private String amount;
        private String network;
        private String flw_ref;
        private String tx_ref;
        private String reference;
    }
}
