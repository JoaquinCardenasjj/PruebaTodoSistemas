package com.example.pruebatodosistemas.actividad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository

public interface ActividadRepository extends JpaRepository<EntidadActividad, Long>{
	@Override
	  @Query(
	      value = "SELECT * FROM actividades act\r\n"
	      		+ "left join empleados emp on emp.idempleado = act.empleadoid\r\n"
	      		+ " ORDER BY idactividad DESC",
	      nativeQuery = true
	  )
	  List<EntidadActividad> findAll();
}
