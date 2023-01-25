package ro.ucv.inf.ead.ropharma.service;

import java.util.List;

import ro.ucv.inf.ead.ropharma.model.Product;

public interface ProductService {
	public List<Product> findAllProducts();
	public void delete(Long productId);
	public Product add(Product product);
	public Product findProduct(long productid);
	public Product update(Product task);
}
