package com.dnomaid.iot.mqtt.topic.noJson;

import com.dnomaid.iot.mqtt.topic.ActionTopic;

public class Temp implements ActionTopic {
	private String name = "Temp";
	private String Temp;

	public String getTemp() {
		return Temp;
	}

	public void setTemp(String temp) {
		Temp = temp;
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
