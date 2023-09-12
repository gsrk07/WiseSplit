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

    //Uni directional
    @ManyToOne
    private User user;
    private double amount;
//    // so multiple user expenses can be part of single expense.
//    @ManyToOne
//    private Expense expense;
    @Enumerated(value = EnumType.ORDINAL)
    private UserExpenseType userExpenseType;

    /*
    User : UserExpense -> 1:M
    Expense : UserExpense -> 1:M

      Expense { for each expense we want to know the userExpense, hence it is good to keep query on Expense side for userexpenses}
       paid : A=100, B=100
       hasToPay : A=50, B=50, C=100
 */

}
