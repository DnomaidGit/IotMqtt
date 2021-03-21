package com.dnomaid.iot.mqtt.topic;

import com.dnomaid.iot.mqtt.topic.noJson.Hum;
import com.dnomaid.iot.mqtt.topic.noJson.POWER;
import com.dnomaid.iot.mqtt.topic.noJson.Set;
import com.dnomaid.iot.mqtt.topic.noJson.Temp;

public class TopicNoJson extends Topic {
	
	public TopicNoJson(String idFunc, String name, Object type) {
		super(idFunc, name, type);
		setTypeJson(false);
	}
			
	private boolean isTypeNoJsonException(String nameNoJsonClass){
		boolean test = false;
			try {
				if(isTypeJson()){
					throw new Exception("Is type Json: " + getName());
				}else{
					if(!nameNoJsonClass.equals(getType().getClass().getName())) 
						throw new Exception("Is diferent type: " + getName());
				}	
				test = true;
			} catch (Exception e) {
				test = false;
				System.out.println("Error "+ e);
			}	
		return test;
	}
	
	public String getCast(){
		String str="--";
		Object obj = getType(); 
		if (obj instanceof Hum) str="Hum"; 
		if (obj instanceof POWER) str="POWER"; 
		if (obj instanceof Set) str="Set"; 
		if (obj instanceof Temp) str="Temp"; 
		return str;
	}
			
	public String getValueTopic(String valueName) {	
		String value = "--.--";
		String str = getCast();
		switch (str) {
		case "POWER":
			POWER power=new POWER();
			if(isTypeNoJsonException(POWER.class.getName()))power = (POWER)getType();			
			value = power.getValueTopic(valueName);
			break;
		case "Hum":
			Hum hum=new Hum();
			if(isTypeNoJsonException(Hum.class.getName()))hum = (Hum)getType();						
			value = hum.getValueTopic(valueName);
			break;
		case "Set":
			Set set=new Set();
			if(isTypeNoJsonException(Set.class.getName()))set = (Set)getType();						
			value = set.getValueTopic(valueName);
			break;
		case "Temp":
			Temp temp=new Temp();
			if(isTypeNoJsonException(Temp.class.getName()))temp = (Temp)getType();						
			value = temp.getValueTopic(valueName);
			break;									
		default:
			value = "??¿¿";
			break;
		}
		return value;		
	}	
}
