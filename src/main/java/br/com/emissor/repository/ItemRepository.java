package br.com.emissor.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.emissor.repository.entity.Item;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Integer> {

	List<Item> findAll();
	Item findByName(@Param("name") String name);
}
