package com.scaler.Splitwise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data // @Data is a convenient shortcut annotation that bundles the
// features of @ToString , @EqualsAndHashCode , @Getter / @Setter and @RequiredArgsConstructor together
@AllArgsConstructor
public class SettleUpResponseDTO {

    private List<TransactionDTO> transactionDTOList;
}
