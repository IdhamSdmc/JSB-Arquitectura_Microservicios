package persona.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import persona.entity.Persona;
import persona.service.PersonaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @PostMapping(value = "crear")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona){
        System.out.println(persona);
        Persona objPersona = personaService.createPersona(persona);

        if(Objects.isNull(objPersona)){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(objPersona);
    }

    @GetMapping(value = "listar")
    public ResponseEntity<List<Persona>> listarPersonas(){
        List<Persona> objPersona = new ArrayList<>();
        objPersona = personaService.listar();
        return ResponseEntity.ok(objPersona);
    }

    @GetMapping(value = "/{dni}")
    public ResponseEntity<Persona> getPersona(@PathVariable("dni") String dni){
        Persona objPersona;
        objPersona = personaService.getPersona(dni);
        if(Objects.isNull(objPersona)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(objPersona);
    }

    @DeleteMapping(value = "eliminar")
    public ResponseEntity<Object> deleteSolicitudes(@RequestParam(value = "dni") String dni){
        String msj = "";
        if(null == dni){
            return ResponseEntity.noContent().build();
        }else {
            msj = personaService.deletePersona(dni);
            if(msj == null){
                return ResponseEntity.noContent().build();
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objMsg = mapper.createObjectNode();
        objMsg.put("mensaje", "La persona con el DNI: "+dni+" ha sido eliminada.");

        return ResponseEntity.ok(objMsg);
    }
}
