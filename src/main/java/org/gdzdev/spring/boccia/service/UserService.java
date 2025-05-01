package org.gdzdev.spring.boccia.service;

import org.gdzdev.spring.boccia.dto.UserRequestDto;
import org.gdzdev.spring.boccia.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto create(UserRequestDto dto);

    List<UserResponseDto> getAll();

    UserResponseDto getById(Long id);

    void delete(Long id);
}
