package io.springboot.rnd.springboot_jdbi.dao;

import java.util.List;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.springboot.rnd.springboot_jdbi.model.Product;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class ProductDao {

  private final Jdbi jdbi;

  @Autowired
  public ProductDao (Jdbi jdbi) {
    this.jdbi = jdbi;
  }

  public List<Product> findAll () {
    return jdbi.withHandle (handle ->
        handle.createQuery ("SELECT * FROM springboot_application_tables.products")
            .mapToBean (Product.class)
            .list ()
    );
  }

  public int save (Product product) {
    return jdbi.withHandle (handle -> {
      return handle.createUpdate (
              "INSERT INTO springboot_application_tables.products(name) VALUES(:name)")
          .bind ("name", product.getName ())
          .executeAndReturnGeneratedKeys ("id")
          .mapTo (int.class)
          .one ();
    });
  }

}
