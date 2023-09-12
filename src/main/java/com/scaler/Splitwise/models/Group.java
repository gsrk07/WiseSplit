package com.scaler.Splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
//@AllArgsConstructor
@Entity(name = "SPLITWISE_GROUP")
public class Group extends BaseModel{

    private String name;
    private String description;
    @ManyToMany
    private List<User> userList;
    @OneToMany
    private List<Expense> expenseList;
    private double totalAmountSpend;
}
