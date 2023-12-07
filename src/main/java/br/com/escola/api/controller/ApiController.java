package br.com.escola.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/swagger")
public class ApiController {
    public String swagger(){
        return ("/swagger-ui/index.html");
    }
}
