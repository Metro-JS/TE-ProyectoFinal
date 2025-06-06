package mx.unam.aragon.repository;

import mx.unam.aragon.entity.DinosaurioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DinosaurioRepository extends JpaRepository<DinosaurioEntity,Long> {
}
