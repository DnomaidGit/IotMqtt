package com.dnomaid.iot.mqtt.global;

public interface Constants {
    String ID= "Dnomaid";
    String STAT_PREFIX=ID+"/stat";
    String CMND_PREFIX=ID+"/cmnd";
    String MIX_PREFIX=ID+"/mix";
    
    enum TypeGateway {Router_1, CC2531_1}
    enum TypeDevice {SonoffS20, SonoffSNZB02, AqaraTemp, XiaomiZNCZ04LM,TuyaZigBeeSensor}
    enum GroupList {Relay, SensorClimate, RelaySensorClimate}
    
}
