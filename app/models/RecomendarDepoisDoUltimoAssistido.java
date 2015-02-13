package models;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class RecomendarDepoisDoUltimoAssistido extends EstrategiaRecomendar {
	
	public RecomendarDepoisDoUltimoAssistido() {
		
	}
	
	@Override
	public Episodio getProximoEpisodioAAssistir(int temporada, Serie serie) {
		List<Episodio> eps = serie.getEpisodios(temporada);
		int i = 0;
		int index = -1;
		while (i < eps.size()) {
			if(eps.get(i).isAssistido()) {
				index = i;
			}
			i++;
		}
		if(index == i-1) {
			return null;
		}
		if(index == -1) {
			return eps.get(0);
		}
		return eps.get(index+1);	
	}

}
