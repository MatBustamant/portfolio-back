package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Background;
import com.matbustamant.beportfolio.models.BackgroundType;
import java.util.List;

public interface BackgroundService {
	
         //método para traer todos los registros
         public List<Background> getBackgroundsByType(BackgroundType bgtype);

         //método para dar de alta un registro
         public Background saveBackground(Background bg);

         //método para borrar un registro
         public void deleteBackground(Integer id);

         //método para encontrar un registro
         public Background findBackgroundById(Integer id);

}
