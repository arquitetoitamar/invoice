package br.com.emissor.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.emissor.repository.entity.InvoiceItem;

@Repository
public interface InvoiceItemRepository extends PagingAndSortingRepository<InvoiceItem, Integer> {

}
