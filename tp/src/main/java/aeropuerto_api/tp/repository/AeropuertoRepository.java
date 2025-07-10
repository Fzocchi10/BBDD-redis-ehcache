package aeropuerto_api.tp.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aeropuerto_api.tp.entity.Aeropuerto;

@Repository
public interface AeropuertoRepository extends JpaRepository<Aeropuerto, UUID>{

	Optional<Aeropuerto> findByNombreAndCiudadAndPais(String nombre, String ciudad, String pais);
	
}
