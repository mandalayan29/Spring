package com.ayan.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="device")
public class Device {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="device_id")
	private int deviceId;
	
	@Column(name="device_name")
	private String deviceName;
	
	public Device() {
		super();
	}
	
	public Device(String deviceName) {
		super();
		this.deviceName = deviceName;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", deviceName=" + deviceName + "]";
	}
	
}
