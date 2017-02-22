package br.com.bliss.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.bliss.entity.Customer;

@RepositoryRestResource(collectionResourceRel="customer",path="customers")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

	List<Customer> findAll();
	Customer findByName(@Param("name")String name);
}
