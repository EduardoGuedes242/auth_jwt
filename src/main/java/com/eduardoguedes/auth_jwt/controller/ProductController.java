package com.eduardoguedes.auth_jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products/")
public class ProductController {

  @GetMapping("/test")
  public String getProducts() {
    return "User Authenticate how ADMINISTRATOR";
  }
}
