package com.diocesisdecarupano.sgp.modules.auth.application.mapper;

import org.modelmapper.ModelMapper;

import com.diocesisdecarupano.sgp.modules.auth.application.dto.RegisterRequestDTO;
import com.diocesisdecarupano.sgp.modules.user.domain.enums.StateUser;
import com.diocesisdecarupano.sgp.modules.user.domain.enums.TypeUser;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;

public class AuthMapper {
    public static User toEntity(RegisterRequestDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(dto, User.class);
        user.setState(StateUser.INACTIVE.getCode());
        user.setType(TypeUser.REQUESTED.getCode());
        return user;
    }
}