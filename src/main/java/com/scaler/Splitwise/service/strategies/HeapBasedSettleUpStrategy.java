package com.scaler.Splitwise.service.strategies;

import com.scaler.Splitwise.dto.TransactionDTO;
import com.scaler.Splitwise.models.Expense;
import com.scaler.Splitwise.models.User;
import com.scaler.Splitwise.models.UserExpense;
import com.scaler.Splitwise.models.UserExpenseType;

import java.util.*;

public class HeapBasedSettleUpStrategy implements SettleUpStrategy{

    @Override
    public List<TransactionDTO> settleUp(List<Expense> expenses) {

        HashMap<User,Double> userOutstandingMap = new HashMap<User, Double>(); // this is to store user and their outstanding amount

        for(Expense expense : expenses){
            for(UserExpense userExpense : expense.getUserExpenses()){
                User user = userExpense.getUser();
                double currentOutstandingAmount = userOutstandingMap.getOrDefault(user,0.00);
                userOutstandingMap.put(user,getUpdatedOutstandingAmount(currentOutstandingAmount,userExpense));
            }
        }

        // we now create the maxheap and minheap for the users.
        // maxheap for all PAID Users [+ve balance]
        // minheap for all HASTOPAY Users [-ve balance]

        PriorityQueue<Map.Entry<User,Double>> maxHeap = new PriorityQueue<>(
                (a,b) -> Double.compare(a.getValue(),b.getValue())
        );

        PriorityQueue<Map.Entry<User,Double>> minheap = new PriorityQueue<>(
                Comparator.comparingDouble(Map.Entry::getValue)
        );

        // now we iterate over our map and start adding values to respective heaps based on outstanding amount

        for(Map.Entry<User,Double> entry : userOutstandingMap.entrySet()){

            if(entry.getValue() < 0){
                minheap.add(entry);
            } else if (entry.getValue() > 0) {
                maxHeap.add(entry);
            }
            else {
                System.out.println(entry.getKey().getName() + " is already settled. No need to be part of transactions");
            }
        }


        // now we write up the settling logic // ultimately you need to draw values out of both heaps until total outstanding is 0

        while (!minheap.isEmpty()){

            Map.Entry<User,Double> maxHasToPay = minheap.poll();
            Map.Entry<User,Double> maxHasPaid = maxHeap.poll();

            double totaloutstanding = maxHasPaid.getValue() + maxHasToPay.getValue();

            if(totaloutstanding < 0){
                maxHasToPay.setValue(totaloutstanding);
                minheap.add(maxHasToPay);
            } else if (totaloutstanding > 0) {
                maxHasPaid.setValue(totaloutstanding);
                maxHeap.add(maxHasPaid);
            }
            else {
                System.out.println("Settled up with this transaction");
            }


        }

        return null;
    }
    private double getUpdatedOutstandingAmount(double currentOutStandingamount, UserExpense userexpense){

        if(userexpense.getUserExpenseType().equals(UserExpenseType.PAID)){
            currentOutStandingamount = currentOutStandingamount + userexpense.getAmount();
        }
        else {
            currentOutStandingamount = currentOutStandingamount - userexpense.getAmount();
        }

        return currentOutStandingamount;
    }

}

 /*
        1. Go through all the expenses and find the outstanding amount for each user
            a. Loop through each expense, and for each expense
            b. We will loop through all the userExpense
            If userExpense type is PAID, it will be added as +ve
            If userExpense type is HASTOPAY, it will be subtracted as -ve
            from each user
       2. All the users with negative balance [hasToPay] => minHeap
       3. All the users with positive balance [paid] => maxHeap
       4. We will find the transactions

  */