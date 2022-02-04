package solicitud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solicitud.client.PersonaClient;
import solicitud.entity.Solicitud;
import solicitud.model.Persona;
import solicitud.repository.SolicitudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService{

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private PersonaClient personaClient;

    @Override
    public Solicitud createSolicitud(Solicitud solicitud) {
        solicitud.setEstado("PENDIENTE");
        Persona persona = personaClient.getPersona(solicitud.getPersonaId()).getBody();
        solicitud.setPersona(persona);
        return solicitudRepository.save(solicitud);
    }

    /*@Override
    public Solicitud createSolicitud(Solicitud solicitud) {
        solicitud.setEstado("PENDIENTE");
        Persona persona = personaClient.savePersona(solicitud.getPersona()).getBody();
        solicitud.setPersona(persona);
        return solicitudRepository.save(solicitud);
    }*/

    @Override
    public List<Solicitud> listar() {
        return solicitudRepository.findAll().stream().map(item->{
            Persona persona = personaClient.getPersona(item.getPersonaId()).getBody();
            item.setPersona(persona);
            return item;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Solicitud> listarAll(String dni) {
        List<Solicitud> solicituds = new ArrayList<>();

        List<Solicitud> newList = new ArrayList<>();
        solicitudRepository.findAll().forEach(item -> {
            if(item.getPersonaId().equals(dni)){
                Persona persona = personaClient.getPersona(item.getPersonaId()).getBody();
                item.setPersona(persona);
                newList.add(item);
            }
        });

        return newList;
    }

    @Override
    public Solicitud getSolicitud(String dni) {
        Solicitud solicitud = solicitudRepository.findByPersonaId(dni);
        if (solicitud != null) {
            Persona persona = personaClient.getPersona(solicitud.getPersonaId()).getBody();
            solicitud.setPersona(persona);
            return solicitud;
        }
        return null;
    }

    @Override
    public Solicitud getSolicitud2(Integer id) {
        Solicitud solicitud = solicitudRepository.findById(id);
        if(solicitud != null){
            Persona persona = personaClient.getPersona(solicitud.getPersonaId()).getBody();
            solicitud.setPersona(persona);
            return solicitud;
        }
        return null;
    }

    @Override
    public Solicitud updateSolicitud(Integer id, String estado) {
        Solicitud solicitud = getSolicitud2(id);
        if(null == solicitud){
            return null;
        }
        solicitud.setEstado(estado);
        Solicitud obj = solicitudRepository.save(solicitud);
        Persona persona = personaClient.getPersona(solicitud.getPersonaId()).getBody();
        obj.setPersona(persona);
        return obj;
    }

    @Override
    public String deleteSolicitud(Integer dni) {
        Solicitud solicitud = getSolicitud2(dni);
        if(null == solicitud){
            return null;
        }
        solicitudRepository.delete(solicitud);
        return "Eliminado";
    }

    @Override
    public String deleteSolicitudes() {
        solicitudRepository.deleteAll();
        return "Eliminado";
    }
}
