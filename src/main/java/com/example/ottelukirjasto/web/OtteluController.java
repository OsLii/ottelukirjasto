package com.example.ottelukirjasto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ottelukirjasto.model.Bout;
import com.example.ottelukirjasto.model.BoutRepository;
import com.example.ottelukirjasto.model.OrganizationRepository;

@Controller
public class OtteluController {

	@Autowired
	private BoutRepository brepository;

	@Autowired
	private OrganizationRepository orepository;

	// boutlist endpoint palauttaa boutlist.html
	@RequestMapping(value = "/boutlist")
	public String ottelulista(Model model) {
		model.addAttribute("bouts", brepository.findAll());
		return "boutlist";
	}

	// add endpoint palauttaa addbout.html
	@RequestMapping(value = "/add")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addBout(Model model) {
		model.addAttribute("bout", new Bout());
		model.addAttribute("organizations", orepository.findAll());
		return "addbout";
	}

	// save endpoint redirectaa boutlist endpointtiin
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Bout bout) {
		brepository.save(bout);
		return "redirect:boutlist";
	}

	// delete{id[} endpoint redirectaa boutlist endpointtiin
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteBout(@PathVariable("id") Long boutId, Model model) {
		brepository.deleteById(boutId);
		return "redirect:../boutlist";
	}

	// edit{id} endpoint palauttaa editbout.html
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editBout(@PathVariable("id") Long boutId, Model model) {
		model.addAttribute("bout", brepository.findById(boutId));
		model.addAttribute("organizations", orepository.findAll());
		return "editbout";
	}

	// bouts endpoints listaa kaikki ottelut JSON muodossa
	@RequestMapping(value = "/bouts", method = RequestMethod.GET)
	public @ResponseBody List<Bout> boutListRest() {
		return (List<Bout>) brepository.findAll();
	}

	// bouts/{id} endpoint listaa tietyn ottelun sen id:n perusteella
	@RequestMapping(value = "/bout/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Bout> findBoutRest(@PathVariable("id") Long boutId) {
		return brepository.findById(boutId);
	}

	// login endpoint palauttaa login.html
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
}
