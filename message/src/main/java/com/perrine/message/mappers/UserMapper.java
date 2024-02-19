package com.perrine.message.mappers;

import com.perrine.message.dto.UserDTO;
import com.perrine.message.models.User;

public class UserMapper {
    public static UserDTO mapUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }
}
