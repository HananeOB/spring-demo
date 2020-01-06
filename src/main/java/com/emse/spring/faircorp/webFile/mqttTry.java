package com.emse.spring.faircorp.webFile;

import org.eclipse.paho.client.mqttv3.*;


public class mqttTry {

    private static final String MQTT_PUBLISHER_ID = "spring-server";
    private static final String MQTT_SERVER_ADDRES= "tcp://max.isasecret.com:1723";
    private static IMqttClient instance;

    public static IMqttClient getInstance() {
        try {
            if (instance == null) {
                instance = new MqttClient(MQTT_SERVER_ADDRES, MQTT_PUBLISHER_ID);

            }

            MqttConnectOptions options = new MqttConnectOptions();
            options.setPassword("Y@_oK2".toCharArray());
            options.setUserName("majinfo2019");
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);


            if (!instance.isConnected()) {
                instance.connect(options);
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }

        return instance;
    }

    private mqttTry() {

    }

}
