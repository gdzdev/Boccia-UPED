package org.gdzdev.spring.boccia.service;

import lombok.RequiredArgsConstructor;
import org.gdzdev.spring.boccia.dto.MatchRequestDto;
import org.gdzdev.spring.boccia.dto.MatchResponseDto;
import org.gdzdev.spring.boccia.exception.ResourceNotFoundException;
import org.gdzdev.spring.boccia.model.Match;
import org.gdzdev.spring.boccia.model.User;
import org.gdzdev.spring.boccia.repository.MatchJpaRepository;
import org.gdzdev.spring.boccia.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {

    private final MatchJpaRepository matchRepository;
    private final UserJpaRepository userRepository;

    @Override
    public MatchResponseDto create(MatchRequestDto dto) {
        User playerOne = userRepository.findById(dto.getPlayerOneId())
                .orElseThrow(() -> new ResourceNotFoundException("Player One not found"));
        User playerTwo = userRepository.findById(dto.getPlayerTwoId())
                .orElseThrow(() -> new ResourceNotFoundException("Player Two not found"));

        Match match = Match.builder()
                .playerOne(playerOne)
                .playerTwo(playerTwo)
                .build();

        match = matchRepository.save(match);

        return toResponse(match);
    }

    @Override
    public List<MatchResponseDto> getAll() {
        return matchRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public MatchResponseDto getById(Long id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
        return toResponse(match);
    }

    private MatchResponseDto toResponse(Match match) {
        return MatchResponseDto.builder()
                .id(match.getId())
                .playerOne(match.getPlayerOne().getUsername())
                .playerTwo(match.getPlayerTwo().getUsername())
                .gameDate(match.getGameDate())
                .build();
    }
}
