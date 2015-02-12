package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class EstrategiaRecomendar {
	
	@Id @GeneratedValue
	private Long id;
	
	public EstrategiaRecomendar() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public abstract Episodio getProximoEpisodioAAssistir(int temporada, Serie serie);

}
