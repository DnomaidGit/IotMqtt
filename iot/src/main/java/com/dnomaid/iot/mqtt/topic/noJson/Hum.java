package com.dnomaid.iot.mqtt.topic.noJson;

import com.dnomaid.iot.mqtt.topic.ActionTopic;

public class Hum implements ActionTopic
{
	private String name = "Hum";
	private String Hum;

	public String getHum() {
		return Hum;
	}

	public void setHum(String temp) {
		Hum = temp;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public String getValueTopic(String valueName) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
