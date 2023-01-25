package ro.ucv.inf.ead.ropharma.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ro.ucv.inf.ead.ropharma.dto.ProductDTO;
import ro.ucv.inf.ead.ropharma.dto.TypeDTO;
import ro.ucv.inf.ead.ropharma.model.Product;
import ro.ucv.inf.ead.ropharma.model.Type;
import ro.ucv.inf.ead.ropharma.service.ProductService;
import ro.ucv.inf.ead.ropharma.service.TypeService;

@Controller
public class GeneralController {
	private final Logger logger = LoggerFactory.getLogger(GeneralController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private TypeService typeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String getProducts(Model model) {
		List<Product> products = productService.findAllProducts();
		model.addAttribute("products", products);
		
		List<Type> productTypes = typeService.findAllTypes();
		model.addAttribute("product_types", productTypes);
		
		return "products";
	}
	
	@RequestMapping(value = "/products/add_product", method = RequestMethod.GET)
	public String addProductForm(Model model) {
		
		ProductDTO productModel = new ProductDTO();
		model.addAttribute("product", productModel);
		
		List<Type> productTypes = typeService.findAllTypes();
		model.addAttribute("product_types", productTypes);
		return "products_add";
	}
	
	@RequestMapping(value = "/products/add_category", method = RequestMethod.GET)
	public String addCategoryForm(Model model) {
		
		TypeDTO typeModel = new TypeDTO();
		model.addAttribute("type", typeModel);
		
		return "categories_add";
	}
	
	@RequestMapping(value = "/products/add_product", method = RequestMethod.POST)
	  public String addProduct(@Valid @ModelAttribute("product") ProductDTO productDTO, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
	      logger.error("Add task error: " + result.getAllErrors());
	      List<Type> product_types = typeService.findAllTypes();
	      model.addAttribute("product_types", product_types);
	      return "products_add";
	    }
		else
	    {
	      Product product = new Product();
	      
	      boolean error = false;
	      
	      if(productDTO.getPrice() < 1)
	      {
	    	  error = true;
	    	  redirectAttributes.addFlashAttribute("errorPrice", "Price can't be lower than 1!");
	      }
	      
	      if(productDTO.getQuantity() < 1)
	      {
	    	  error = true;
	    	  redirectAttributes.addFlashAttribute("errorQuantity", "Quantity can't be lower than 1!");
	      }
	      
	      if(error == true)
	      {
	    	  return "redirect:/products/add_product";
	      }
	      
	      product.setName(productDTO.getName());
	      product.setType(new Type(productDTO.getTypeid()));
	      product.setDescription(productDTO.getDescription());
	      product.setPrice(productDTO.getPrice());
	      product.setQuantity(productDTO.getQuantity());
	      productService.add(product);
	      redirectAttributes.addFlashAttribute("message", "Product successfully added");
	      return "redirect:/products";
	    }
	  }
	
	@RequestMapping(value = "/products/add_category", method = RequestMethod.POST)
	  public String addCategory(@Valid @ModelAttribute("type") TypeDTO typeDTO, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
	      logger.error("Add category error: " + result.getAllErrors());
	      return "category_add";
	    }
		else
	    {
	      Type type = new Type();
	      
	      type.setName(typeDTO.getName());
	      type.setDescription(typeDTO.getDescription());
	      typeService.add(type);
	      redirectAttributes.addFlashAttribute("message", "Category successfully added");
	      return "redirect:/products";
	    }
	  }
	
	@RequestMapping(value = "/product/update_type", method = RequestMethod.GET)
	  public String getEditTaskForm(@RequestParam(value = "id", required = true) Long id,
	      Model model,  RedirectAttributes redirectAttributes) {
	    Type type = typeService.findType(id);
	    if (type != null) {
	      logger.debug("Edit category {}", type);

	      TypeDTO typeDTO = new TypeDTO();
	      typeDTO.setId(type.getId());
	      typeDTO.setName(type.getName());
	      typeDTO.setDescription(type.getDescription());
	     
	      model.addAttribute("type", typeDTO);
	      
	      return "categories_update";
	    } else {
	      logger.error("Edit error: Category with id {} not found", id);
	      return "redirect:/products";
	    }
	    
	  }
	
	@RequestMapping(value = "/product/update_type", method = RequestMethod.POST)
	public String editType(@Valid @ModelAttribute("type") TypeDTO typeDTO, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
	      logger.error("Add product error: " + result.getAllErrors());
	      return "redirect:/products";
	    }
		else
	    {
	      Type type = typeService.findType(typeDTO.getId());
	      
	      if(type != null) {
	    	  type.setName(typeDTO.getName());
	    	  type.setDescription(typeDTO.getDescription());
	    	  typeService.update(type);
		      redirectAttributes.addFlashAttribute("message", "Category '" + type.getName() + "' has been succesfully edited!");
		      return "redirect:/products";
	      }
	      else 
	      {
	    	  logger.error("Editing product error: " + result.getAllErrors());
		      return "redirect:/products";
	      }  
	    }
	  }
	
	@RequestMapping(value = "/product/update_product", method = RequestMethod.GET)
	  public String getEditProductForm(@RequestParam(value = "id", required = true) Long id,
	      Model model,  RedirectAttributes redirectAttributes) {
	    Product product = productService.findProduct(id);
	    if (product != null) {
	      logger.debug("Edit product {}", product);

	      ProductDTO productDTO = new ProductDTO();
	      productDTO.setName(product.getName());
	      productDTO.setDescription(product.getDescription());
	      productDTO.setPrice(product.getPrice());
	      productDTO.setQuantity(product.getQuantity());
	      
	      model.addAttribute("product", productDTO);
	      model.addAttribute("current_type", product.getType());
	      
	      List<Type> productTypes = typeService.findAllTypes();
	      model.addAttribute("product_types", productTypes);
	      
	      return "products_update";
	    } else {
	      logger.error("Edit error: Product with id {} not found", id);
	      return "redirect:/products";
	    }
	    
	  }
	
	@RequestMapping(value = "/product/update_product", method = RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute("product") ProductDTO productDTO, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
	      logger.error("Add product error: " + result.getAllErrors());
	      return "redirect:/products";
	    }
		else
	    {
	      Product product = productService.findProduct(productDTO.getId());
	      
	      if(product != null) {
	    	  boolean error = false;
	    	  
	    	  if(productDTO.getPrice() < 1)
		      {
		    	  error = true;
		    	  redirectAttributes.addFlashAttribute("errorPrice", "Price can't be lower than 1!");
		      }
		      
		      if(productDTO.getQuantity() < 1)
		      {
		    	  error = true;
		    	  redirectAttributes.addFlashAttribute("errorQuantity", "Quantity can't be lower than 1!");
		      }
		      
		      if(error == true)
		      {
		    	  return "redirect:/products/add_product";
		      }
		      
		      product.setName(productDTO.getName());
		      product.setType(new Type(productDTO.getTypeid()));
		      product.setDescription(productDTO.getDescription());
		      product.setPrice(productDTO.getPrice());
		      product.setQuantity(productDTO.getQuantity());
		      productService.update(product);
		      redirectAttributes.addFlashAttribute("message", "Product '" + product.getName() + "' has been succesfully edited!");
		      return "redirect:/products";
	      }
	      else 
	      {
	    	  logger.error("Editing product error: " + result.getAllErrors());
		      return "redirect:/products";
	      }  
	    }
	  }
	
	
	@RequestMapping(value = "/product/delete", method = RequestMethod.GET)
	public String deleteProduct(@Valid @ModelAttribute("id") Long id,  
      BindingResult result,  RedirectAttributes redirectAttributes) {
		try{
			productService.delete(id);
			redirectAttributes.addFlashAttribute("message", "Product successfully deleted!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
		}
    
		return "redirect:/products";
	}
	
	@RequestMapping(value = "/product/delete_type", method = RequestMethod.GET)
	public String deleteType(@Valid @ModelAttribute("id") Long id,  
      BindingResult result,  RedirectAttributes redirectAttributes) {
		try{
			typeService.delete(id);
			redirectAttributes.addFlashAttribute("message", "Category successfully deleted!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
		}
    
		return "redirect:/products";
	}
}
