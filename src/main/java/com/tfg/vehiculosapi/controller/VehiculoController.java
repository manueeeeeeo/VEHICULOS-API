package com.tfg.vehiculosapi.controller;

import com.tfg.vehiculosapi.service.VehiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Controlador que nos permite gestionar las peticiones a la API relacionadas con vehículos.
 * Generamos y llamamos a los endpoints para obtener marcas y modelos de coches y motos.
 */
@RestController
@RequestMapping("/api")
public class VehiculoController {

	// Variable para hacer referencia al servicio de los vehiculos
    private final VehiculoService vehiculoService;

    /**
     * @param vehiculoService
     * Constructor en donde inicializamos
     * la variable a nivel de clase creada anteriormente,
     * para así poder acceder a todos los datos del servicio
     */
    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    /**
     * Método para obtener todas las marcas de coches
     */
    @GetMapping("/marcas/coches")
    public Set<String> getMarcasCoches() {
        return vehiculoService.getMarcasCoches();
    }

    /**
     * Método para obtener todas las marcas de motos
     */
    @GetMapping("/marcas/motos")
    public Set<String> getMarcasMotos() {
        return vehiculoService.getMarcasMotos();
    }

    /**
     * @param marca
     * Método para obtener todos los modelos de una marca
     * de coche pasandole como parametro la marca
     */
    @GetMapping("/modelos/coches")
    public List<String> getModelosCoches(@RequestParam String marca) {
        return vehiculoService.getModelosCochePorMarca(marca);
    }

    /**
     * @param marca
     * Método para obtener todos los modelos de una marca
     * de moto pasandole como parametro la marca
     */
    @GetMapping("/modelos/motos")
    public List<String> getModelosMotos(@RequestParam String marca) {
        return vehiculoService.getModelosMotoPorMarca(marca);
    }
}