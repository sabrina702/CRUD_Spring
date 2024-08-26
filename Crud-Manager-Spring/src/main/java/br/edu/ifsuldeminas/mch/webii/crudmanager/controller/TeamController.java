package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Competition;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Team;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.CompetitionRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.TeamRepository;
import jakarta.validation.Valid;

@Controller
public class TeamController {
	@Autowired
	private TeamRepository teamRepo;
	@Autowired
	private CompetitionRepository compRepo;
	
	@GetMapping("/teams")
	public String listTeams(Model model) {
		List<Team> teams = teamRepo.findAll();
		model.addAttribute("teams", teams);
		return "team";
	}
	
	@GetMapping("/teams/form")
	public String teamForm(@ModelAttribute("equipe") Team team, Model model) {
		List<Competition> competitions = compRepo.findAll(); // Recupere todas as competições
	    model.addAttribute("competitions", competitions);    // Adicione a lista de competições ao modelo
	    return "teams_form";
	}
	
	@PostMapping("/teams/register")
	public String teamNew(@Valid @ModelAttribute("equipe")  Team team, BindingResult erros, Model model) {
		 if (erros.hasErrors()) {
		        List<Competition> competitions = compRepo.findAll();
		        model.addAttribute("competitions", competitions);
		        return "teams_form";
		    }
		    teamRepo.save(team);
		    return "redirect:/teams";
	}
	
	@GetMapping("/teams/update/{id}")
	public String teamUpdate(@PathVariable("id")  Integer id, Model model) {
		Optional<Team> teamOpt = teamRepo.findById(id);
		Team team;
		
		List<Competition> competitions = compRepo.findAll(); // Recupere todas as competições
	    model.addAttribute("competitions", competitions);    // Adicione a lista de competições ao modelo
	    
		if (!teamOpt.isPresent()) {
			team = new Team();
		} else {
			team = teamOpt.get();
		}		
		
		model.addAttribute("equipe", team);
		return "teams_form";
	}
	
	@GetMapping("/teams/delete/{id}")
	public String teamDelete(@PathVariable("id") Integer id) {
		teamRepo.delete(new Team(id));
		
		return "redirect:/teams";
	}
	
}
