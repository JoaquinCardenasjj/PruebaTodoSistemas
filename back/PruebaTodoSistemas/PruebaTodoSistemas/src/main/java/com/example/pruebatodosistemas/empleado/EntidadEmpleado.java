package com.example.pruebatodosistemas.empleado;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.pruebatodosistemas.actividad.EntidadActividad;

@Entity
@Table(name = "empleados")
public class EntidadEmpleado {

	private long idempleado;
	private String nombrecompleto;
	private String documento;
	@OneToMany(mappedBy = "actividades")
	private Set<EntidadActividad> items;

	public EntidadEmpleado() {
	}

	public EntidadEmpleado(String nombrecompleto, String documento) {
		this.nombrecompleto = nombrecompleto;
		this.documento = documento;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idempleado", unique = true, nullable = false)
	public long getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(long idempleado) {
		this.idempleado = idempleado;
	}

	@Column(name = "nombrecompleto")
	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	@Column(name = "documento")
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
}
