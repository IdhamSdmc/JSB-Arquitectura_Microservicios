package solicitud.entity;

import lombok.Data;
import solicitud.model.Persona;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "solicitud")
@Data
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double monto;
    private Integer cuotas;
    private String estado;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "persona_id")
    private String personaId;

    @Transient
    private Persona persona;

    @PrePersist
    public void perPersist(){
        this.fecha = new Date();
    }
}
