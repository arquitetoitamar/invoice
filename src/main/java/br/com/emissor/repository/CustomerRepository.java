package br.com.emissor.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.emissor.repository.entity.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

	Page<Customer> findAll(Pageable pageable);
	Customer findByName(@Param("name")String name);
	Customer findByInvoicesId(@Param("id") int id);
}
