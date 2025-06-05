package mx.unam.aragon.service.impl;

import mx.unam.aragon.entity.BoletoEntity;
import mx.unam.aragon.entity.TipoBoletoEntity;
import mx.unam.aragon.service.BoletoService;
import mx.unam.aragon.service.TipoBoletoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoletoServiceImplTest {
    @Autowired
    private BoletoService boletoService;

    @Autowired
    private TipoBoletoService tipoBoletoService;

    @Test
    void save() {
        TipoBoletoEntity tipoBoleto = tipoBoletoService.findById(1L);

        BoletoEntity boleto = BoletoEntity.builder()
                .anyo(1979)
                .folio("250864")
                .lote("RF-XV")
                .tipo(tipoBoleto)
                .build();
        boletoService.save(boleto);
    }

    @Test
    void findById() {
        BoletoEntity boleto = boletoService.findById(1L);
        System.out.println(boleto);
    }

    @Test
    void findAll() {
        List<BoletoEntity> boletos = boletoService.findAll();
        System.out.println(boletos);
    }

    @Test
    void delete() {
    }
}