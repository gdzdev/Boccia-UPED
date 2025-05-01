package org.gdzdev.spring.boccia.repository;

import org.gdzdev.spring.boccia.model.MatchWinner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchWinnerJpaRepository extends JpaRepository<MatchWinner, Long> {

    MatchWinner findByMatchId(Long matchId);
}
