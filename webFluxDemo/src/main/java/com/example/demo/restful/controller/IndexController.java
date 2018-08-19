package com.example.demo.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.restful.handler.IndexHandler;
import com.example.demo.restful.model.IndexModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="index")
public class IndexController {
	
	@Autowired
	public IndexHandler index;
	
	@GetMapping(value="/{id}")
	public Mono<IndexModel> findModelById(@PathVariable("id")Long id) {
		return index.findById(id);
	}
	
	@GetMapping()
	public Flux<IndexModel> findAll(){
		return index.findAll();
	}
	
	@PostMapping()
	public Mono<Long> save(@RequestBody IndexModel model){
		return index.save(model);
	}
	
	@PutMapping()
	public Mono<Long> modifty(@RequestBody IndexModel model){
		return index.modifty(model);
	}
	
	@DeleteMapping(value="/{id}")
	public Mono<Long> delete(@PathVariable("id")Long id){
		return index.delete(id);
	}

}
