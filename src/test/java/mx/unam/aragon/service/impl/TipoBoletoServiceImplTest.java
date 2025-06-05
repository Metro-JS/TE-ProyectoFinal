package mx.unam.aragon.service.impl;

import mx.unam.aragon.entity.TipoBoletoEntity;
import mx.unam.aragon.service.TipoBoletoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TipoBoletoServiceImplTest {
    @Autowired
    TipoBoletoService tipoBoletoService;

    @Test
    void save() {
        TipoBoletoEntity tipoBoleto = TipoBoletoEntity.builder()
                .nombre("Boleto ordinario")
                .descripcion("Boleto normal")
                .build();
        tipoBoletoService.save(tipoBoleto);
    }

    @Test
    void findById() {
        TipoBoletoEntity tipoBoleto = tipoBoletoService.findById(1L);
        System.out.println(tipoBoleto);
    }

    @Test
    void findAll() {
        List<TipoBoletoEntity> list = tipoBoletoService.findAll();
        System.out.println(list);
    }

    @Test
    void delete() {
    }
}