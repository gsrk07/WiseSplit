package com.scaler.Splitwise.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
@Entity(name = "SPLITWISE_EXPENSE")
public class Expense extends BaseModel{

    private String description;
    private double amount;

    @ManyToOne
    private Group group;
    @Enumerated(EnumType.ORDINAL)
    //@ElementCollection we dont need element collection here since one expense can only be in one currency. had it been in multiple currencies, then we need @ElementCollection
    private Currency currency;

    private HashMap<User,Double> paidUsers;
    private HashMap<User,Double> hastoPayUsers;

    /*
      Expense : UserExpense -> 1:M { uni-directional on expense side}
      Group : Expense -> 1:M { uni-directional on group side }
    */

}
