package mx.unam.aragon.service.impl;

import mx.unam.aragon.entity.TipoBoletoEntity;
import mx.unam.aragon.repository.TipoBoletoRepository;
import mx.unam.aragon.service.TipoBoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoBoletoServiceImpl implements TipoBoletoService {
    @Autowired
    private TipoBoletoRepository tipoBoletoRepository;

    @Override
    public TipoBoletoEntity save(TipoBoletoEntity tipoBoletoEntity) {
        return tipoBoletoRepository.save(tipoBoletoEntity);
    }

    @Override
    public TipoBoletoEntity findById(Long id) {
        Optional<TipoBoletoEntity> op=tipoBoletoRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    public List<TipoBoletoEntity> findAll() {
        return tipoBoletoRepository.findAll();
    }

    @Override
    public void delete(TipoBoletoEntity tipoBoletoEntity) {
        tipoBoletoRepository.delete(tipoBoletoEntity);

    }
}
