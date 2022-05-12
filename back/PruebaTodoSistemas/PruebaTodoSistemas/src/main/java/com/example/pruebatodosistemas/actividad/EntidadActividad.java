package com.example.pruebatodosistemas.actividad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.pruebatodosistemas.common.Response;

@Entity
@Table(name = "actividades")
public class EntidadActividad {

	private long idActividad;
	private long empleadoId;
	private int status;
	private Date fechaHoraEstimada;
	private int diasRetraso;

	public EntidadActividad() {
	}

	public EntidadActividad(long empleadoId, int status, Date fechaHoraEstimada, int diasRetraso) {
		super();
		this.empleadoId = empleadoId;
		this.status = status;
		this.fechaHoraEstimada = fechaHoraEstimada;
		this.diasRetraso = diasRetraso;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idactividad", unique = true, nullable = false)
	public long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(long idActividad) {
		this.idActividad = idActividad;
	}
	@Column(name = "empleadoid")
	public long getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(long empleadoId) {
		this.empleadoId = empleadoId;
	}
	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	@Column(name = "fechahoraestimada")
	public Date getFechaHoraEstimada() {
		return fechaHoraEstimada;
	}

	public void setFechaHoraEstimada(Date fechaHoraEstimada) {
		this.fechaHoraEstimada = fechaHoraEstimada;
	}
	@Column(name = "diasretraso")
	public int getDiasRetraso() {
		return diasRetraso;
	}

	public void setDiasRetraso(int diasRetraso) {
		this.diasRetraso = diasRetraso;
	}

}
