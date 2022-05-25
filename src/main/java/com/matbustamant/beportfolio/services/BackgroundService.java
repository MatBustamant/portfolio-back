package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Background;
import com.matbustamant.beportfolio.models.BackgroundType;
import java.util.List;

public interface BackgroundService {
	
         public List<Background> getBackgroundsByType(BackgroundType bgtype);

         public Background saveBackground(Background bg);

         public void deleteBackground(Integer id);

         public Background findBackgroundById(Integer id);

}
