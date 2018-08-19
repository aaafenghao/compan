package com.example.demo.restful.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.restful.dao.IndexDao;
import com.example.demo.restful.model.IndexModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class IndexHandler {
	
	private final IndexDao index;
	
	@Autowired
	private IndexHandler(IndexDao index) {
		this.index=index;
	}
	
	public Mono<Long> save(IndexModel model){
		return Mono.create(indexMonoSink ->indexMonoSink.success(index.save(model)));
	}
	
	public Mono<IndexModel> findById(Long id){
		return Mono.justOrEmpty(index.findModelById(id));
	}
	
	public Flux<IndexModel> findAll(){
		return Flux.fromIterable(index.findAll());
	}
	
	public Mono<Long> modifty(IndexModel model){
		return Mono.create(indexMonoSink -> indexMonoSink.success(index.updateModel(model)));
	}
	
	public Mono<Long> delete(Long id){
		return Mono.create(indexMonoSink ->indexMonoSink.success(index.remove(id)));
	}

}
