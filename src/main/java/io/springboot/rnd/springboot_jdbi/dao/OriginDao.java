package io.springboot.rnd.springboot_jdbi.dao;

import java.util.List;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.springboot.rnd.springboot_jdbi.model.ProductOrigin;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class OriginDao {

  private final Jdbi jdbi;

  @Autowired
  public OriginDao (Jdbi jdbi) {
    this.jdbi = jdbi;
  }

  public List<ProductOrigin> findAll () {
    return jdbi.withHandle (handle ->
        handle.createQuery ("SELECT * FROM springboot_application_tables.product_origin")
            .mapToBean (ProductOrigin.class)
            .list ()
    );
  }

  public ProductOrigin save (ProductOrigin productOrigin) {
    long generatedId = jdbi.withHandle (handle -> {
      return handle.createUpdate (
              "INSERT INTO springboot_application_tables.product_origin(product_id, country) VALUES(:productId, :country)")
          .bindBean (productOrigin)
          .executeAndReturnGeneratedKeys ()
          .mapTo (Long.class)
          .findOnly ();
    });

    productOrigin.setId ((int) generatedId);

    return productOrigin;
  }
}
