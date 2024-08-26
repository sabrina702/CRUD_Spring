package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "teams")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "Nome do Equipe é obrigatório.")
	private String name_team;
	
	@NotNull(message = "Nome do Treinador é obrigatório.")
	private String trainer;
	
	@NotNull(message = "Quantidade de atletas é obrigatório.")
	@Digits(fraction = 0, integer = 100, message = "Número inválido.")
	private Integer quant_athletes;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "competition_id", nullable = false)  
	@NotNull(message = "Selecione uma competição.") 
	@Valid
	private Competition competition;
	
	public Team() {}
	
	public Team(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName_team() {
		return name_team;
	}

	public void setName_team(String name_team) {
		this.name_team = name_team;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public Integer getQuant_athletes() {
		return quant_athletes;
	}

	public void setQuant_athletes(Integer quant_athletes) {
		this.quant_athletes = quant_athletes;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	
}
