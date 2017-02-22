package br.com.emissor.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.emissor.repository.entity.InvoiceItem;

@Repository
public interface InvoiceItemRepository extends PagingAndSortingRepository<InvoiceItem, Integer> {

	List<InvoiceItem> findByIdOrderId(@Param("id") int id);
}
