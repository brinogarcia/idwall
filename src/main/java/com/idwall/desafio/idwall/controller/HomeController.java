package com.idwall.desafio.idwall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.idwall.desafio.idwall.service.StringJustifiedService;
import com.idwall.desafio.idwall.service.StringService;

@RestController
@RequestMapping(value = "/string")
public class HomeController {
	@Autowired
	StringService stringService;
	
	@Autowired
	StringJustifiedService stringJustifiedService;
	
	@PostMapping(value = "/refactor")
	public ResponseEntity<Object> teste(@RequestParam(defaultValue = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n" + 
			"And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.") 
			String text,
			@RequestParam(defaultValue = "40") String limit  ) {
		if(Integer.parseInt(limit)<20) {
			return ResponseEntity.ok().body("o limit não pode ser menor que 20!");			
		}else {		
		String textoReturn = stringService.refactorString(text, Integer.parseInt(limit));
		
		return ResponseEntity.ok().body(textoReturn);
		}
	}
	
	
	@PostMapping(value="/refactor/justified")
	public ResponseEntity<Object> testejustified(
			@RequestParam(defaultValue = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n" + 
			"And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.") 
			String text,
			@RequestParam(defaultValue = "40") String limit ) 
		{
		if(Integer.parseInt(limit)<20) {
			return ResponseEntity.ok().body("o limit não pode ser menor que 20!");			
		}else {		
		String textoReturn = stringJustifiedService.refactorStringJustified(text, Integer.parseInt(limit));
		
		return ResponseEntity.ok().body(textoReturn);
		}
	}	
		
	
	
}
