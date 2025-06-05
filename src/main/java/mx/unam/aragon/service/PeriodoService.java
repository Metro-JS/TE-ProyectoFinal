package mx.unam.aragon.service;

import mx.unam.aragon.entity.PeriodoEntity;

import java.util.List;

public interface PeriodoService {
    PeriodoEntity save(PeriodoEntity periodo);
    List<PeriodoEntity> findAll();
    void  deleteById(Long id);
    PeriodoEntity findById(Long id);

}
