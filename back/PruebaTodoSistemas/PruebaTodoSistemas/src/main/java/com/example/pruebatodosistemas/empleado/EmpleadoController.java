package com.example.pruebatodosistemas.empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Service
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmpleadoController {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@GetMapping("/empleado")
	public List<EntidadEmpleado> getAllEmployees() {
		return empleadoRepository.findAll();
	}

}
