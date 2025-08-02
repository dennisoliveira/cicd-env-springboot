package com.example.cicd_env_springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.environment}")
    private String environment;

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String hello() {
        String html = String.format("""
               <!DOCTYPE html>
               <html>
                 <head>
                   <title>GitHub Actions - CI/CD</title>
                   <style>
                     body {
                       background: #161b22;
                       color: #fff;
                   </style>
                 </head>
                 <body>
                   <h1>Ambiente %s</h1>
                 </body>
               </html>
               """, environment);
        return html;
    }

}
