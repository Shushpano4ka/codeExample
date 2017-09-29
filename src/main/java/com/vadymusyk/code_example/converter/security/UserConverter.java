package com.vadymusyk.code_example.converter.security;

import com.vadymusyk.code_example.dto.security.UserDTO;
import com.vadymusyk.code_example.entity.secutity.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vadymusyk on 22.08.17.
 */
public class UserConverter {
    public static UserDTO toDTO(User user) {
        return UserDTO.builder()
                .name(user.getName())
                .email(user.getUsername())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .build();
    }

    public static UserDTO toDTOForAdmin(User user) {
        UserDTO userDTO = toDTO(user);
        userDTO.setActive(user.isActive());
        userDTO.setUserId(user.getId());
        userDTO.setAvatarUrl(user.getAvatarUrl());
        return userDTO;
    }

    public static List<UserDTO> toDTOList(List<User> collect) {
        return collect.stream()
                .map(UserConverter::toDTOForAdmin)
                .collect(Collectors.toList());
    }
}
