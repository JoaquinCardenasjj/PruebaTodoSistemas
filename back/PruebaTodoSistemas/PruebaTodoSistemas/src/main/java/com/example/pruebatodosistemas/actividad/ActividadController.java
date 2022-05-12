package com.example.pruebatodosistemas.actividad;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebatodosistemas.common.Response;


@Service
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ActividadController {

	@Autowired
	private ActividadRepository actividadRepository;

	private Response<EntidadActividad> response = new Response<EntidadActividad>();

	@GetMapping("/actividad")
	public List<EntidadActividad> getAllEmployees() {
		return actividadRepository.findAll();
	}

	@PostMapping("/actividad")
	public Response<EntidadActividad> createActivity(@Valid @RequestBody EntidadActividad actividad) {
		try {
			response.setEntidad(actividad);
			this.actividadRepository.save(actividad);
			response.setMensajeResponse("Actividad creada correctamente");
			response.setCodigoResponse(200);
			return response;
		} catch (Exception e) {
			response.setMensajeResponse(e.getMessage());
			response.setCodigoResponse(400);
			return response;
		}
	}

	@PutMapping("/actividad/{id}")
	public Response<EntidadActividad> updateActivity(@PathVariable(value = "id") Long activityId,
			@Valid @RequestBody EntidadActividad actividadDetails) {
		try {
			EntidadActividad actividad = actividadRepository.getById(activityId);

			actividad.setEmpleadoId(actividadDetails.getEmpleadoId());
			actividad.setDiasRetraso(actividadDetails.getDiasRetraso());
			actividad.setFechaHoraEstimada(actividadDetails.getFechaHoraEstimada());
			actividad.setStatus(actividadDetails.getStatus());

			final EntidadActividad updatedActivity = actividadRepository.save(actividad);
			response.setEntidad(updatedActivity);
			response.setCodigoResponse(200);
			response.setMensajeResponse("Actividad modificada exitosamente");
			return response;
		} catch (Exception e) {
			response.setMensajeResponse(e.getMessage());
			response.setCodigoResponse(400);
			return response;
		}
	}

	@DeleteMapping("/actividad/{id}")
	public Response<EntidadActividad> deleteActivity(@PathVariable(value = "id") Long activityId) {
		try {
			EntidadActividad actividadFindId = actividadRepository.findById(activityId).get();
			actividadRepository.delete(actividadFindId);
			response.setEntidad(actividadFindId);
			response.setCodigoResponse(200);
			response.setMensajeResponse("Actividad eliminada exitosamente");
			return response;
		} catch (Exception e) {
			response.setMensajeResponse(e.getMessage());
			response.setCodigoResponse(400);
			return response;
		}
	}
}
