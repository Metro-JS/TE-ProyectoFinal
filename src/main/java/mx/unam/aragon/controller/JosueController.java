package mx.unam.aragon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/josue")
public class JosueController{
    @GetMapping("")
    public String josue(Model model) {
        return "josue/josue-index";
    }
}
