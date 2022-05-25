package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.About;
import java.util.List;

public interface AboutService {
	
         public List<About> getAbout ();

         public About saveAbout(About about);

         public void deleteAbout(Integer id);

         public About findAboutById(Integer id);

}
