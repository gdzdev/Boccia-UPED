package org.gdzdev.spring.boccia.repository;

import org.gdzdev.spring.boccia.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchJpaRepository extends JpaRepository<Match, Long> {
}
