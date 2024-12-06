package com.picpaysimplificado.service;


import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.repositories.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Setter
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount){
        if(sender.getUserType()== UserType.COMMON){
            throw new IllegalArgumentException("Usuário do tipo Lojista não está autorizado a realizar transação");
        }

        if(sender.getBalance().compareTo(amount)<0){
            throw new IllegalArgumentException("Saldo insuficiente");
        }

    }

    public User finUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(()->new IllegalArgumentException("Usuário não encontrado"));
    }
}
