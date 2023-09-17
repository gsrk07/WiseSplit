package com.scaler.Splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
// @AllArgsConstructor commenting this out to create users with no arguments in initialise method.
@Entity(name = "SPLITWISE_USER")
@Builder // just to show that lombok also provides Builder object so we will directly use Builder annotation here.
public class User extends BaseModel{

    private String name;
    private String phno;
    private String emailid;

    // we comment this out since Having User detail in User expense makes more sense and this way we keep the mapping as Unidirectional.
//    @OneToMany
//    private List<UserExpense> userExpenseList;

    @ManyToMany
    private List<Group> groupList;

    /*
    User - Group : M:M -> Bidirectional
    User - UserExpense : 1:M -> Uni Directional

    in case of settleup algorithm, we need UserExpense from User.


    Expense
       paid : A=100, B=100    { we want to know how much each user has
       spent or has to spend, i.e. we want to know the amount and user from each userExpense object}
       hasToPay : A=50, B=50, C=100
 */

    /*
        1 user can have multiple expenses and 1 expense can have multiple users. hence many to many relation.
        1 user can be part of multiple groups and 1 group can have multiple users. hence many to many relation.
          1 expense will have number of userexpenses. from that userexpenses we need the user
     */

    /*

    Also, here we are not maintaining the expense of each user. i.e. how much expense is from each user.
    since it becomes a longer version of the code. we would instead want to have the settleup feature in group which will tell how much each user is legible to pay or receive.
     */
}
