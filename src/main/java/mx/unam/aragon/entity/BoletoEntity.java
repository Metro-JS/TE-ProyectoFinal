package mx.unam.aragon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "boleto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoletoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idboleto")
    private Long id;

    @Column(name = "anyo")
    private Integer anyo;

    @Column(name = "lote")
    private String lote;

    @Column(name = "folio")
    private String folio;

    @ManyToOne
    @JoinColumn(name = "idtipo", nullable = false)
    private TipoBoletoEntity tipo;
}
