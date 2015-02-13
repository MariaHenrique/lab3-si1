import static org.junit.Assert.*;
import models.RecomendarEpisodioMaisAntigo;
import models.Serie;

import org.junit.Before;
import org.junit.Test;

public class RecomendarEpisodioMaisAntigoTest {
	
private Serie serie;
	
	@Before
	public void setUp(){
		 serie = new Serie("2 Broke Girls");
	}
	
	@Test
	public void deveRetornarEpisodioMaisAntigoNaoAssistido(){
	
		serie.addEpisodio("Pilot", 1, 1);
		serie.addEpisodio("And the Break-up Scene", 2, 1);
		serie.addEpisodio("And Strokes of Goodwill", 3, 1);
		
		serie.setRecomendar(new RecomendarEpisodioMaisAntigo());
		
		serie.getEpisodios(1).get(2).mudaStatus();
		
		assertFalse(serie.getEpisodios(1).get(0).isAssistido());
		assertFalse(serie.getEpisodios(1).get(1).isAssistido());
		assertTrue(serie.getEpisodios(1).get(2).isAssistido());


		assertEquals(serie.getProximoEpisodio(1), serie.getEpisodios(1).get(0));
		
		serie.getEpisodios(1).get(0).mudaStatus();
		
		assertTrue(serie.getEpisodios(1).get(0).isAssistido());
		assertFalse(serie.getEpisodios(1).get(1).isAssistido());
		assertTrue(serie.getEpisodios(1).get(2).isAssistido());
		
		assertEquals(serie.getProximoEpisodio(1), serie.getEpisodios(1).get(1));
		
	}
}
