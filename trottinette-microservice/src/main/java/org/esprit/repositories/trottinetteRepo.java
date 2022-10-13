package org.esprit.repositories;

import org.esprit.entities.Trottinette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface trottinetteRepo extends JpaRepository<Trottinette, Long> {

	
}
