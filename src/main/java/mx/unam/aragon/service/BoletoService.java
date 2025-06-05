package mx.unam.aragon.service;

import mx.unam.aragon.entity.BoletoEntity;
import mx.unam.aragon.entity.TipoBoletoEntity;

import java.util.List;

public interface BoletoService {
    BoletoEntity save(BoletoEntity boletoEntity);
    BoletoEntity findById(Long id);
    List<BoletoEntity> findAll();
    void delete(BoletoEntity boletoEntity);
}
