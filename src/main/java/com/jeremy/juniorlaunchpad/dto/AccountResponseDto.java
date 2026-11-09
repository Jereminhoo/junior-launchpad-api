package com.jeremy.juniorlaunchpad.dto;

import com.jeremy.juniorlaunchpad.entity.Role;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//ce que l'API renvoie au client après l'inscription ou la connexion
public class AccountResponseDto {
    private Long id;
    private String email;
    private Role role;
    private LocalDateTime createdAt;
}
