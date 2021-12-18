package com.example.proyecto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class TempPres {
    @Id
    private String id;
    private Float temperatura;
    private Boolean presencia_anterior;
    private Boolean presencia_actual;
    private String timestamp;
}
