package org.gdzdev.spring.boccia.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.gdzdev.spring.boccia.dto.MatchWinnerRequestDto;
import org.gdzdev.spring.boccia.dto.MatchWinnerResponseDto;
import org.gdzdev.spring.boccia.service.MatchWinnerService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
@RequiredArgsConstructor
public class MatchWinnerController {

    private final MatchWinnerService matchWinnerService;

    @PostMapping
    public ResponseEntity<MatchWinnerResponseDto> create(@Valid @RequestBody MatchWinnerRequestDto dto) {
        return new ResponseEntity<>(matchWinnerService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MatchWinnerResponseDto>> getAll() {
        return ResponseEntity.ok(matchWinnerService.getAll());
    }

    @GetMapping("/match/{matchId}")
    public ResponseEntity<MatchWinnerResponseDto> getByMatchId(@PathVariable Long matchId) {
        return ResponseEntity.ok(matchWinnerService.getByMatchId(matchId));
    }
}

