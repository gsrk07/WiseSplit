package com.scaler.Splitwise.service;

import com.scaler.Splitwise.models.Group;
import com.scaler.Splitwise.models.User;
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

        groupRepository.save(group);


    }
}
