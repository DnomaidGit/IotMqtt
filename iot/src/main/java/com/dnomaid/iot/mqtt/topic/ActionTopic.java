package com.dnomaid.iot.mqtt.topic;

public interface ActionTopic {
	String getValueTopic(String valueName);
    enum valueName {power, temperature, humidity, battery, none}
}
