package mx.unam.aragon.service;

import mx.unam.aragon.entity.TipoBoletoEntity;

import java.util.List;

public interface TipoBoletoService {
    TipoBoletoEntity save(TipoBoletoEntity tipoBoletoEntity);
    TipoBoletoEntity findById(Long id);
    List<TipoBoletoEntity> findAll();
    void delete(Long id);
}
