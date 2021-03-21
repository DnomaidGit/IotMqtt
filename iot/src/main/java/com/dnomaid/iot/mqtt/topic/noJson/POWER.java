package com.dnomaid.iot.mqtt.topic.noJson;

import com.dnomaid.iot.mqtt.topic.ActionTopic;

public class POWER implements ActionTopic {
	private String name = "POWER";
	private String POWER;

	public String getPOWER() {
		return POWER;
	}

	public void setPOWER(String pOWER) {
		POWER = pOWER;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public String getValueTopic(String valueName) {
		String str = valueName;
		switch (str) {
			case "power":
				str = getPOWER();
				break;
			default:
				System.out.println("Error");
		}
		return str;
	}

}
