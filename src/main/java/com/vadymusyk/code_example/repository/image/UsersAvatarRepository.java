package com.vadymusyk.code_example.repository.image;

import com.vadymusyk.code_example.entity.image.UsersAvatar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersAvatarRepository extends JpaRepository<UsersAvatar, Long>{
    List<UsersAvatar> findByUserId(long userId);
}
