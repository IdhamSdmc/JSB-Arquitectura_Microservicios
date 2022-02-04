package solicitud.service;

import solicitud.entity.Solicitud;

import java.util.List;

public interface SolicitudService {
    public Solicitud createSolicitud(Solicitud solicitud);
    public List<Solicitud> listar();
    public List<Solicitud> listarAll(String dni);
    public Solicitud getSolicitud(String dni);
    public Solicitud getSolicitud2(Integer id);
    //public Persona getPersona2(Integer id);
    public Solicitud updateSolicitud(Integer id, String estado);
    public String deleteSolicitud(Integer dni);
    public String deleteSolicitudes();
}
