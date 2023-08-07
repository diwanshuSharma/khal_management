package com.management.khal_management.dtos.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDto {

    private Long customer_id;
    private List<ItemQuantityRequestDto> items;
    private Double moneyProvided;
}
