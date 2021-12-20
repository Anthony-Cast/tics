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
    private Float temperatura;
    private Boolean presencia_actual;
    private Boolean presencia_anterior;
    private String timestamp;

}
