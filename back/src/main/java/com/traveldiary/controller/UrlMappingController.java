package com.traveldiary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UrlMappingController {

  @GetMapping("/")
  public String getIndexPage() {
    return "index";
  }

  @GetMapping("/index")
  public String getRootPage() {
    return "index";
  }

  @GetMapping("/photos")
  public String getPhotoListPage() {
    return "photo-list";
  }

  @GetMapping("/edit")
  public String getEditPage() {
    return "edit";
  }
}