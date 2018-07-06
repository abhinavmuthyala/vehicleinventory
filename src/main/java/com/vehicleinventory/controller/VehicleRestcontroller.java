package com.vehicleinventory.controller;

import org.springframework.web.bind.annotation.RestController;

import com.vehicleinventory.dao.VehicleJdbcRepository;
import com.vehicleinventory.pojo.Inventory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/inventory/vinfo")
public class VehicleRestcontroller {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	VehicleJdbcRepository vehiclerepo;

	@RequestMapping(value = "/getinfo", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" }, consumes = { "application/json", "application/xml" })
	public @ResponseBody Inventory processXMLJsonRequest(@RequestBody Inventory vehicle) throws Exception {
		logger.info("Request " + vehicle.toString());
		return (Inventory) vehiclerepo.findAll();
	}

	@RequestMapping(value = "/{id}", produces = "application/json")
	    public @ResponseBody Inventory getvehiclebyId(@PathVariable int id) {
	        return vehiclerepo.findByvId(id);
	    }

}