package com.example.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "temp_pres")
public class TempPresDTO {
	
	@Id
	private String _id;
	
	private Float temperatura;
	
	private Boolean presencia_actual;
	
	private Boolean presencia_anterior;

	private String timestamp;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Float temperatura) {
		this.temperatura = temperatura;
	}

	public Boolean getPresencia_actual() {
		return presencia_actual;
	}

	public void setPresencia_actual(Boolean presencia_actual) {
		this.presencia_actual = presencia_actual;
	}

	public Boolean getPresencia_anterior() {
		return presencia_anterior;
	}

	public void setPresencia_anterior(Boolean presencia_anterior) {
		this.presencia_anterior = presencia_anterior;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
