package org.gdzdev.spring.boccia.service;

import org.gdzdev.spring.boccia.dto.MatchRequestDto;
import org.gdzdev.spring.boccia.dto.MatchResponseDto;

import java.util.List;

public interface MatchService {

    MatchResponseDto create(MatchRequestDto dto);

    List<MatchResponseDto> getAll();

    MatchResponseDto getById(Long id);
}
