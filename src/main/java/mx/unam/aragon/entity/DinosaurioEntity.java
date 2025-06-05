package mx.unam.aragon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "dinosaurio")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DinosaurioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dinosaurio")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "locomocion")
    private String locomocion;

    @Column(name = "peso")
    private Integer peso;

    @Column(name = "dieta")
    private String dieta;

    @Column(name = "periodo")
    private String periodo;

    @Column(name = "url_foto")
    private String urlFoto;

}
