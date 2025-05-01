package org.gdzdev.spring.boccia.model;

import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_one")
    private User playerOne;

    @ManyToOne
    @JoinColumn(name = "player_two")
    private User playerTwo;

    @CreationTimestamp
    @Column(name = "game_date")
    private LocalDate gameDate;
}

