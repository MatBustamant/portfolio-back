package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Background;
import java.util.List;

public interface BackgroundService {
	
         public List<Background> getBackgroundsByType(Short id);
	
         public Background saveBackground(Background bg);

         public boolean deleteBackground(Integer id);

         public Background findBackgroundById(Integer id);

}
