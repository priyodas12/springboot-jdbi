package io.springboot.rnd.springboot_jdbi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrigin {

  private Integer id;
  private Integer productId;
  private CountryOrigin country;
}
