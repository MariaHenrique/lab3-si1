import static org.junit.Assert.*;
import models.RecomendarDepoisDeTresSeguidos;
import models.Serie;

import org.junit.Before;
import org.junit.Test;

public class RecomendarDepoisDeTresSeguidosTest {
	
	
private Serie serie;
	
	@Before
	public void setUp(){
		 serie = new Serie("2 Broke Girls");
	}
	
	@Test
	public void deveRetornarEpisodioCerto(){
	
		serie.addEpisodio("Pilot", 1, 1);
		serie.addEpisodio("And the Break-up Scene", 2, 1);
		serie.addEpisodio("And Strokes of Goodwill", 3, 1);
		serie.addEpisodio("And the Rich People Problems", 4, 1);
		serie.addEpisodio("And the '90s Horse Party",5, 1);
		serie.addEpisodio("And the Disappearing Bed",6, 1);
		
		serie.setRecomendar(new RecomendarDepoisDeTresSeguidos());

				
		serie.getEpisodios(1).get(1).mudaStatus();
		
		assertFalse(serie.getEpisodios(1).get(0).isAssistido());
		assertTrue(serie.getEpisodios(1).get(1).isAssistido());
		assertFalse(serie.getEpisodios(1).get(2).isAssistido());
		assertFalse(serie.getEpisodios(1).get(3).isAssistido());
		assertFalse(serie.getEpisodios(1).get(4).isAssistido());
		assertFalse(serie.getEpisodios(1).get(5).isAssistido());
		

		assertEquals(serie.getProximoEpisodio(1), serie.getEpisodios(1).get(0));

		serie.getEpisodios(1).get(2).mudaStatus();
		serie.getEpisodios(1).get(3).mudaStatus();

		assertFalse(serie.getEpisodios(1).get(0).isAssistido());
		assertTrue(serie.getEpisodios(1).get(1).isAssistido());
		assertTrue(serie.getEpisodios(1).get(2).isAssistido());
		assertTrue(serie.getEpisodios(1).get(3).isAssistido());
		assertFalse(serie.getEpisodios(1).get(4).isAssistido());
		assertFalse(serie.getEpisodios(1).get(5).isAssistido());

		assertEquals(serie.getProximoEpisodio(1), serie.getEpisodios(1).get(4));

	}

}
