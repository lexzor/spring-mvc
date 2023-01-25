package ro.ucv.inf.ead.ropharma.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.inf.ead.ropharma.exception.RecordNotFoundException;
import ro.ucv.inf.ead.ropharma.model.Product;
import ro.ucv.inf.ead.ropharma.repository.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> findAllProducts() {
	    return productRepository.findAll();
	}
	
	@Override
	@Transactional
	public void delete(Long productId) {
		Product product = productRepository.findById(productId).orElse(null);
		logger.debug("Deleting product with id: " + productId);
		
		if(product != null) {
			productRepository.deleteById(productId);
		} else {
			String errorMessage = "Product with id " + productId + " not found";
			logger.error(errorMessage);
			throw new RecordNotFoundException(errorMessage);
		}
	}

	@Override
	@Transactional
	public Product add(Product product) {
	productRepository.save(product);
		return product;
	}
	
	@Override
	@Transactional
	public Product findProduct(long productid) {
		return productRepository.findById(productid);
	}
	
	@Override
	@Transactional
	public Product update(Product product) {

		Product existingTask = productRepository.findById(product.getId()).orElse(null);
		
		if (existingTask == null) {
		String errorMessage = "Product with id " + product.getId() + " not found";
			logger.error(errorMessage);
		    throw new RecordNotFoundException(errorMessage);
	    }
		return productRepository.save(product);
	}
}
