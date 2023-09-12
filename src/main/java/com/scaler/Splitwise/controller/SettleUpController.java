package com.scaler.Splitwise.controller;

import com.scaler.Splitwise.dto.SettleUpResponseDTO;
import com.scaler.Splitwise.dto.TransactionDTO;
import com.scaler.Splitwise.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// We are creating API in the controller layer.
// If it is a normal controller we write the annotation as @Controller
// if it is a rest api controller, we use @RestController
@RestController
public class SettleUpController {

    @Autowired
    private InitService initService;
    @GetMapping("/initialise") // GET API CALL TO THE DOMAIN domain/hello.
    // response entity will return body if everything goes well.
    public ResponseEntity initialise() {

        initService.initialise();

//        TransactionDTO t1 = new TransactionDTO("Sriram","Syandan",100);
//        TransactionDTO t2 = new TransactionDTO("Gunni","Sriram",200);
//        List<TransactionDTO> transactionDTOList = List.of(t1,t2);
//        SettleUpResponseDTO settleUpResponseDTO = new SettleUpResponseDTO(transactionDTOList);
        //return ResponseEntity.ok("Hello World");
        return ResponseEntity.ok("Done");
    }


}
