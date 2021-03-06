package com.dnomaid.iot;

import java.util.ArrayList;
import java.util.List;

import com.dnomaid.iot.mqtt.Mqtt;
import com.dnomaid.iot.mqtt.device.Devices;

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
		//m.publish(Devices.getInst().getRelay().get(1).getTopics().get(1).getName(),"OFF");
		//Devices.getInst().getRelay().stream().forEach(a->{m.publish(a.getTopics().get(1).getName(), "ON");});
		//m.unsubscribe();
		//m.disconnection();
		while(true){app.run();}				
	}
	@Override
    public void run() {
	try {
		Thread.sleep(1 * 5000);
			//System.out.println(Devices.getInst().getDev010Topic001().getPower().getPOWER());
		//"consumer_connected":true,"consumption":0.83,"current":0,"energy":0.83,"linkquality":23,"power":0,"state":"OFF","temperature":17,"voltage":230}
			System.out.println(Devices.getInst().getDev310Topic001().getXiaomiZNCZ04LMJson().getConsumer_connected());
			System.out.println(Devices.getInst().getDev310Topic001().getXiaomiZNCZ04LMJson().getConsumption());
			System.out.println(Devices.getInst().getDev310Topic001().getXiaomiZNCZ04LMJson().getCurrent());
			System.out.println(Devices.getInst().getDev310Topic001().getXiaomiZNCZ04LMJson().getEnergy());
			System.out.println(Devices.getInst().getDev310Topic001().getXiaomiZNCZ04LMJson().getLinkquality());
			System.out.println(Devices.getInst().getDev310Topic001().getXiaomiZNCZ04LMJson().getPower());
			System.out.println(Devices.getInst().getDev310Topic001().getXiaomiZNCZ04LMJson().getState());
			System.out.println(Devices.getInst().getDev310Topic001().getXiaomiZNCZ04LMJson().getTemperature());
			System.out.println(Devices.getInst().getDev310Topic001().getXiaomiZNCZ04LMJson().getVoltage());
	} catch (InterruptedException ex) {
		Thread.currentThread().interrupt();
	}
	}
}

