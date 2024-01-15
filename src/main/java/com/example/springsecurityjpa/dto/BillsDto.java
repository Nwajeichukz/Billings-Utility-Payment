package com.example.springsecurityjpa.dto;

import lombok.Data;

@Data
public class BillsDto {
    private String country;
    private String customer;
    private String amount;
    private String recurrence;
    private String type;
    private String reference;

    private String biller_name;
}
