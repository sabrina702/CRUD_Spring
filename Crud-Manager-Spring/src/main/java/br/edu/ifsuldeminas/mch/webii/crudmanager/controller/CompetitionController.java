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
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.CompetitionRepository;
import jakarta.validation.Valid;

@Controller
public class CompetitionController {
	@Autowired
	private CompetitionRepository CompRepo;

	@GetMapping("/competitions")
	public String listComp(Model model) {
		List<Competition> competitions = CompRepo.findAll();
		
		model.addAttribute("competicoes", competitions);
		
		return "competition";
	}
	
	@GetMapping("/competitions/form")
	public String compForm(@ModelAttribute("competicao") Competition competition) {
		return "competitions_form";
	}
	
	@PostMapping("/competitions/register")
	public String compNew(@Valid @ModelAttribute("competicao") Competition competition, BindingResult erros) {
		if (erros.hasErrors()) {
			return "competitions_form";
		}
		
		CompRepo.save(competition);
		return "redirect:/competitions";
	}
	
	@GetMapping("/competitions/update/{id}")
	public String compUpdate(@PathVariable("id") Integer id, Model model) {
		Optional<Competition> compOpt = CompRepo.findById(id);
		Competition competition;
		
		if (!compOpt.isPresent()) {
			competition = new Competition();
		} else {
			competition = compOpt.get();
		}		
		
		model.addAttribute("competicao", competition);
		return "competitions_form";
	}
	
	@GetMapping("/competitions/delete/{id}")
	public String compDelete(@PathVariable("id") Integer id) {
		CompRepo.delete(new Competition(id));
		return "redirect:/competitions";
	}
}
