package turocha.aleksander.banksystem.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal totalWorth;
    private BigDecimal fee;

    @Enumerated(EnumType.STRING)
//    @Column(name = "insurance_type", columnDefinition = "enum", nullable = false)
    private InsuranceType insuranceType;

    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;
}
