package models;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class RecomendarEpisodio extends EstrategiaRecomendar {


	public RecomendarEpisodio(){

	}

	@Override
	public Episodio getProximoEpisodioAAssistir(int temporada, Serie contexto) {
		List<Episodio> eps = contexto.getEpisodios(temporada);		
		int size = eps.size( );
		int cont = 0;

		for (int i = 0; i < size; i++) {			
			if (!eps.get(i).isAssistido()){		
				int j = i+1;
				while (eps.get(j).isAssistido()){
					cont++;
					j++;
				}
				if (cont >= 3 &&  (i + cont + 1) <= size - 1){
					return eps.get(i + cont + 1);
				}

			}	
		
		}
		return null;
	}

}