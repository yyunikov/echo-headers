package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HeadersController {

  @RequestMapping("/request-headers")
  public Map<String, String> get(final HttpServletRequest request, final HttpServletResponse response) {
    final Enumeration<String> headerNames = request.getHeaderNames();
    final Map<String, String> headers = new HashMap<>();
    while (headerNames.hasMoreElements()) {
      final String headerName = headerNames.nextElement();
      final String headerValue = request.getHeader(headerName);
      headers.put(headerName, headerValue);
    }

    return headers;
  }

}

