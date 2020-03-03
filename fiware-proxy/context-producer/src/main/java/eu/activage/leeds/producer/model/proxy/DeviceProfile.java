/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.model.proxy;

/*

  @author te0003
 */
import java.util.List;

public class DeviceProfile {

    private String user;
    private String mac;
    private String gearSerialNumber;
    private String electricalMonitorId;
    private String electricMonitorLabel;
    private String phoneIMEI;
    private List<Device> devices = null;    
   
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getGearSerialNumber() {
        return gearSerialNumber;
    }

    public void setGearSerialNumber(String gearSerialNumber) {
        this.gearSerialNumber = gearSerialNumber;
    }

    public String getElectricalMonitorId() {
        return electricalMonitorId;
    }

    public void setElectricalMonitorId(String electricalMonitorId) {
        this.electricalMonitorId = electricalMonitorId;
    }

    public String getElectricMonitorLabel() {
        return electricMonitorLabel;
    }

    public void setElectricMonitorLabel(String electricMonitorLabel) {
        this.electricMonitorLabel = electricMonitorLabel;
    }

    public String getPhoneIMEI() {
        return phoneIMEI;
    }

    public void setPhoneIMEI(String phoneIMEI) {
        this.phoneIMEI = phoneIMEI;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

}
