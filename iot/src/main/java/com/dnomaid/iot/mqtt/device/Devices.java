package com.dnomaid.iot.mqtt.device;

import java.util.ArrayList;

import com.dnomaid.iot.mqtt.global.Constants;
import com.dnomaid.iot.mqtt.topic.TopicJson;
import com.dnomaid.iot.mqtt.topic.TopicNoJson;
import com.dnomaid.iot.mqtt.topic.json.*;
import com.dnomaid.iot.mqtt.topic.noJson.Hum;
import com.dnomaid.iot.mqtt.topic.noJson.POWER;
import com.dnomaid.iot.mqtt.topic.noJson.Set;
import com.dnomaid.iot.mqtt.topic.noJson.Temp;

public class Devices implements Constants {	
    private ArrayList<Device> Devices;
    private ArrayList<Device> Relays;
    private ArrayList<Device> SensorsClimate;
    private Device Device010,Device020,Device030,Device040,Device050;
    private Device Device110;
	private Device Device120;
	private Device Device130;
	private Device Device210;	
	private Device Device310;	

    private TopicNoJson dev010Topic001,dev010Topic002;
    private TopicNoJson dev020Topic001,dev020Topic002;
    private TopicNoJson dev030Topic001,dev030Topic002;
    private TopicNoJson dev040Topic001,dev040Topic002;
    private TopicNoJson dev050Topic001,dev050Topic002;
    private TopicJson dev110Topic001;
    private TopicJson dev120Topic001;
    private TopicJson dev130Topic001;
    private TopicNoJson dev210Topic001,dev210Topic002;
    private TopicJson dev310Topic001;
    private TopicNoJson dev310Topic002;
    

    private static Devices myGlobal = null;

    public  static synchronized Devices getInst() {
        if (myGlobal==null) {
            myGlobal=new Devices();
        }
        return myGlobal;
    }    
    Devices(){
    	//Relays
		dev010Topic001 = new TopicNoJson(STAT_PREFIX, RELAY011, new POWER());
		dev010Topic002 = new TopicNoJson(CMND_PREFIX, RELAY011, new POWER());
		Device010 = createDevice(GATEWAY01,DEVICE010, namegroupList.Relay.name(), dev010Topic001, dev010Topic002);		
		dev020Topic001 = new TopicNoJson(STAT_PREFIX,  RELAY021, new POWER());
		dev020Topic002 = new TopicNoJson(CMND_PREFIX, RELAY021, new POWER());		
		Device020 = createDevice(GATEWAY01,DEVICE020, namegroupList.Relay.name(), dev020Topic001, dev020Topic002);
		dev030Topic001 = new TopicNoJson(STAT_PREFIX, RELAY031, new POWER());
		dev030Topic002 = new TopicNoJson(CMND_PREFIX, RELAY031, new POWER());		
		Device030 = createDevice(GATEWAY01,DEVICE030, namegroupList.Relay.name(), dev030Topic001, dev030Topic002);		
		dev040Topic001 = new TopicNoJson(STAT_PREFIX, RELAY041, new POWER());
		dev040Topic002 = new TopicNoJson(CMND_PREFIX, RELAY041, new POWER());		
		Device040 = createDevice(GATEWAY01,DEVICE040, namegroupList.Relay.name(), dev040Topic001, dev040Topic002);
		dev050Topic001 = new TopicNoJson(STAT_PREFIX, RELAY051, new POWER());
		dev050Topic002 = new TopicNoJson(CMND_PREFIX, RELAY051, new POWER());		
		Device050 = createDevice(GATEWAY01,DEVICE050, namegroupList.Relay.name(), dev050Topic001, dev050Topic002);
		//Sensor
		dev110Topic001 = new TopicJson(STAT_PREFIX,SENSOR111,new SonoffSNZB02Json());
		Device110 = createDevice(GATEWAY02,DEVICE110, namegroupList.SensorClimate.name(), dev110Topic001);
		dev120Topic001 = new TopicJson(STAT_PREFIX,SENSOR121,new AqaraTempJson());		
		Device120 = createDevice(GATEWAY02,DEVICE120, namegroupList.SensorClimate.name(), dev120Topic001);
		dev130Topic001 = new TopicJson(STAT_PREFIX,SENSOR131,new TuyaZigBeeSensorJson());
		Device130 = createDevice(GATEWAY02,DEVICE130, namegroupList.SensorClimate.name(), dev130Topic001);
		//Relay/Sensor
		dev310Topic001 = new TopicJson(MIX_PREFIX, SENSOR311, new XiaomiZNCZ04LM());
		dev310Topic002 = new TopicNoJson(MIX_PREFIX, RELAY311, new Set());		
		Device310 = createDevice(GATEWAY02,DEVICE310, namegroupList.RelaySensorClimate.name(), dev310Topic001, dev310Topic002);
		
		Devices  = new ArrayList<>();
		Relays  = new ArrayList<>();
		SensorsClimate  = new ArrayList<>();
		
		addDevice(Device010, namegroupList.Relay.name());
		addDevice(Device020, namegroupList.Relay.name());
		addDevice(Device030, namegroupList.Relay.name());
		addDevice(Device040, namegroupList.Relay.name());
		addDevice(Device050, namegroupList.Relay.name());
		addDevice(Device110, namegroupList.SensorClimate.name());
		addDevice(Device120, namegroupList.SensorClimate.name());
		addDevice(Device130, namegroupList.SensorClimate.name());
		addDevice(Device310, namegroupList.RelaySensorClimate.name());
		
    }
    public void addDevice(Device device, String groupList){
    	Devices.add(device);
    	 switch (groupList) {
		case "Relay":
			Relays.add(device);			
			break;
		case "SensorClimate":
			SensorsClimate.add(device);						
			break;
		case "RelaySensorClimate":
			Relays.add(device);			
			SensorsClimate.add(device);						
			break;
		default:
			break;
		}
    	
    }
    
	public ArrayList<Device> getDevices() {return Devices;}
	public ArrayList<Device> getRelays() {return Relays;}
	public ArrayList<Device> getSensors() {return SensorsClimate;}
	
	public Device createDevice(String gateway, String typeDevice, String groupList, TopicNoJson topic01, TopicNoJson topic02){
		Device device = new Device(gateway,typeDevice,groupList);
		device.addTopic(topic01);
		device.addTopic(topic02);
		return device;
	}
	
	public Device createDevice(String gateway, String typeDevice, String groupList, TopicJson topic01){
		Device device = new Device(gateway,typeDevice, groupList);
		device.addTopic(topic01);		
		return device;
	}

	public Device createDevice(String gateway, String typeDevice, String groupList, TopicJson topic01, TopicNoJson topic02){
		Device device = new Device(gateway,typeDevice,groupList);
		device.addTopic(topic01);
		device.addTopic(topic02);
		return device;
	}	
	
        
}
