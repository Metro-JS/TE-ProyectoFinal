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
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

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
        model.addAttribute("imagen", "/image/nuevobol.png");
        return "jorge/tipo/nuevo-tipo";
    }

    @PostMapping("guardar-tipo")
    public String guardarTipo(@Valid @ModelAttribute(value = "tipoBoleto") TipoBoletoEntity tipoBoleto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            model.addAttribute("imagen", "/image/configbol.png");
            model.addAttribute("contenido", "Nuevo tipo");
            return "jorge/tipo/nuevo-tipo";
        }
        //realiza el guardado
        model.addAttribute("imagen", "/image/okbol.png");
        model.addAttribute("contenido", "Se ha guardado el tipo de boleto");
        tipoBoletoService.save(tipoBoleto);
        return "jorge/tipo/nuevo-tipo";
    }

    @GetMapping("modificar-tipo/{id}")
    public String modificarTipo(@PathVariable("id")Long id,
                            Model model){
        TipoBoletoEntity tipoBoleto = tipoBoletoService.findById(id);
        model.addAttribute("tipoBoleto", tipoBoleto);
        model.addAttribute("contenido","Modificar tipo");
        model.addAttribute("imagen", "/image/configbol.png");
        return "jorge/tipo/nuevo-tipo";

    }

    //eliminar
    @GetMapping("eliminar-tipo/{id}")
    public String deleteTipo(@PathVariable("id")Long id,
                         Model model){
        tipoBoletoService.delete(id);
        return "redirect:/jorge/lista-tipos?ok";

    }

    @GetMapping("/lista-tipos")
    public String listaTipos(Model model){
        List<TipoBoletoEntity> listaTipos = tipoBoletoService.findAll();
        model.addAttribute("lista",listaTipos);
        return "jorge/tipo/lista-tipos";
    }




    @GetMapping("/nuevoboleto")
    public String nuevo(Model model) {
        BoletoEntity boleto = new BoletoEntity();
        List<TipoBoletoEntity> listaTipos = tipoBoletoService.findAll();
        System.out.println(listaTipos);
        model.addAttribute("boleto", boleto);
        model.addAttribute("tipos", listaTipos);
        model.addAttribute("imagen", "/image/nuevobol.png");
        model.addAttribute("contenido", "Nuevo boleto");
        return "jorge/boleto/nuevo";
    }

    @PostMapping("guardar-boleto")
    public String guardarBoleto(@Valid @ModelAttribute(value = "boleto") BoletoEntity boleto, BindingResult result, Model model) {
        List<TipoBoletoEntity> listaTipos = tipoBoletoService.findAll();
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            model.addAttribute("imagen", "/image/configbol.png");
            model.addAttribute("boleto", boleto);
            model.addAttribute("tipos", listaTipos);
            model.addAttribute("contenido", "Alta boleto");
            return "jorge/boleto/nuevo";
        }
        //realiza el guardado
        model.addAttribute("imagen", "/image/okbol.png");
        model.addAttribute("tipos", listaTipos);
        model.addAttribute("contenido", "Se ha guardado el boleto");
        boletoService.save(boleto);
        return "jorge/boleto/nuevo";
    }

    @GetMapping("lista-boletos")
    public String listaBoletos(Model model){
        List<BoletoEntity> lista=boletoService.findAll();
        //List<GeneroEntity> generos = generoService.findAll();
        //List<DirectorEntity> directors = directorService.findAll();

        //model.addAttribute("directo", directors);
        //model.addAttribute("generoz", generos);
        model.addAttribute("lista",lista);
        model.addAttribute("contenido","Coleccion de Boletos");
        return "jorge/boleto/lista-boletos";
    }

    @GetMapping("modificar-boleto/{id}")
    public String modificarBoleto(@PathVariable("id")Long id,
                                Model model){
        BoletoEntity boleto = boletoService.findById(id);
        List<TipoBoletoEntity> listaTipos = tipoBoletoService.findAll();
        System.out.println(listaTipos);
        model.addAttribute("boleto", boleto);
        model.addAttribute("tipos", listaTipos);
        model.addAttribute("imagen", "/image/configbol.png");
        model.addAttribute("contenido", "Modificar boleto");
        return "jorge/boleto/nuevo";

    }
    @GetMapping("eliminar-boleto/{id}")
    public String deleteBoleto(@PathVariable("id")Long id,
                             Model model){
        boletoService.delete(id);
        return "redirect:/jorge/lista-boletos?ok";

    }


    //excepcion en caso de borar un directgor dentro de una pelicula
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public String handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex){
        return "redirect:/jorge/lista-tipos?err";
    }
}
