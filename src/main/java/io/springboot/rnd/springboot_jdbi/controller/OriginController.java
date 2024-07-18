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

import io.springboot.rnd.springboot_jdbi.dao.OriginDao;
import io.springboot.rnd.springboot_jdbi.model.ProductOrigin;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/v1/")
public class OriginController {

  private final OriginDao originDao;

  @Autowired
  public OriginController (OriginDao originDao) {
    this.originDao = originDao;
  }

  @GetMapping("/products/origin")
  public ResponseEntity<List<ProductOrigin>> getProductOrigin(){
      return ResponseEntity.ok (originDao.findAll ());
  }

  @PostMapping ("/products/origin")
  public ResponseEntity<ProductOrigin> createOrigin(@RequestBody ProductOrigin productOrigin){
    ProductOrigin savedProductOrigin = originDao.save(productOrigin);

    return ResponseEntity
        .created(URI.create("/product/origin/" + savedProductOrigin.getId()))
        .body(savedProductOrigin);
  }

}
