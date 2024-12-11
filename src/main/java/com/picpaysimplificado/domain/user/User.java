package com.picpaysimplificado.domain.user;

import com.picpaysimplificado.domain.user.UserType;

import com.picpaysimplificado.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table (name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String FirstName;

    private String Lastname;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO data){
        this.FirstName = data.firstName();
        this.Lastname = data.lastName();
        this.balance =data.balance();
        this.userType = data.usertype();
        this.password = data.password();
        this.email = data.email();

    }




}