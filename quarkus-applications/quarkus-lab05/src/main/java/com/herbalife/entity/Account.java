package com.herbalife.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "accounts")
public class Account extends PanacheEntityBase {
    @Id
    @Column(name = "account_number")
    private String accountNumber;

    @Column
    private String owner;

    @Column
    private int balance;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_number")
    private List<AccountTransaction> transactions;
}
