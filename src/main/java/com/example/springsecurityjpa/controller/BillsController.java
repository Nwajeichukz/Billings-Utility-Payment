package com.example.springsecurityjpa.controller;

import com.example.springsecurityjpa.dto.BillsDto;
import com.example.springsecurityjpa.service.BillsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BillsController {
    private final BillsService billsService;

    @PostMapping
    public String createBills(@RequestBody BillsDto billsDto){
        return billsService.createBill(billsDto);
    }

    @GetMapping
    public String billsCategory(){
        return billsService.getBillCategory();
    }
}
