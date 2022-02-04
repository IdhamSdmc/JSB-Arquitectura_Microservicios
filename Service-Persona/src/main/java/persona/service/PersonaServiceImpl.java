package persona.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persona.entity.Persona;
import persona.repository.PersonaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona createPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public List<Persona> listar() {
        return personaRepository.findAll();
    }

    @Override
    public Persona getPersona(String dni) {
        return personaRepository.findByDni(dni);
    }

    /*@Override
    public Persona getPersona2(Integer id) {
        return personaRepository.findById(id);
    }*/

    /*@Override
    public Persona updatePersona(Persona persona) {
        Persona objPersona = getPersona(persona.getDni());
        if(objPersona == null){
            return null;
        }

        objPersona.setNombres(persona.getNombres());
        objPersona.setCorreo(persona.getCorreo());
        return personaRepository.save(objPersona);
    }*/

    @Override
    public String deletePersona(String dni) {
        Persona objPersona = getPersona(dni);
        if(objPersona == null){
            return null;
        }
        personaRepository.delete(objPersona);
        return "Eliminado";
    }
}
