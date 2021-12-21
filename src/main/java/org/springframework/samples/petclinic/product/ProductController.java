package org.springframework.samples.petclinic.product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    
    private static List<String> productTypes = Arrays.asList("Food","Accessories");
    private static final String CREATE_OR_UPDATE_PRODUCT = "products/createOrUpdateProductForm";


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}


	@GetMapping(value = "/product/create")
	public String initCreationForm(Map<String, Object> model) {
		Product product = new Product();
		model.put("product", product);
        model.put("productTypes", productTypes);
		return CREATE_OR_UPDATE_PRODUCT;
	}

	@PostMapping(value = "/product/create")
	public String processCreationForm(@Valid Product product, BindingResult result) {
		if (result.hasErrors()) {
			return CREATE_OR_UPDATE_PRODUCT;
		} else {
            try {
                this.productService.save(product);
                return "welcome";

            } catch (Exception e) {
                System.err.println(e.getMessage());
                return CREATE_OR_UPDATE_PRODUCT;
            }
		}
	}

}
