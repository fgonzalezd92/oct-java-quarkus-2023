package com.herbalife.dto;

public record AccountTransactionDto(String accountNumber, String transactionType, int amount) {
}
