package br.com.emissor.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.emissor.repository.entity.Invoice;

@Repository
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Integer> {

	List<Invoice> findByCompanyName(@Param("name") String name);
	List<Invoice> findAll();
}
