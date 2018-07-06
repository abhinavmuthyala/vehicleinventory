package com.vehicleinventory.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@XmlRootElement(name = "vehicle")
@XmlType(propOrder = { "vid", "vname", "vinfo" })
@JsonPropertyOrder({ "vid", "vname", "vinfo" })
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer vId;
	
	private String VName;
	private String Vinfo;
	@XmlElement
	public Integer getvId() {
		return vId;
	}

	public void setvId(Integer vId) {
		this.vId = vId;
	}
	@XmlElement
	public String getName() {
		return VName;
	}

	public void setVName(String vName) {
		VName = vName;
	}
	@XmlElement
	public String getVinfo() {
		return Vinfo;
	}

	public void setVinfo(String vinfo) {
		Vinfo = vinfo;
	}
	
	@JsonIgnore
	public String toString() {
		return "Inventory [vId=" + vId + ", VName=" + VName + ", Vinfo=" + Vinfo + "]";
	}
	
	public Inventory() {}
    public Inventory(int id, String name, String graduationTime) {
        this.vId = id;
        this.VName = name;
        this.Vinfo = graduationTime;
    }

}

