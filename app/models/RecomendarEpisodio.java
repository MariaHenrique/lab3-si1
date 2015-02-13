package models;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class RecomendarEpisodio extends EstrategiaRecomendar {

	public RecomendarEpisodio(){

	}



	@Override
	public Episodio getProximoEpisodioAAssistir(int temporada, Serie serie) {

		List<Episodio> eps = serie.getEpisodios(temporada);		
		int size = eps.size();


		for (int i = 0; i < size; i++){	
			
			if (!eps.get(i).isAssistido()){	
				boolean quantAssistido = contaEpisodiosAssistidos(eps.subList(i+1, size));
				if (i == size - 1 || (i != size- 1 && !quantAssistido)){	
					return eps.get(i);					
				} 				
			}
		}		
		return null;
	}

	private boolean contaEpisodiosAssistidos(List<Episodio> episodiosAssistidos) {
		int assistido = 0;
		for (Episodio ep : episodiosAssistidos) {
			if (ep.isAssistido()){
				assistido++;				
			}
			if (assistido >= 3){

				return true;
			}
		}		
		return false;
	}
}










