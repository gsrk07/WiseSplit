package com.scaler.Splitwise.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
//@AllArgsConstructor commenting out to remove the error caused in initialisation service for Expense object creation.
@Entity(name = "SPLITWISE_EXPENSE")
public class Expense extends BaseModel{

    private String description;
    private double amount;
    @OneToMany
    private List<UserExpense> userExpenses;

    /* Relationship
      Expense : UserExpense -> 1:M { uni-directional on expense side}
      Group : Expense -> 1:M { uni-directional on group side } we want to know from the Group, all the expenses and then find out all the outstanding amount.
    */

//    @ManyToOne
//    private Group group;

    @Enumerated(EnumType.ORDINAL)
    //@ElementCollection we dont need element collection here since one expense can only be in one currency. had it been in multiple currencies, then we need @ElementCollection
    private Currency currency;

//    private HashMap<User,Double> paidUsers;
//    private HashMap<User,Double> hastoPayUsers;

//    private List<UserExpense> paidUsersexpenses;
//    private List<UserExpense> hastoPayUsersexpenses; no need to maintain 2 lists since we can already have one list since we have expense type in userexpense


    // relationships
    /*
      Expense : UserExpense -> 1:M { uni-directional on expense side}
      Group : Expense -> 1:M { uni-directional on group side }
    */

    /*
    {
        "description": "Dinner",
            "amount": 1000,
            "group": 1,
            "currency": "INR",
            "userExpenses": [
                                {
                                 "name" : "Rituraj",
                                 "amount" : 500,
                                 "userExpenseType" : "paid"
                                 },
                                {
                                 "name" : "Omkar",
                                 "amount" : 500,
                                 "userExpenseType" : "paid"
                                 },
                                 {
                                 "name" : "A",
                                 "amount" : 250,
                                 "userExpenseType" : "hasToPay"

                                } ]
    }

     */
}
