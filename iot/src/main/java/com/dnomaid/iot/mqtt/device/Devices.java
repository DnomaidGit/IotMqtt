package com.dnomaid.iot.mqtt.device;

import java.util.ArrayList;

import com.dnomaid.iot.mqtt.global.Constants;
import com.dnomaid.iot.mqtt.topic.TopicJson;
import com.dnomaid.iot.mqtt.topic.TopicNoJson;
import com.dnomaid.iot.mqtt.topic.json.*;
import com.dnomaid.iot.mqtt.topic.noJson.POWER;
import com.dnomaid.iot.mqtt.topic.noJson.Set;

public class Devices implements Constants {	
    private ArrayList<Device> Devices;
    private ArrayList<Device> Relays;
    private ArrayList<Device> SensorsClimate;

    private static Devices myGlobal = null;

    public  static synchronized Devices getInst() {
        if (myGlobal==null) {
            myGlobal=new Devices();
        }
        return myGlobal;
    }    
    Devices(){		
		Devices  = new ArrayList<>();
		Relays  = new ArrayList<>();
		SensorsClimate  = new ArrayList<>();
		selectDevice(nameTypeDevice.SonoffS20, "1", "1");
		selectDevice(nameTypeDevice.SonoffS20, "2", "1");
		selectDevice(nameTypeDevice.SonoffS20, "3", "1");
		selectDevice(nameTypeDevice.SonoffS20, "4", "1");
		selectDevice(nameTypeDevice.SonoffS20, "5", "1");
		selectDevice(nameTypeDevice.SonoffSNZB02, "1", "1");
		selectDevice(nameTypeDevice.AqaraTemp, "1", "1");
		selectDevice(nameTypeDevice.TuyaZigBeeSensor, "1", "1");
		selectDevice(nameTypeDevice.XiaomiZNCZ04LM, "1", "1");
		
    }
    public void addDevice(Device device, nameGroupList groupList){
    	Devices.add(device);
    	 switch (groupList) {
		case Relay:
			Relays.add(device);			
			break;
		case Sensor:
			SensorsClimate.add(device);						
			break;	
		case SensorClimate:
			SensorsClimate.add(device);						
			break;
		case RelaySensorClimate:
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
	
	public void selectDevice (nameTypeDevice typeList, String numberDevice, String number){
		String nametopic01 = "";
		String nametopic02 = "";
		String nameDevice = typeList+"_"+numberDevice;
		nameGroupList groupList;
		TopicNoJson topicNoJson01;
		TopicNoJson topicNoJson02;
		TopicJson topicJson01;
		Device device;
		
		switch (typeList) {
		case SonoffS20:
			groupList = nameGroupList.Relay;
			nametopic01 = groupList+"_"+number+"/POWER";
			nametopic02 = nametopic01;			
			topicNoJson01 = new TopicNoJson(STAT_PREFIX, nametopic01, new POWER());
			topicNoJson02 = new TopicNoJson(CMND_PREFIX, nametopic02, new POWER());
			device = createDevice(GATEWAY01,nameDevice, groupList.name(), topicNoJson01, topicNoJson02);		
			addDevice(device, groupList);
			break;
		case SonoffSNZB02:
			groupList = nameGroupList.SensorClimate;
			nametopic01 = groupList+"_"+number;
			topicJson01 = new TopicJson(STAT_PREFIX, nametopic01, new SonoffSNZB02Json());
			device = createDevice(GATEWAY02,nameDevice, groupList.name(), topicJson01);	
			addDevice(device, groupList);
			break;
		case AqaraTemp:
			groupList = nameGroupList.SensorClimate;
			nametopic01 = groupList+"_"+number;
			topicJson01 = new TopicJson(STAT_PREFIX, nametopic01, new AqaraTempJson());
			device = createDevice(GATEWAY02,nameDevice, groupList.name(), topicJson01);	
			addDevice(device, groupList);
			break;
		case TuyaZigBeeSensor:
			groupList = nameGroupList.SensorClimate;
			nametopic01 = groupList+"_"+number;
			topicJson01 = new TopicJson(STAT_PREFIX, nametopic01, new TuyaZigBeeSensorJson());
			device = createDevice(GATEWAY02,nameDevice, groupList.name(), topicJson01);	
			addDevice(device, groupList);
			break;
		case XiaomiZNCZ04LM:
			groupList = nameGroupList.RelaySensorClimate;
			nametopic01 = groupList+"_"+number;
			nametopic02 = nametopic01+"/set";
			topicJson01 = new TopicJson(MIX_PREFIX, nametopic01, new XiaomiZNCZ04LM());
			topicNoJson02 = new TopicNoJson(MIX_PREFIX, nametopic02, new Set());
			device = createDevice(GATEWAY02,nameDevice, groupList.name(), topicJson01, topicNoJson02);		
			addDevice(device, groupList);
			break;
		default:
			break;
		}
		
	}
	
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
