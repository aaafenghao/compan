package com.example.demo.restful.dao;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.example.demo.restful.model.IndexModel;

import javafx.print.Collation;

@Repository
public class IndexDao {
	
	private ConcurrentHashMap<Long, IndexModel> repository = new ConcurrentHashMap<>();
	
	private final static AtomicLong idGen = new AtomicLong(0);
	
	public Long save(IndexModel model) {
		long id = idGen.incrementAndGet();
		model.setId(id);
		repository.put(id, model);
		return id;
	}
	
	public Collection<IndexModel> findAll() {
		return repository.values();
	}
	
	public IndexModel findModelById(Long id) {
		return repository.get(id);
	}
	
	public Long updateModel(IndexModel model) {
		repository.put(model.getId(), model);
		return model.getId();
	}
	
	public Long remove(Long id) {
		repository.remove(id);
		return id;
		
	}

}
