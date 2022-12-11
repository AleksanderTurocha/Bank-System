package turocha.aleksander.banksystem.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    @OneToMany(mappedBy = "client")
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private List<Insurance> insurances = new ArrayList<>();

    public Client(Long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
