package com.example.pruebatodosistemas.empleado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpleadoRepository extends JpaRepository<EntidadEmpleado, Long>{
	@Override
	  @Query(
	      value = "SELECT *  FROM empleados ORDER BY idempleado ASC ",
	      nativeQuery = true
	  )
	  List<EntidadEmpleado> findAll();
}
