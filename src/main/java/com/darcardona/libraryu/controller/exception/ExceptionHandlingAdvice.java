package com.darcardona.libraryu.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingAdvice {

  @ExceptionHandler
  public String handleDefault(Exception e) {
    return "error";
  }

}
