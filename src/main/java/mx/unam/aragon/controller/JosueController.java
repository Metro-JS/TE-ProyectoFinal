package mx.unam.aragon.controller;

import jakarta.validation.Valid;
import mx.unam.aragon.entity.DinosaurioEntity;
import mx.unam.aragon.service.DinosaurioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/josue")
public class JosueController{
    @Autowired
    DinosaurioService dinosaurioService;

    @GetMapping("/josue-index")
    public String listaDinosaurio(Model model){
        List<DinosaurioEntity> lista=dinosaurioService.findAll();
        model.addAttribute("lista",lista);
        model.addAttribute("contenido","Listado épico de los dinosaurios");
        return "josue/josue-index";
    }

    @GetMapping("/agregar-dinosaurio")
    public String agregarDinosaurio(Model model){
        DinosaurioEntity dinosaurio=new DinosaurioEntity();
        model.addAttribute("dinosaurio",dinosaurio);
        model.addAttribute("contenido","Añadir Nuevo Dinosaurio");
        return "/josue/agregar-dinosaurio";
    }

    @PostMapping("/guardar-dinosaurio")
    public String guardarDinosaurio(@Valid @ModelAttribute(value = "dinosaurio") DinosaurioEntity dinosaurio,
                                    BindingResult result, Model model){
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            return "/josue/agregar-dinosaurio";
        }
        //realizar la lògica de negocio
        dinosaurioService.save(dinosaurio);
        model.addAttribute("contenido","Se almaceno con exito");
        return "/josue/agregar-dinosaurio";
    }

    @GetMapping("/eliminar-dinosaurio/{id}")
    public String delete(@PathVariable("id")Long id,
                         Model model){
        dinosaurioService.deleteById(id);
        return "redirect:/josue/josue-index";

    }

    @GetMapping("/modificar-dinosaurio/{id}")
    public String modificar(@PathVariable("id")Long id,
                           Model model){
        DinosaurioEntity dinosaurio=dinosaurioService.findById(id);
        model.addAttribute("dinosaurio",dinosaurio);
        model.addAttribute("contenido","Alterar datos del dinosaurio");
        return "/josue/agregar-dinosaurio";
    }
}
