package mx.unam.aragon.service.impl;


import jakarta.transaction.Transactional;
import mx.unam.aragon.entity.DinosaurioEntity;
import mx.unam.aragon.repository.DinosaurioRepository;
import mx.unam.aragon.service.DinosaurioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DinosaurioServiceImpl implements DinosaurioService {
    @Autowired
    private DinosaurioRepository dinosaurioRepository;

    @Override
    public DinosaurioEntity save(DinosaurioEntity dinosaurio) {
        return dinosaurioRepository.save(dinosaurio);
    }

    @Override
    public List<DinosaurioEntity> findAll() {
        return dinosaurioRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        dinosaurioRepository.deleteById(id);
    }

    @Override
    public DinosaurioEntity findById(Long id) {
        Optional<DinosaurioEntity> dinosaurioEntity = dinosaurioRepository.findById(id);
        return dinosaurioEntity.orElse(null);
    }
}
