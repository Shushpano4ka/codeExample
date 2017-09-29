package com.vadymusyk.code_example.repository.security;

import com.vadymusyk.code_example.entity.secutity.PasswordRecovery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by vadymusyk on 14.08.17.
 */
public interface PasswordRecoveryRepository extends JpaRepository<PasswordRecovery, Long> {

    Optional<PasswordRecovery> findByToken(String token);
}
