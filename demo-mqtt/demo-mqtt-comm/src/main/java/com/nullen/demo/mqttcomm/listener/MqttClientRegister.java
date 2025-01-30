package com.nullen.demo.mqttcomm.listener;

import com.nullen.demo.mqttcomm.callback.MqttCallback;
import com.nullen.demo.mqttcomm.manager.MqttClientManager;
import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import javax.annotation.PostConstruct;

/**
 * @author Nullen
 */
@RequiredArgsConstructor
public class MqttClientRegister {

    private final String mqttServerUri;
    private final String clientId;

    @PostConstruct
    void connect() {
        try {
            MqttClient mqttClient = new MqttClient(mqttServerUri, clientId);
            // 配置回调类
            mqttClient.setCallback(new MqttCallback());
            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
            mqttConnectOptions.setCleanSession(true);
            mqttConnectOptions.setUserName(mqttServerUri);
            mqttClient.connect(mqttConnectOptions);
            MqttClientManager.addMqttClient(clientId, mqttClient);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }

    }
}
