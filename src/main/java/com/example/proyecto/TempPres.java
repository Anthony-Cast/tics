package com.example.proyecto;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Data
@Document(collection = "TempPres")
public class TempPres {
    @Id
    @NonNull
    private String id;
    private Float temperatura;
    private Boolean presencia_anterior;
    private Boolean presencia_actual;
    private String timestamp;
}
