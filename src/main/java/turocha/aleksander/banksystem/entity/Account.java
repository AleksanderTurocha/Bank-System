package turocha.aleksander.banksystem.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountName;
    private BigDecimal balance;
    private Currency currency;
    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

    @Enumerated(EnumType.STRING)
//    @Column(name = "account_type", columnDefinition = "enum", nullable = false)
    private AccountType accountType;
}
