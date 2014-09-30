package com.symulakr.restapi.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
public class DBConfiguration
{

   @Bean
   public DataSource dataSource() throws PropertyVetoException
   {
      ComboPooledDataSource dataSource = new ComboPooledDataSource();
      dataSource.setDriverClass("com.mysql.jdbc.Driver");
      dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/db");
      dataSource.setUser("user");
      dataSource.setPassword("pass");
      dataSource.setInitialPoolSize(3);
      dataSource.setMinPoolSize(3);
      dataSource.setMaxPoolSize(50);
      return dataSource;
   }

   @Bean
   @Autowired
   public JdbcTemplate jdbcTemplate(DataSource dataSource)
   {
      return new JdbcTemplate(dataSource);
   }

}
