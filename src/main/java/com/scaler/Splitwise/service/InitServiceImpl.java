package com.scaler.Splitwise.service;

import com.scaler.Splitwise.models.*;
import com.scaler.Splitwise.repository.ExpenseRepository;
import com.scaler.Splitwise.repository.GroupRepository;
import com.scaler.Splitwise.repository.UserExpenseRepository;
import com.scaler.Splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitServiceImpl implements InitService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired  // this is used basically to inject the object dependency implicitly
    private UserExpenseRepository userExpenseRepository;

    @Override
    public void initialise() {
        // let us first start creating users.

        User u1 = User.builder().name("Sriram")
                                .phno("12345678")
                                .emailid("sriram@email.com")
                                .build();

        User u2 = User.builder().name("Preetham")
                .phno("12345678")
                .emailid("preetham@email.com")
                .build();

        User u3 = User.builder().name("Divya")
                .phno("12345678")
                .emailid("Divya@email.com")
                .build();

        User u4 = User.builder().name("Vijay")
                .phno("12345678")
                .emailid("Vijay@email.com")
                .build();

       u1 = userRepository.save(u1);
       u2 = userRepository.save(u2);
       u3 = userRepository.save(u3);
       u4 = userRepository.save(u4);

        // post this save operation, users will get id's from db so we can use these id's to save in the group

        // now let us create groups.

        Group group = new Group();
        group.setDescription("Expenses to be paid");
        group.setName("Ladakh Bike Trip");
        group.setUserList(List.of(u1,u2,u3,u4));

        group = groupRepository.save(group);

        // scenario 1 is all 4 users go to dinner, ue1 pays 1000 and the amount is split across the group equally.

        UserExpense ue1 = new UserExpense();
        ue1.setUser(u1);
        ue1.setAmount(1000);
        ue1.setUserExpenseType(UserExpenseType.PAID);
        ue1 = userExpenseRepository.save(ue1);

        UserExpense ue2 = new UserExpense();
        ue2.setUser(u1);
        ue2.setAmount(250);
        ue2.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        ue2 = userExpenseRepository.save(ue2);

        UserExpense ue3 = new UserExpense();
        ue3.setUser(u2);
        ue3.setAmount(250);
        ue3.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        ue3 = userExpenseRepository.save(ue3);

        UserExpense ue4 = new UserExpense();
        ue4.setUser(u3);
        ue4.setAmount(250);
        ue4.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        ue4 = userExpenseRepository.save(ue4);

        UserExpense ue5 = new UserExpense();
        ue5.setUser(u4);
        ue5.setAmount(250);
        ue5.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        ue5 = userExpenseRepository.save(ue5);

        Expense expense = new Expense();
        expense.setAmount(1000);
        expense.setDescription("Dinner");
        expense.setCurrency(Currency.INR);
        expense.setUserExpenses(List.of(ue1,ue2,ue3,ue4,ue5));

        expenseRepository.save(expense);

    }
}
