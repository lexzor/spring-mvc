package ro.ucv.inf.ead.ropharma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import ro.ucv.inf.ead.ropharma.model.Product;


@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
	public Product findById(long productid);
}