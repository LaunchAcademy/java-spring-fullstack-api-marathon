package com.launchacademy.marathon.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @GetMapping(value = {"/artists", "/artists/new", "/artists/{id}", "/artists/{id}/songs/new"})
  public String forward() {
    return "forward:/";
  }
}
