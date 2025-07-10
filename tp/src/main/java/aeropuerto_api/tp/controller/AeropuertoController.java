package aeropuerto_api.tp.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aeropuerto_api.tp.entity.Aeropuerto;
import aeropuerto_api.tp.service.AeropuertoService;




@RestController
public class AeropuertoController {
	
	@Autowired
	private AeropuertoService aeropuertoService;

    @GetMapping("/aeropuertos")
    public List<Aeropuerto> getAeropuertos() {
        return this.aeropuertoService.findAll();
    }

    @GetMapping("/aeropuerto/{id}")
    public Aeropuerto getAeropuerto(@PathVariable UUID id) {
        return this.aeropuertoService.findById(id);
    }

    @PostMapping("/aeropuerto")
    public void createAeropuerto(@RequestBody Aeropuerto nuevoAeropuerto) {
        this.aeropuertoService.crear(nuevoAeropuerto);
    }
    
    @PutMapping("/aeropuerto")
    public Aeropuerto updateAeropuerto(@RequestBody Aeropuerto nuevoAeropuerto) {
        return this.aeropuertoService.updateAeropuerto(nuevoAeropuerto);
    }
}
