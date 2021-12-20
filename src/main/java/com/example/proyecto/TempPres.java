package com.example.proyecto;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Data
@Document
public class TempPres {
    @Id
    private Integer id;
    private Double temperatura;
    private Boolean presencia_actual;
    private Boolean presencia_anterior;
    private String timestamp;

    public TempPres(Double temperatura,
                    Boolean presencia_actual,
                    Boolean presencia_anterior,
                    String timestamp) {
        this.temperatura = temperatura;
        this.presencia_actual = presencia_actual;
        this.presencia_anterior = presencia_anterior;
        this.timestamp = timestamp;
    }
}
