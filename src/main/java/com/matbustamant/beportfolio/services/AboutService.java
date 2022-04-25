package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.About;
import java.util.List;

public interface AboutService {
	
         //método para traer todos los registros
         public List<About> getAbout ();

         //método para dar de alta un registro
         public About saveAbout(About about);

         //método para borrar un registro
         public void deleteAbout(Integer id);

         //método para encontrar un registro
         public About findAboutById(Integer id);

}
