package com.matbustamant.beportfolio.repositories;

import com.matbustamant.beportfolio.models.Background;
import com.matbustamant.beportfolio.models.BackgroundType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackgroundRepository extends JpaRepository<Background, Integer> {
	
	public List<Background> findAllByLinkedType(BackgroundType bgtype); //quizá ande mal, probar luego

}
