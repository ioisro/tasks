package com.talknotes.tasks.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class TaskController {
	@PostMapping("path")
	public ResponseEntity<String> createTask(@RequestBody String entity) {
		
		return ResponseEntity.ok().body("null");
	}
	
}
