package com.dnomaid.iot.mqtt.topic.noJson;

import com.dnomaid.iot.mqtt.topic.ActionTopic;

public class Set implements ActionTopic{
	private String name = "Set";
	private String Set;

	public String getSet() {
		return Set;
	}

	public void setSet(String set) {
		Set = set;
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
				str = getSet();
				break;
			default:
				System.out.println("Error");
		}
		return str;
	}

}
