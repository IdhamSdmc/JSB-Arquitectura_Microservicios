package solicitud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solicitud.entity.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    public Solicitud findByPersonaId(String personaId);
    public Solicitud findById(Integer id);
    public Solicitud findAllByPersonaId(String id);
}
