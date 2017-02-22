package br.com.emissor.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.emissor.repository.entity.Company;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Integer> {

	Page<Company> findAll(Pageable pageable);
	Company findByName(@Param("name") String name);
}
