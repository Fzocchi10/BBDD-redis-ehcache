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
import aeropuerto_api.tp.entity.Avion;
import aeropuerto_api.tp.service.AvionService;



@RestController
public class AvionController {
	@Autowired
	private AvionService avionService;
	

    @GetMapping("/avion")
    public List<Avion> getAviones() {
        return this.avionService.findAll();
    }

    @GetMapping("/avion/{id}")
    public Avion getAvion(@PathVariable UUID id) {
        return this.avionService.findById(id);
    }
    
    @PutMapping("/avion")
    public Avion updateAvion(@RequestBody Avion nuevoAvion) {
        return this.avionService.updateNombre(nuevoAvion);
    }
    
    @PostMapping("/avion")
    public void createAvion(@RequestBody Avion nuevoAvion) {
        this.avionService.crear(nuevoAvion);
    }
}
