package org.gdzdev.spring.boccia.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchResponseDto {
    private Long id;
    private String playerOne;
    private String playerTwo;
    private LocalDate gameDate;
}
