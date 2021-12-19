package com.example.proyecto.controller;

import com.example.proyecto.model.TempPresDTO;
import com.example.proyecto.repository.TempPresDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET})
@RequestMapping("/api")
public class TempPresController {

	@Autowired
	private TempPresDao repository;

	@PostMapping("/TempPres")
	public TempPresDTO create(@Validated @RequestBody TempPresDTO p) {
		return repository.insert(p);
	}

	@GetMapping("/TempPres")
	public List<TempPresDTO> readAll() {
		return repository.findAll();
	}

}
