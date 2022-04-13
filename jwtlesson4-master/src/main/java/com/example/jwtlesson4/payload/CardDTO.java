package com.example.jwtlesson4.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardDTO {
    @NotNull(message = "can not be null")
    private Integer senderCardId;

    @NotNull(message = "can not be null")
    private Integer receiverCardId;

    @NotNull(message = "can not be null")
    private Double amount;

    @NotNull(message = "can not be null")
    private Double commissionFee;
}
