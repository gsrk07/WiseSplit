package com.scaler.Splitwise.service;

import com.scaler.Splitwise.dto.TransactionDTO;

import java.util.List;

public interface GroupService {

    List<TransactionDTO> settleUp();

}
