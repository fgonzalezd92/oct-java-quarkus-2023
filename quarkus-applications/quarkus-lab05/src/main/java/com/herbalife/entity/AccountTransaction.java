package com.herbalife.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "account-transactions")
public class AccountTransaction extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column
    private int amount;

    @Column(name = "transaction_type")
    private String transactionType;

}
