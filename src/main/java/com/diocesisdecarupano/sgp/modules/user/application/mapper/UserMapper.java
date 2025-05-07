package com.diocesisdecarupano.sgp.modules.user.application.mapper;

import org.modelmapper.ModelMapper;

import com.diocesisdecarupano.sgp.modules.user.application.dto.UserRequestDTO;
import com.diocesisdecarupano.sgp.modules.user.application.dto.UserResponseDTO;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(dto, User.class);
        return user;
    }

    public static UserResponseDTO toDTO(User entity) {
        ModelMapper modelMapper = new ModelMapper();
        UserResponseDTO userDto = modelMapper.map(entity, UserResponseDTO.class);
        return userDto;
    }
}
