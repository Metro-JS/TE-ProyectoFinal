package mx.unam.aragon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jorge")
public class JorgeController {
    @GetMapping("")
    public String jorge(Model model) {
        return "jorge/jorge-index";
    }


}
