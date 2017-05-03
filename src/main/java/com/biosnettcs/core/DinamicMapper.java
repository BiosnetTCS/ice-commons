package com.biosnettcs.core;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

public class DinamicMapper implements RowMapper<Map<String, String>> {
	
	private final static Logger logger = LoggerFactory.getLogger(DinamicMapper.class);

	@Override
	public Map<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		logger.debug("rs:{} rowNum:{}", rs, rowNum);
		
		String cols = "";
		Map<String,String> map = new LinkedHashMap<String,String>(0);
		ResultSetMetaData metaData = rs.getMetaData();
		int numCols = metaData.getColumnCount();
		for (int i=1; i <= numCols; i++) {
			String col=metaData.getColumnName(i);
			if(rowNum == 0) {
				cols = cols + col + ",";
			}
			if (col != null
					&& (col.substring(0, 2).equalsIgnoreCase("fe") || col.substring(0, 2).equalsIgnoreCase("ff"))) {
				map.put(col, Utils.formateaFecha(rs.getString(col)));
			} else {
				map.put(col, rs.getString(col));
			}
		}
		if(rowNum==0) {
			logger.debug("Columnas: {}", cols);
		}
		return map;
	}
}