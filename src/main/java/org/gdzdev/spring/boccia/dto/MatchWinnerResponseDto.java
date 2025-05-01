package org.gdzdev.spring.boccia.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchWinnerResponseDto {
    private Long id;
    private String matchInfo;
    private int playerOnePoints;
    private int playerTwoPoints;
    private String winner;
}
