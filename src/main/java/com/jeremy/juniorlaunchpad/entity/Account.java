package com.jeremy.juniorlaunchpad.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "L'email ne peut pas être vide")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Le mot de passe ne peut pas être vide")
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    /*@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private JuniorProfile juniorProfile;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private RecruiterProfile recruiterProfile;*/

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;


    @PrePersist
    // cette annotation indique à Hibernate que la méthode sera appelée avant que l'entité ne soit persistée dans la base de données
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

}
