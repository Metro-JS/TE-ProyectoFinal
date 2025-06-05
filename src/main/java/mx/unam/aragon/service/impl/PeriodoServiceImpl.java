package mx.unam.aragon.service.impl;

import jakarta.transaction.Transactional;
import mx.unam.aragon.entity.PeriodoEntity;
import mx.unam.aragon.repository.PeriodoRepository;
import mx.unam.aragon.service.PeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PeriodoServiceImpl implements PeriodoService {
    @Autowired
    private PeriodoRepository periodoRepository;

    @Override
    public PeriodoEntity save(PeriodoEntity periodo) {
        return periodoRepository.save(periodo);
    }

    @Override
    public List<PeriodoEntity> findAll() {
        return periodoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        periodoRepository.deleteById(id);
    }

    @Override
    public PeriodoEntity findById(Long id) {
        Optional<PeriodoEntity> periodoEntity = periodoRepository.findById(id);
        return periodoEntity.orElse(null);
    }
}
