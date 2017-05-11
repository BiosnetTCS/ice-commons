package com.biosnettcs.core.dao.impl;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.biosnettcs.core.DaoException;
import com.biosnettcs.core.dao.AbstractManagerDAO;
import com.biosnettcs.core.dao.ProcesoResultadoDAO;

public class ProcesoResultadoDAOImpl extends AbstractManagerDAO implements ProcesoResultadoDAO {

	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(ProcesoResultadoDAOImpl.class);

    protected class ObtieneMensajeSP extends StoredProcedure {
    	
    	protected ObtieneMensajeSP(DataSource dataSource) {
    		super(dataSource, "PKG_TRADUC.P_OBTIENE_MENSAJE");
			declareParameter(new SqlParameter("pv_msg_id_i", Types.NUMERIC));
			declareParameter(new SqlParameter("pv_log_i", Types.NUMERIC));
			declareParameter(new SqlParameter("pv_cdusuario_i", Types.VARCHAR));
			declareParameter(new SqlParameter("pv_dsprograma_i", Types.VARCHAR));
			declareParameter(new SqlOutParameter("pv_msg_text_o", Types.VARCHAR));
			declareParameter(new SqlOutParameter("pv_title_o", Types.VARCHAR));
			compile();
    	}
    	
    }


    @Override
	public String obtieneMensaje(String msgId, String log, String cdUsuario, String dsPrograma) throws DaoException {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("pv_msg_id_i", msgId);
			params.put("pv_log_i", log);
			params.put("pv_cdusuario_i", cdUsuario);
			params.put("pv_dsprograma_i", dsPrograma);
			
			Map<String, Object> mapResult = new ObtieneMensajeSP(getDataSource()).execute(params);
			
	        return mapResult.get("pv_msg_text_o").toString();
        
		} catch(Exception e) {
        	throw new DaoException(e.getMessage(), e);
        }
	}

}