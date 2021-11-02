package ar.com.ada.api.creditos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.creditos.entities.Prestamo;
import ar.com.ada.api.creditos.models.request.InfoNuevoPrestamo;
import ar.com.ada.api.creditos.models.response.GenericResponse;
import ar.com.ada.api.creditos.services.PrestamoService;

@RestController
public class PrestamoController {

    @Autowired
    PrestamoService service;

    @PostMapping("/prestamos")
    public ResponseEntity<?> crearPrestamo(@RequestBody InfoNuevoPrestamo infoPrestamo) {

        service.crearPrestamo(infoPrestamo.clienteId, infoPrestamo.fecha, infoPrestamo.importe, infoPrestamo.cuotas);

        GenericResponse respuesta = new GenericResponse();

        Prestamo prestamo = new Prestamo();

        respuesta.isOk = true;
        respuesta.id = prestamo.getPrestamoId();
        respuesta.message = "El prestamo fue creado con exito";

        return ResponseEntity.ok(respuesta);   
    }
    
}
