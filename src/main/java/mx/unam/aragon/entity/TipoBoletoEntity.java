package mx.unam.aragon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tipoboleto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoBoletoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipo")
    private Long id;

    @Column(name = "nombre")
    @NotBlank(message = "Nombre no debe estar en blanco")
    @Size(max = 50, message = "El nombre no debe ser mayor a 50 caracteres")
    private String nombre;

    @Column(name = "descripcion")
    @NotBlank(message = "La descripcion no debe estar vacia")
    private String descripcion;
}
