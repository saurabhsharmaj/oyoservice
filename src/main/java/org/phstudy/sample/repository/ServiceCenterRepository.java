package org.phstudy.sample.repository;

import java.util.List;

import org.phstudy.sample.model.ServiceCenter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCenterRepository extends ElasticsearchCrudRepository<ServiceCenter, Long> {
	
	Page<ServiceCenter> findByCityAllIgnoreCase(String city, Pageable pageable);
	
	Page<ServiceCenter> findByState(String state,Pageable pageable);	
	
	@Query("{\"bool\" : {\"should\" : ["
			+ "{\"term\" : {\"city\" : \"?0\"}}"
			+ ",{\"term\" : {\"state\" : \"?0\"}}"
			+ ",{\"term\" : {\"name\" : \"?0\"}"
			+ "}]}}")
	List<ServiceCenter> find(String query);
	
	@Query("{\"bool\" : {\"must\" : {\"term\" : {\"city\" : \"?0\"}}}}")
	Page<ServiceCenter> findByCityLike(String message, Pageable pageable);
}