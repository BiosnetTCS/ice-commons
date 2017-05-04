package com.biosnettcs.core;


/**
 * 
 * @author Ricardo
 * 
 */
public interface ProcesoResultadoDAO {

	/**
	 * Obtiene el mensaje de respuesta de los servicios de Acceso a Datos
	 * 
	 * @param msgId
	 * @param log
	 * @param cdUsuario
	 * @param dsPrograma
	 * @return Mensaje de respuesta
	 */
	public String obtieneMensaje(String msgId, String log, String cdUsuario, String dsPrograma) 
			throws DaoException;

}