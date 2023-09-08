package com.scaler.Splitwise.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TransactionDTO {

    private String fromUserName;

    private String toUserName;

    private double amount;

//    public TransactionDTO(String fromUserName, String toUserName, double amount) {
//        this.fromUserName = fromUserName;
//        this.toUserName = toUserName;
//        this.amount = amount;
//    }
//
//    public TransactionDTO() {
//    }

}
