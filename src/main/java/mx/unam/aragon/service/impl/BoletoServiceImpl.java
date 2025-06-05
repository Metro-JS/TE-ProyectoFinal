package mx.unam.aragon.service.impl;

import mx.unam.aragon.entity.BoletoEntity;
import mx.unam.aragon.repository.BoletoRepository;
import mx.unam.aragon.service.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletoServiceImpl implements BoletoService {
    @Autowired
    private BoletoRepository boletoRepository;

    @Override
    public BoletoEntity save(BoletoEntity boletoEntity) {
        return boletoRepository.save(boletoEntity);
    }

    @Override
    public BoletoEntity findById(Long id) {
        Optional<BoletoEntity> boletoEntity = boletoRepository.findById(id);
        return boletoEntity.orElse(null);
    }

    @Override
    public List<BoletoEntity> findAll() {
        return boletoRepository.findAll();
    }

    @Override
    public void delete(BoletoEntity boletoEntity) {
        boletoRepository.delete(boletoEntity);
    }
}
