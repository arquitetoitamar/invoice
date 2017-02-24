package br.com.emissor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.emissor.repository.entity.Invoice;

@Repository
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Integer> {

	List<Invoice> findByCompanyNameContainingIgnoreCase(@Param("name") String name);
	@Query(nativeQuery=true, value="select inv.* from invoice inv "
			+ " join company comp "
			+ " on inv.fk_cod_company = comp.id "
			+ " join invoice_item invit "
			+ " on invit.invoice_id = inv.id "
			+ " join item it "
			+ " on it.id = invit.item_id "
			+ " where comp.name like CONCAT('%',:companyName,'%') "
			+ " or it.name like CONCAT('%',:itemName,'%') ")
	List<Invoice> findByName(@Param("companyName") String companyName, @Param("itemName") String itemName);
	List<Invoice> findAll();
}
