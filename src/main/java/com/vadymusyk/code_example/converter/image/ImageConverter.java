package com.vadymusyk.code_example.converter.image;

import com.vadymusyk.code_example.dto.image.UsersAvatarDTO;
import com.vadymusyk.code_example.entity.image.UsersAvatar;

public class ImageConverter {
    public static UsersAvatarDTO toAvatarDTO(UsersAvatar usersAvatar) {
        return UsersAvatarDTO.builder()
                .url(usersAvatar.getUrl())
                .build();
    }
}
