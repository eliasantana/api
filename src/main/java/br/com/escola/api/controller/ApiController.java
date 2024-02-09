package br.com.escola.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/swagger")
public class ApiController {
    public RedirectView swagger(){
        return new RedirectView("http://localhost:8084/swagger-ui/index.html");
    }
}
