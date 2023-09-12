package com.scaler.Splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
@Entity(name = "SPLITWISE_USEREXPENSE")
public class UserExpense extends BaseModel {

    @ManyToOne
    private User user;
    private double amount;
    // so multiple user expenses be part of single expense.
    @ManyToOne
    private Expense expense;

    @Enumerated(value = EnumType.ORDINAL)
    private UserExpenseType userExpenseType;

}
