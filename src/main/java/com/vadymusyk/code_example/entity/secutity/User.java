package com.vadymusyk.code_example.entity.secutity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Created by vadymusyk on 08.02.17.
 */

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "\"user\"")
@ToString
public class User implements UserDetails {

    @Id
    @GeneratedValue(generator = "kaugen")
    @GenericGenerator(name = "kaugen", strategy = "increment")
    private long id;

    @NotNull
    @Column(name = "login")
    private String username;

    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull @NotEmpty
    private String password;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private boolean active;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "activation_code")
    private String activationCode;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(role.toString());
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

}
