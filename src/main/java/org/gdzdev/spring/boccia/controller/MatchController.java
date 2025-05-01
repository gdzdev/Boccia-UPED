package org.gdzdev.spring.boccia.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.gdzdev.spring.boccia.dto.MatchRequestDto;
import org.gdzdev.spring.boccia.dto.MatchResponseDto;
import org.gdzdev.spring.boccia.service.MatchService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @GetMapping
    public ResponseEntity<List<MatchResponseDto>> getAll() {
        return ResponseEntity.ok(matchService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(matchService.getById(id));
    }

    @PostMapping
    public ResponseEntity<MatchResponseDto> create(@Valid @RequestBody MatchRequestDto dto) {
        return new ResponseEntity<>(matchService.create(dto), HttpStatus.CREATED);
    }
}

