package com.dnomaid.iot.mqtt.topic.json;

import com.dnomaid.iot.mqtt.topic.ActionTopic;

public class SonoffS20Json implements ActionTopic {
    //../cmnd/Relay0x/PowerRetain message: "ON" --> enable MQTT power retain on status update

	private String POWER;

	public SonoffS20Json() {
		this.POWER = "NONE";
	}

	public String getPOWER() { return POWER; }
	public void setPOWER(String pOWER) { POWER = pOWER; }

	@Override
	public String getValueTopic(String valueName) {
		String str = valueName;
		switch (str) {
			case "power":
				str = String.valueOf(getPOWER());
				break;
			default:
				System.out.println("Error");
		}
		return str;
	}
}
