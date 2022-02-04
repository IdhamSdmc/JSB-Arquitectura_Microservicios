package solicitud.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Persona {
    private String dni;
    private String nombres;
    private String correo;
    private Date fecha;
}
