package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer>{
    
    @Query("SELECT pt FROM ProductType pt")
    List<ProductType> findAllProductTypes() throws DataAccessException;

    @Query("SELECT pt FROM ProductType pt WHERE pt.name = ?1")
    ProductType getProductType(String name) throws DataAccessException;

    @Query("SELECT p FROM Product p WHERE p.price < ?1")    
    List<Product> findByPriceLessThan(double price) throws DataAccessException;
    

    List<Product> findAll();
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
}
