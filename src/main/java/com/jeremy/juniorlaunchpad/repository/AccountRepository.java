package com.jeremy.juniorlaunchpad.repository;

import com.jeremy.juniorlaunchpad.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    //JPA regarde le nom des methodes et génère automatiquement les requêtes
    // SQL correspondantes pour interagir avec la base de données.

    boolean existsByEmail(String email);

    //Optional, au cas ou l'email n'existe pas, on ne veut pas avoir une exception mais juste un Optional vide
    Optional<Account> findByEmail(String email);

}


