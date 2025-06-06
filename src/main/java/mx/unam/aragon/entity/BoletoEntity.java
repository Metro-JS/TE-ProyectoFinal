package mx.unam.aragon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @Min(value = 1900, message = "el anyo debe tener un formato numerico YYYY, entre 1900 y 2030")
    @Max(value = 2030, message = "el anyo debe tener un formato numerico YYYY, entre 1900 y 2030")
    @NotNull(message = "anyo no debe ser vacio")
    private Integer anyo;

    @Column(name = "lote")

    private String lote;

    @Column(name = "folio")
    private String folio;

    @Column(name = "urlfoto")
    private String urlfoto;

    @Column(name = "numero")
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "idtipo", nullable = false)
    private TipoBoletoEntity tipo;
}
