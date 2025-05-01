package org.gdzdev.spring.boccia.service;

import org.gdzdev.spring.boccia.dto.MatchWinnerRequestDto;
import org.gdzdev.spring.boccia.dto.MatchWinnerResponseDto;

import java.util.List;

public interface MatchWinnerService {

    MatchWinnerResponseDto create(MatchWinnerRequestDto dto);

    List<MatchWinnerResponseDto> getAll();

    MatchWinnerResponseDto getByMatchId(Long matchId);
}
