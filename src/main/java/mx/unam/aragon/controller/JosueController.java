package mx.unam.aragon.controller;

import mx.unam.aragon.entity.DinosaurioEntity;
import mx.unam.aragon.service.DinosaurioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/josue")
public class JosueController{
    @Autowired
    DinosaurioService dinosaurioService;

    @GetMapping("josue-index")
    public String listaDinosaurio(Model model){
        List<DinosaurioEntity> lista=dinosaurioService.findAll();
        model.addAttribute("lista",lista);
        model.addAttribute("contenido","Listado épico de los dinosaurios");
        return "josue/josue-index";
    }
}
