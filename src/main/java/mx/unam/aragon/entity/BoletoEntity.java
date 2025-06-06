package mx.unam.aragon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @NotBlank
    @Size(min = 5, max = 7, message = "El lote debe tener entre 5 y 7 caracteres")
    @Pattern(regexp = "[A-Za-z]+-[A-Za-z]+", message = "el lote debe tener formato AA-XVA, incluyendo el guion")
    private String lote;

    @Column(name = "folio")
    @NotBlank
    @Size(min = 5, max = 6, message = "El folio debe tener entre 5 y 6 digitos")
    private String folio;

    @Column(name = "urlfoto")
    @NotBlank(message = "La imagen debe ser un enlace http valido")
    private String urlfoto;

    @Column(name = "numero")
    @Min(value = 1, message = "La tira de boletos se compone solo de 5 boletos")
    @Max(value = 5, message = "La tira de boletos se compone solo de 5 boletos")
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "idtipo", nullable = false)
    private TipoBoletoEntity tipo;
}
