package br.com.emissor.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.emissor.repository.entity.Invoice;

@Repository
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Integer> {

	Page<Invoice> findByCompanyName(@Param("name") String name, Pageable pageable);
}
