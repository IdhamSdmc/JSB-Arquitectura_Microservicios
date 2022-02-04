package solicitud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solicitud.entity.Solicitud;
import solicitud.service.SolicitudService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "solicitud")
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;

    @PostMapping(value = "crear")
    public ResponseEntity<Solicitud> saveSolicitudes(@RequestBody Solicitud solicitud){
        Solicitud solicituds = solicitudService.createSolicitud(solicitud);
        if(Objects.isNull(solicituds)){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(solicitud);
    }

    @GetMapping(value = "listar")
    public ResponseEntity<List<Solicitud>> listSolicitudes(){
        List<Solicitud> solicituds = new ArrayList<>();
        solicituds = solicitudService.listar();
        return ResponseEntity.ok(solicituds);
    }

    @GetMapping(value = "consultar")
    public ResponseEntity<List<Solicitud>> listSolicitudes(@RequestParam(value = "dni") String dni){
        List<Solicitud> solicituds = new ArrayList<>();
        solicituds = solicitudService.listarAll(dni);
        return ResponseEntity.ok(solicituds);
    }

    @PutMapping(value = "actualizar")
    public ResponseEntity<Solicitud> updateSolicitud(@RequestParam(value = "id") Integer id, @RequestParam(value = "estado") String estado){
        Solicitud sol = solicitudService.updateSolicitud(id, estado);
        if(Objects.isNull(sol)){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(sol);
    }

    @DeleteMapping(value = "eliminar")
    public ResponseEntity<Object> deleteSolicitudes(@RequestParam(value = "dni") Integer dni){
        String msj = "";
        if(null == dni){
            return ResponseEntity.noContent().build();
        }else {
            msj = solicitudService.deleteSolicitud(dni);
            if(msj == null){
                return ResponseEntity.noContent().build();
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objMsg = mapper.createObjectNode();
        objMsg.put("dni", dni);
        return ResponseEntity.ok(objMsg);
    }

    @DeleteMapping(value = "eliminar-todo")
    public ResponseEntity<Object> deleteSolicitudes(){
        String msj = "Se ha eliminado todo.";
        solicitudService.deleteSolicitudes();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objMsg = mapper.createObjectNode();
        objMsg.put("msj", msj);
        return ResponseEntity.ok(objMsg);
    }
}
