package persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import persona.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    public Persona findByDni(String dni);
    /*public Persona findById(Integer id);*/
}