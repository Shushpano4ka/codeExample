package com.vadymusyk.code_example.repository.security;


import com.vadymusyk.code_example.entity.secutity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by vadymusyk on 26.04.17.
 */
public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByUserIdAndToken(long userId, String token);

    Token findByToken(String token);

    List<Token> findByUserId(long userId);
}
