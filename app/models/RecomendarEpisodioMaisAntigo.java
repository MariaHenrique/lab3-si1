package models;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class RecomendarEpisodioMaisAntigo extends EstrategiaRecomendar {

	public RecomendarEpisodioMaisAntigo() {
		
	}

	@Override
	public Episodio getProximoEpisodioAAssistir(int temporada, Serie serie) {
		List<Episodio> eps = serie.getEpisodios(temporada);

		for (Episodio ep : eps) {
			if (!ep.isAssistido()){
				return ep;
			}
		}
		return null;

	}




}
