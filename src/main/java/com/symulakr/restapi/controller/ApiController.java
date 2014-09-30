package com.symulakr.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApiController
{

   @Autowired
   JdbcTemplate jdbcTemplate;

   @RequestMapping(value = "row", method = RequestMethod.GET, produces = "text/plain")
   @ResponseBody
   public String getRoot(@RequestParam("id") Integer id)
   {
      return jdbcTemplate.queryForObject("SELECT t.name FROM db.cdr t WHERE t.id = ?", parameters(id), String.class);
   }

   private Object[] parameters(Object... params)
   {
      return params;
   }

}
