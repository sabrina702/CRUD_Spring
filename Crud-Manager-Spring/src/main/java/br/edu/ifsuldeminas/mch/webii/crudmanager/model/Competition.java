package br.edu.ifsuldeminas.mch.webii.crudmanager.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "competitions")
public class Competition {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "O nome da Compeonato não pode ser vazio!")
	private String name_comp;
	
	@NotBlank(message = "A data do Campeonato não pode ser vazio!")
	private String date;
	
	@NotBlank(message = "O local Campeonato não pode ser vazio!")
	private String location;
	
	@NotBlank(message = "A modadlidade não pode ser vazio!")
	private String modality;
	
	@NotBlank(message = "A categoria não pode ser vazio!")
	private String category;
	
	public Competition() {}
	
	public Competition(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName_comp() {
		return name_comp;
	}

	public void setName_comp(String name_comp) {
		this.name_comp = name_comp;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
