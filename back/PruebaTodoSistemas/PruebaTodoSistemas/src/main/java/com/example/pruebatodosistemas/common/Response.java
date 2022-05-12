package com.example.pruebatodosistemas.common;

public class Response<T> {
	private T entidad;
	private String mensajeResponse;
	private int codigoResponse;

	public String getMensajeResponse() {
		return mensajeResponse;
	}

	public void setMensajeResponse(String mensajeResponse) {
		this.mensajeResponse = mensajeResponse;
	}

	public int getCodigoResponse() {
		return codigoResponse;
	}

	public void setCodigoResponse(int codigoResponse) {
		this.codigoResponse = codigoResponse;
	}

	public T getEntidad() {
		return entidad;
	}

	public void setEntidad(T entidad) {
		this.entidad = entidad;
	}
}
