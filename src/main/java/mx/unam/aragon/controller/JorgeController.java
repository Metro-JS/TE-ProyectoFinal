package mx.unam.aragon.controller;

import jakarta.validation.Valid;
import mx.unam.aragon.entity.BoletoEntity;
import mx.unam.aragon.entity.TipoBoletoEntity;
import mx.unam.aragon.service.BoletoService;
import mx.unam.aragon.service.TipoBoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jorge")
public class JorgeController {
    @Autowired
    TipoBoletoService tipoBoletoService;

    @Autowired
    BoletoService boletoService;

    @GetMapping("")
    public String jorge(Model model) {
        return "jorge/jorge-index";
    }


    @GetMapping("/nuevotipo")
    public String nuevoTipo(Model model) {
        TipoBoletoEntity tipoBoleto = new TipoBoletoEntity();
        model.addAttribute("tipoBoleto", tipoBoleto);
        model.addAttribute("contenido", "Nuevo tipo");
        return "jorge/tipo/nuevo-tipo";
    }

    @PostMapping("guardar-tipo")
    public String guardarTipo(@Valid @ModelAttribute(value = "tipoBoleto") TipoBoletoEntity tipoBoleto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            model.addAttribute("contenido", "Nuevo tipo");
            return "jorge/tipo/nuevo-tipo";
        }
        //realiza el guardado
        model.addAttribute("contenido", "Se ha guardado el tipo de boleto");
        tipoBoletoService.save(tipoBoleto);
        return "jorge/tipo/nuevo-tipo";
    }

    @GetMapping("/nuevoboleto")
    public String nuevo(Model model) {
        BoletoEntity boleto = new BoletoEntity();
        model.addAttribute("boleto", boleto);
        model.addAttribute("contenido", "Nuevo boleto");
        return "jorge/boleto/nuevo";
    }

    @PostMapping("guardar-boleto")
    public String guardarBoleto(@Valid @ModelAttribute(value = "boleto") BoletoEntity boleto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            return "jorge/boleto/nuevo";
        }
        //realiza el guardado
        model.addAttribute("contenido", "Se ha guardado el boleto");
        boletoService.save(boleto);
        return "jorge/boleto/nuevo";
    }
}
