package aeropuerto_api.tp.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aeropuerto_api.tp.entity.Avion;



@Repository
public interface AvionRepository extends JpaRepository<Avion, UUID> {

	Optional<Avion> findByNombre(String nombre);

}
