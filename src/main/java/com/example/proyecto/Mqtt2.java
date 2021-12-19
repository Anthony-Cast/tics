package com.example.proyecto;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Mqtt2 implements MqttCallback {
    @Override
    public void connectionLost(Throwable throwable) {
    }
    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
    }
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }

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







}
