package persona.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persona")
@Data
public class Persona {
    @Id
    @Column(unique = true,name = "dni")
    private String dni;
    private String nombres;
    private String correo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @PrePersist
    public void perPersist(){
        this.fecha = new Date();
    }
}