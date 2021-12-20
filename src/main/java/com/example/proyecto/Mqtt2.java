package com.example.proyecto;

import com.example.proyecto.repository.tempresRepository;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public class Mqtt2 implements MqttCallback {

    tempresRepository repository;

    private static final String brokerUrl ="tcp://54.198.125.210:1883";

    private static final String clientId = "ClienteDiego";

    private static final String topic = "TOPIC_TEMP_PRES";

    public void subscribe() {

        MemoryPersistence persistence = new MemoryPersistence();
        try
        {
            MqttClient sampleClient = new MqttClient(brokerUrl, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("checking");
            System.out.println("Mqtt Connecting to broker: " + brokerUrl);
            sampleClient.connect(connOpts);
            System.out.println("Mqtt Connected");
            sampleClient.setCallback(this);
            sampleClient.subscribe(topic);
            System.out.println("Subscribed");
            System.out.println("Listening");
        } catch (MqttException me) {
            System.out.println(me);
        }
    }

    public void connectionLost(Throwable arg0) {
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }

    public void messageArrived(String topic, MqttMessage message) {


        System.out.println("Topic:" + topic);


        String datos;
        datos = message.toString();
        /* Parseamos la data */
        String[] parse = datos.split(",");
        String temperatura = parse[0].substring(16, 20);
        String pres_act = parse[1].substring(21, 26);

        String pres_ant = parse[2].substring(23, 28);

        String timestamp = parse[3].substring(15, 34);
        /* Asignamos los tipos de datos adecuados a la data para el repositorio */
        Double temp_float = Double.parseDouble(temperatura);
        System.out.println(temp_float);

        Boolean bol_pres_act;
        if (pres_act.equals("false"))
            bol_pres_act = false;
        else
            bol_pres_act = true;
        System.out.println(bol_pres_act);

        Boolean bol_pres_ant;
        if (pres_ant.equals("false"))
            bol_pres_ant = false;
        else
            bol_pres_ant = true;
        System.out.println(bol_pres_ant);
        System.out.println(timestamp);

        /* Iniciamos la entidad tempres y colocamos datos en el mongodb */
        /*TempPres tempPres = new TempPres(temp_float,bol_pres_act, bol_pres_ant, timestamp);

         */
        /*tempPres.setId(1);
        tempPres.setTemperatura(temp_float);
        tempPres.setPresencia_actual(bol_pres_act);
        tempPres.setPresencia_anterior(bol_pres_ant);
        tempPres.setTimestamp(timestamp);*/
        TempPres nuevo = new TempPres("1", 20.0, true, false, "20-20-20");

        repository.save(nuevo);
        System.out.println("Message: " +message.toString());

    }






}


