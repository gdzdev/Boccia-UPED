package org.gdzdev.spring.boccia.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchRequestDto {

    @NotNull(message = "Player One ID is required")
    private Long playerOneId;

    @NotNull(message = "Player Two ID is required")
    private Long playerTwoId;
}
