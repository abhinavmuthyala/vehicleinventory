package com.vehicleinventory.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.vehicleinventory.pojo.Inventory;

@Repository
public class VehicleJdbcRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());


		@Autowired
		JdbcTemplate jdbcTemplate;
		class InventoryRowMapper implements RowMapper<Inventory> {
			@Override
			public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {
				Inventory vehicle = new Inventory();
				vehicle.setvId(rs.getInt("vid"));
				vehicle.setVName(rs.getString("vname"));
				vehicle.setVName(rs.getString("vinfo"));
				return vehicle;
			}

		}

		public List<Inventory> findAll() {
			logger.info("Getting all the inventory info");
			return jdbcTemplate.query("select * from vehicleinventory", new InventoryRowMapper());
		}
		
		public Inventory findByvId(int id) {
			logger.info("Getting inventory based on ID::" +id);
			return jdbcTemplate.queryForObject("select * from vehicleinventory where vid=?", new Object[] { id },
					new BeanPropertyRowMapper<Inventory>(Inventory.class));
		}
			public int deleteById(int id) {
				logger.info("Deleting the inventory with id ::" +id);
				return jdbcTemplate.update("delete from vehicleinventory where vid=?", new Object[] { id });
			}

			public int insert(Inventory vehicle) {
				logger.info("Inserting the new inventory ::" +vehicle.toString());
				return jdbcTemplate.update("insert into vehicleinventory (vid, vname,vinfo) " + "values(?,  ?, ?)",
						new Object[] { vehicle.getvId(), vehicle.getName(), vehicle.getVinfo() });
			}

			public int update(Inventory vehicle) {
				logger.info("Updating the inventory : " +vehicle.toString());
				return jdbcTemplate.update("update vehicleinventory " + " set vname = ?, vinfo = ? " + " where vid = ?",
						new Object[] { vehicle.getName(), vehicle.getVinfo(), vehicle.getvId() });
			}
		}


