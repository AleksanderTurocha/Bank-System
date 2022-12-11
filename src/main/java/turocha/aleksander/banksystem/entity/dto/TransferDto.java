package turocha.aleksander.banksystem.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferDto {
    private Long senderId;
    private Long receiverId;
    private BigDecimal amount;
}
