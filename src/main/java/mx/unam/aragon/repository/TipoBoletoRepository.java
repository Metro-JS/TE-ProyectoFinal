package mx.unam.aragon.repository;

import mx.unam.aragon.entity.TipoBoletoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoBoletoRepository extends JpaRepository<TipoBoletoEntity, Long> {
}
