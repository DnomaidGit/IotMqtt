package com.dnomaid.iot;

import java.util.ArrayList;
import java.util.List;

import com.dnomaid.iot.mqtt.Mqtt;
import com.dnomaid.iot.mqtt.device.Devices;
import com.dnomaid.iot.mqtt.topic.ActionTopic.TypeTopic;

public class App implements Runnable {
	static List <String> lista=new ArrayList<>(); 
	public static void main(String[] args) {	    
		App app= new App();
		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");
		lista.add("5");
		Mqtt m = new Mqtt();
		m.connection();
		m.subscribe();
		//m.publish(Devices.getInst().getRelays().get(5).getTopics().get(1).getName(),"ON");
		//Devices.getInst().getRelay().stream().forEach(a->{m.publish(a.getTopics().get(1).getName(), "ON");});
		//m.unsubscribe();
		//m.disconnection();
		while(true){app.run();}				
	}
	@Override
    public void run() {
	try {
		Thread.sleep(1 * 5000);

			System.out.println("Relay1: "+Devices.getInst().getRelays().get(0).getTopics().get(0).getValueTopic(TypeTopic.Power));
			System.out.println("Relay2: "+Devices.getInst().getRelays().get(1).getTopics().get(0).getValueTopic(TypeTopic.Power));
			System.out.println("Relay3: "+Devices.getInst().getRelays().get(2).getTopics().get(0).getValueTopic(TypeTopic.Power));
			System.out.println("Relay4: "+Devices.getInst().getRelays().get(3).getTopics().get(0).getValueTopic(TypeTopic.Power));
			System.out.println("Relay5: "+Devices.getInst().getRelays().get(4).getTopics().get(0).getValueTopic(TypeTopic.Power));
			System.out.println("Relay6: "+Devices.getInst().getRelays().get(5).getTopics().get(0).getValueTopic(TypeTopic.Power));
			System.out.println("SensorTemp1: "+Devices.getInst().getSensors().get(0).getTopics().get(0).getValueTopic(TypeTopic.Temperature));
			System.out.println("SensorHum2: "+Devices.getInst().getSensors().get(0).getTopics().get(0).getValueTopic(TypeTopic.Humidity));
			System.out.println("SensorTemp3: "+Devices.getInst().getSensors().get(1).getTopics().get(0).getValueTopic(TypeTopic.Temperature));
			System.out.println("SensorHum4: "+Devices.getInst().getSensors().get(1).getTopics().get(0).getValueTopic(TypeTopic.Humidity));
			System.out.println("SensorTemp5: "+Devices.getInst().getSensors().get(2).getTopics().get(0).getValueTopic(TypeTopic.Temperature));            
			System.out.println("SensorHum6: "+Devices.getInst().getSensors().get(2).getTopics().get(0).getValueTopic(TypeTopic.Humidity));
			System.out.println("SensorTemp7: "+Devices.getInst().getSensors().get(3).getTopics().get(0).getValueTopic(TypeTopic.Temperature));

			
	} catch (InterruptedException ex) {
		Thread.currentThread().interrupt();
	}
	}
}

