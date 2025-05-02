package org.gdzdev.spring.boccia.service;

import lombok.RequiredArgsConstructor;
import org.gdzdev.spring.boccia.dto.UserRequestDto;
import org.gdzdev.spring.boccia.dto.UserResponseDto;
import org.gdzdev.spring.boccia.exception.ResourceNotFoundException;
import org.gdzdev.spring.boccia.model.User;
import org.gdzdev.spring.boccia.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserJpaRepository userRepository;

    @Override
    public UserResponseDto create(UserRequestDto dto) {
        User user = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();

        user = userRepository.save(user);
        return toResponse(user);
    }

    @Override
    public List<UserResponseDto> getAll() {
        return userRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public UserResponseDto getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        return toResponse(user);
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id))
            throw new ResourceNotFoundException("User not found");
        userRepository.deleteById(id);
    }

    private UserResponseDto toResponse(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}

