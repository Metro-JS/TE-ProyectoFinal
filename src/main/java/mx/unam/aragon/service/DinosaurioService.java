package mx.unam.aragon.service;

import mx.unam.aragon.entity.DinosaurioEntity;

import java.util.List;

public interface DinosaurioService {
    DinosaurioEntity save(DinosaurioEntity dinosaurio);
    List<DinosaurioEntity> findAll();
    void  deleteById(Long id);
    DinosaurioEntity findById(Long id);

}
