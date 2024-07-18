package io.springboot.rnd.springboot_jdbi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.rnd.springboot_jdbi.dao.ProductDao;
import io.springboot.rnd.springboot_jdbi.model.Product;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping ("/api/v1/")
public class ProductController {

  private final ProductDao productDao;

  @Autowired
  public ProductController (ProductDao productDao) {
    this.productDao = productDao;
  }

  @GetMapping ("/products")
  public ResponseEntity<List<Product>> getProductOrigin () {
    return ResponseEntity.ok (productDao.findAll ());
  }

  @PostMapping ("/product")
  public ResponseEntity<Integer> createOrigin (@RequestBody Product product) {
    Integer savedProductId = productDao.save (product);

    return ResponseEntity
        .created (URI.create ("/product" + savedProductId))
        .body (savedProductId);
  }

}
