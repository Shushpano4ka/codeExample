package com.vadymusyk.code_example.repository.security;

import com.vadymusyk.code_example.entity.secutity.Role;
import com.vadymusyk.code_example.entity.secutity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by vadymusyk on 11.08.17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    List<User> findByRole(Role role);

    Optional<User> findByIdAndRole(long id, Role role);
}
