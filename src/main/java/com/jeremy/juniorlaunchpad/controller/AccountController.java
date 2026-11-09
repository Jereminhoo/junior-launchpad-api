package com.jeremy.juniorlaunchpad.controller;

import com.jeremy.juniorlaunchpad.dto.AccountResponseDto;
import com.jeremy.juniorlaunchpad.dto.RegisterRequestDto;
import com.jeremy.juniorlaunchpad.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // pour indiquer que c'est un contrôleur REST et renvoyer des réponses JSON
@RequestMapping("/api/accounts") // pour définir le chemin de base de toutes les routes de ce contrôleur
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    // Route pour enregistrer un nouvel utilisateur
    @PostMapping("/register")
    //ResponseEntity est une classe qui permet de renvoyer une réponse HTTP avec un code de statut et un corps de réponse
    //RequestBody permet de lier le corps de la requête HTTP à un objet Java
    public ResponseEntity<AccountResponseDto> register(@Valid @RequestBody RegisterRequestDto request) {
        AccountResponseDto response = accountService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}