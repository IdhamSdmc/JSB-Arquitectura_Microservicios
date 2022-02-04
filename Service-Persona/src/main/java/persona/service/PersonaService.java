package persona.service;

import persona.entity.Persona;

import java.util.List;

public interface PersonaService {
    public Persona createPersona(Persona persona);
    public List<Persona> listar();
    public Persona getPersona(String dni);
    //public Persona getPersona2(Integer id);
    //public Persona updatePersona(Persona persona);
    public String deletePersona(String dni);
}