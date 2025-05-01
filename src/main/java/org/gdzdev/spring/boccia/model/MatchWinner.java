package org.gdzdev.spring.boccia.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "matches_winner")
public class MatchWinner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "match_id", unique = true)
    private Match match;

    @Column(name = "player_one_points")
    private Integer playerOnePoints;

    @Column(name = "player_two_points")
    private Integer playerTwoPoints;

    @Column(nullable = false)
    private String winner;
}

