package com.jeremy.juniorlaunchpad.service;

import com.jeremy.juniorlaunchpad.dto.AccountResponseDto;
import com.jeremy.juniorlaunchpad.dto.RegisterRequestDto;
import com.jeremy.juniorlaunchpad.entity.Account;
import com.jeremy.juniorlaunchpad.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor// pour générer un constructeur avec tous les champs finals (injection de dépendances)
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountResponseDto register(RegisterRequestDto request) {
        // vérifier si l'email existe déjà
        if (accountRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Cet email est déjà utilisé : " + request.getEmail());
        }

        // Conversion DTO -> Entité
        // mdp est stocké en clair temporairement.
        // ajout de BCryptPasswordEncoder dès la config de Spring Security.
        Account account = Account.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .build();

        // Sauvegarde en base via le Repository
        Account savedAccount = accountRepository.save(account);

        // Conversion Entité -> DTO de réponse
        return AccountResponseDto.builder()
                .id(savedAccount.getId())
                .email(savedAccount.getEmail())
                .role(savedAccount.getRole())
                .createdAt(savedAccount.getCreatedAt())
                .build();
    }
}