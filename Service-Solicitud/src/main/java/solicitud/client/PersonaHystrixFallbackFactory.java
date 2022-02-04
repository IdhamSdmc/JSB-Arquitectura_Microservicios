package solicitud.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import solicitud.model.Persona;

import java.util.Date;

@Component
public class PersonaHystrixFallbackFactory implements PersonaClient{
    @Override
    public ResponseEntity<Persona> getPersona(String dni) {
        Persona persona = Persona.builder()
                .dni("none")
                .nombres("none")
                .correo("none")
                .fecha(new Date()).build();
        return ResponseEntity.ok(persona);
    }

    @Override
    public ResponseEntity<Persona> savePersona(Persona persona) {
        return null;
    }

    @Override
    public ResponseEntity<Persona> personaFallback(Exception e) {
        return PersonaClient.super.personaFallback(e);
    }

    @Override
    public ResponseEntity<Integer> personaSaveFallback(Exception e) {
        return PersonaClient.super.personaSaveFallback(e);
    }
}
