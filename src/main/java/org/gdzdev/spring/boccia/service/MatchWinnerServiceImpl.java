package org.gdzdev.spring.boccia.service;

import lombok.RequiredArgsConstructor;
import org.gdzdev.spring.boccia.dto.MatchWinnerRequestDto;
import org.gdzdev.spring.boccia.dto.MatchWinnerResponseDto;
import org.gdzdev.spring.boccia.exception.ResourceNotFoundException;
import org.gdzdev.spring.boccia.model.Match;
import org.gdzdev.spring.boccia.model.MatchWinner;
import org.gdzdev.spring.boccia.repository.MatchJpaRepository;
import org.gdzdev.spring.boccia.repository.MatchWinnerJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchWinnerServiceImpl implements MatchWinnerService {

    private final MatchWinnerJpaRepository matchWinnerRepository;
    private final MatchJpaRepository matchRepository;

    @Override
    public MatchWinnerResponseDto create(MatchWinnerRequestDto dto) {
        Match match = matchRepository.findById(dto.getMatchId())
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));

        if (matchWinnerRepository.findByMatchId(dto.getMatchId()) != null) {
            throw new IllegalStateException("Result already exists for this match");
        }

        String winner;
        if (dto.getPlayerOnePoints() > dto.getPlayerTwoPoints()) {
            winner = match.getPlayerOne().getUsername();
        } else if (dto.getPlayerTwoPoints() > dto.getPlayerOnePoints()) {
            winner = match.getPlayerTwo().getUsername();
        } else {
            winner = "Draw";
        }

        MatchWinner result = MatchWinner.builder()
                .match(match)
                .playerOnePoints(dto.getPlayerOnePoints())
                .playerTwoPoints(dto.getPlayerTwoPoints())
                .winner(winner)
                .build();

        result = matchWinnerRepository.save(result);

        return toResponse(result);
    }


    @Override
    public List<MatchWinnerResponseDto> getAll() {
        return matchWinnerRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public MatchWinnerResponseDto getByMatchId(Long matchId) {
        MatchWinner winner = matchWinnerRepository.findByMatchId(matchId);
        return toResponse(winner);
    }

    private MatchWinnerResponseDto toResponse(MatchWinner matchWinner) {
        return MatchWinnerResponseDto.builder()
                .id(matchWinner.getId())
                .matchInfo("Match #" + matchWinner.getMatch().getId())
                .playerOnePoints(matchWinner.getPlayerOnePoints())
                .playerTwoPoints(matchWinner.getPlayerTwoPoints())
                .winner(matchWinner.getWinner())
                .build();
    }
}
