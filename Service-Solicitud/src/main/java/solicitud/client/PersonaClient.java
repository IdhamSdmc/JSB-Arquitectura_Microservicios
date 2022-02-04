package solicitud.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solicitud.model.Persona;

import java.util.Date;

@FeignClient(name = "persona-service")
public interface PersonaClient {

    @RequestMapping(method = RequestMethod.GET, value = "/persona/{dni}")
    @CircuitBreaker(name = "personaCB", fallbackMethod = "personaFallback")
    public ResponseEntity<Persona> getPersona(@PathVariable("dni") String dni);

    @RequestMapping(method = RequestMethod.POST, value = "/persona/crear")
    @CircuitBreaker(name = "personaCB", fallbackMethod = "personaSaveFallback")
    public ResponseEntity<Persona> savePersona(@RequestBody Persona persona);

    public default ResponseEntity<Persona> personaFallback(Exception e){
        Persona persona = Persona.builder()
                .dni("none")
                .nombres("none")
                .correo("none")
                .fecha(new Date()).build();
        return ResponseEntity.ok(persona);
    }

    public default ResponseEntity<Integer> personaSaveFallback(Exception e){
        return ResponseEntity.ok(null);
    }
}
