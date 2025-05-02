package org.gdzdev.spring.boccia.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchWinnerRequestDto {

    @NotNull(message = "Match ID is required")
    private Long matchId;

    @Min(value = 0)
    private int playerOnePoints;

    @Min(value = 0)
    private int playerTwoPoints;
}

