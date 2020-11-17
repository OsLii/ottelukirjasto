package com.example.ottelukirjasto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ottelukirjasto.model.Bout;
import com.example.ottelukirjasto.model.BoutRepository;

@Controller
public class OtteluController {

	@Autowired
	private BoutRepository brepository;

	@RequestMapping(value = "/boutlist")
	public String ottelulista(Model model) {
		model.addAttribute("bouts", brepository.findAll());
		return "boutlist";
	}

	@RequestMapping(value = "/add")
	public String addBout(Model model) {
		model.addAttribute("bout", new Bout());
		return "addbout";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Bout bout) {
		brepository.save(bout);
		return "redirect:boutlist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBout(@PathVariable("id") Long boutId, Model model) {
		brepository.deleteById(boutId);
		return "redirect:../boutlist";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBout(@PathVariable("id") Long boutId, Model model) {
		model.addAttribute("bout", brepository.findById(boutId));
		return "editbout";
	}

	@RequestMapping(value = "/bouts", method = RequestMethod.GET)
	public @ResponseBody List<Bout> boutListRest() {
		return (List<Bout>) brepository.findAll();
	}

	@RequestMapping(value = "/bout/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Bout> findBoutRest(@PathVariable("id") Long boutId) {
		return brepository.findById(boutId);
	}
}
