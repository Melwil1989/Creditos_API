package ar.com.ada.api.creditos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.excepciones.ClienteDNIException;
import ar.com.ada.api.creditos.models.request.InfoClienteAActualizar;
import ar.com.ada.api.creditos.models.response.GenericResponse;
import ar.com.ada.api.creditos.services.ClienteService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> traerTodos() {

        return ResponseEntity.ok(service.traerTodos());
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente) {

        service.crearCliente(cliente);

        GenericResponse respuesta = new GenericResponse();

        respuesta.isOk = true;
        respuesta.id = cliente.getClienteId();
        respuesta.message = "El cliente fue creado con exito";

        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> actualizarCliente(@PathVariable Integer id, @RequestBody InfoClienteAActualizar infoCliente) throws ClienteDNIException {

        Cliente cliente = service.traerClientePorId(id);

        cliente.setNombre(infoCliente.nombre);
        cliente.setDni(infoCliente.dni);
        cliente.setDireccion(infoCliente.direccion);
        cliente.setDireccionAlternativa(infoCliente.direccionAlternativa);
        cliente.setFechaNacimiento(infoCliente.fechaNacimiento);

        service.actualizarCliente();

        GenericResponse respuesta = new GenericResponse();

        respuesta.isOk = true;
        respuesta.id = cliente.getClienteId();
        respuesta.message = "Los datos del cliente han sido actualizados";
        
        return ResponseEntity.ok(respuesta);
    }
    
}
