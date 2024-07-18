package io.springboot.rnd.springboot_jdbi.model;


import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class Product {

  private Integer id;
  private String name;
}
