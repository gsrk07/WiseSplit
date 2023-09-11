package com.scaler.Splitwise.service;

import com.scaler.Splitwise.models.User;
import com.scaler.Splitwise.repository.ExpenseRepository;
import com.scaler.Splitwise.repository.GroupRepository;
import com.scaler.Splitwise.repository.UserExpenseRepository;
import com.scaler.Splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    }
}
