package com.scaler.Splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Entity(name = "SPLITWISE_USER")
public class User extends BaseModel{

    private String name;
    private String phno;
    private String emailid;

    @ManyToMany
    private List<Expense> expenseList;
    @ManyToMany
    private List<Group> groupList;


    /*
        1 user can have multiple expenses and 1 expense can have multiple users. hence many to many relation.
        1 user can be part of multiple groups and 1 group can have multiple users. hence many to many relation.

     */

    /*

    Also, here we are not maintaining the expense of each user. i.e. how much expense is from each user.
    since it becomes a longer version of the code. we would instead want to have the settleup feature in group which will tell how much each user is legible to pay or receive.
     */
}
