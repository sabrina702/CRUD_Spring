package br.edu.ifsuldeminas.mch.webii.crudmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Competition;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Integer>{

}
