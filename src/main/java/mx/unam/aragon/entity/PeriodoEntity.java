package mx.unam.aragon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "periodo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PeriodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_periodo")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "anyo_inicio")
    private Integer anyo_inicio;

    @Column(name = "anyo_final")
    private Integer anyo_final;
}
