package ar.com.ada.api.creditos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.entities.Prestamo;
import ar.com.ada.api.creditos.repos.PrestamoRepository;

@Service
public class PrestamoService {

    @Autowired
    PrestamoRepository repo;

    @Autowired
    ClienteService clienteService;

    public void crearPrestamo(Prestamo prestamo) {

        Prestamo prestamoNuevo = new Prestamo();

        Cliente cliente = clienteService.traerClientePorId(prestamoNuevo.getCliente().getClienteId());

        prestamoNuevo.setCliente(cliente);

        prestamoNuevo = repo.save(prestamoNuevo);

        cliente.agregarPrestamo(prestamoNuevo);
    }
    
}
