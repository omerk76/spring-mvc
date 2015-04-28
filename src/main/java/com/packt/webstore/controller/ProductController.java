package com.packt.webstore.controller;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.NoProductsFoundUnderCategoryException;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.ProductService;
import com.packt.webstore.validator.UnitInStockValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by okeynan on 4/16/15.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService mProductService;

    @Autowired
    UnitInStockValidator mUnitInStockValidator;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("products", mProductService.getAllProducts());
        return "products";
    }

    @RequestMapping("/all")
    public String allProducts(Model model) {
        model.addAttribute("products", mProductService.getAllProducts());

        return "products";
    }

    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) throws NoProductsFoundUnderCategoryException {
        List<Product> products = mProductService.getProductsByCategory(productCategory);
        if (products == null || products.isEmpty()) {
            throw new NoProductsFoundUnderCategoryException();
        }
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model) throws ProductNotFoundException {
        model.addAttribute("product", mProductService.getById(productId));
        return "product";
    }

    @RequestMapping("/{category}/{price}")
    public String filterProducts(@PathVariable("category") String category,
                                 @MatrixVariable(pathVar = "price") Map<String, List<String>> priceMap,
                                 @RequestParam(value = "manufacturer") String manufacturer,
                                 Model model) {
        int lowPrice = 0;//= min;
        int highPrice = Integer.MAX_VALUE;//= max;
        List<String> priceRangeMin = priceMap.get("min");
        List<String> priceRangeMax = priceMap.get("max");
        if (priceRangeMin != null) {
            lowPrice = Integer.parseInt(priceRangeMin.get(0));
        }
        if (priceRangeMax != null) {
            highPrice = Integer.parseInt(priceRangeMax.get(0));
        }
        List<Product> list = mProductService.getProductsByManufacturer(manufacturer);
        List<Product> result = new ArrayList<>();
        for (Product product : list) {
            if (product.getCategory().toLowerCase().equals(category)) {
                int unitPrice = product.getUnitPrice().intValue();
                if (unitPrice >= lowPrice && unitPrice <= highPrice) {
                    result.add(product);
                }
            }
        }
        model.addAttribute("products", result);
        return "products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model) {
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processNewProductForm(@ModelAttribute("newProduct") @Valid Product newProd, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "addProduct";
        }
        MultipartFile image = newProd.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if (image != null && !image.isEmpty()) {
            try {
                String imagePath = rootDirectory + "resources/images/" + newProd.getProductId() + ".png";
                image.transferTo(new File(imagePath));
                System.out.println("saving image to path = " + imagePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        MultipartFile manual = newProd.getProductManual();
        if (manual != null && !manual.isEmpty()) {
            String manualPath = rootDirectory + "resources/pdf/" + newProd.getProductId() + ".pdf";
            try {
                manual.transferTo(new File(manualPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String[] suppressedFields = bindingResult.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new IllegalArgumentException("Attempt to bind disallowed fields");
        }
        mProductService.addProduct(newProd);
        return "redirect:/products";
    }

    @InitBinder
    public void initializeBinder(WebDataBinder binder) {
        binder.setDisallowedFields("unitsInOrder", "discontinued");
        binder.setValidator(mUnitInStockValidator);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest request, ProductNotFoundException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidProductId", exception.getProductId());
        mav.addObject("exception", exception);
        mav.addObject("url", request.getRequestURL() + "?" + request.getQueryString());
        mav.setViewName("productNotFound");
        return mav;
    }
}
