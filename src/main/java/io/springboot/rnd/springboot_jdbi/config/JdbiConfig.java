package io.springboot.rnd.springboot_jdbi.config;

import javax.sql.DataSource;

import org.jdbi.v3.core.Jdbi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
public class JdbiConfig {

  @Bean
  public Jdbi jdbi (DataSource dataSource) {
    log.info ("Creating datasource...");
    return Jdbi.create (dataSource);
  }

  @Bean
  public DataSource dataSource () {
    DriverManagerDataSource dataSource = new DriverManagerDataSource ();
    dataSource.setDriverClassName ("org.postgresql.Driver");
    dataSource.setUrl ("jdbc:postgresql://localhost:5432/<db_name>");
    //hardcode username & password here
    return dataSource;
  }
}

